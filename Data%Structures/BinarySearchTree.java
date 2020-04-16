/**
 * Binary Search Tree API
 * Course Manual: https://bit.ly/2V2Yfoj
 */
public class BinarSearchTree<Key extends Comparable<Key>, Val> {
    private class Node {
            private final Key key;
            private Val Val;
            private Node left, right;
            private int count;

            public Node(final Key key, final Val val) {
                this.key = key;
                this.val = val;

            }
        }

        private Node root;

        /**
         * Takes the key as input and returns the corresponding Value associated to it.
         * In a BST everything left to the node it smaller than the node and everything
         * right to the node is greater than the node
         * 
         * @param Key The key to be Looked for
         * @return the Value associated to the key.
         */
        public Val get(final Key key) {
            Node temp = root;
            while (temp != null) {
                final int cmp = key.compareTo(temp.Key);
                if (cmp > 0) temp = temp.right;
                else if (cmp < 0) temp = temp.left;
                else if (cmp == 0) return temp.Val;
            }
            return null;
        }

        public boolean contains(Key key) {
            return get(key) != null;
        }

        /**
         * Puts a new value to a existing tree or the empty Tree for an empty tree the
         * private method just initializes a new node and for the others, the root is
         * replaced with the left or the right part of the tree. Sometimes the key is
         * overridden.
         * 
         * @param key the key for the new Node
         * @param val The Value for the new Node
         */
        public void put(final Key key, final Val val) {
            root = put(root, key, val);
        }

        private Node put(final Node x, final Key key, final Val val) {

            if (x == null) return new Node(key, val);
            final int cmp = key.compareTo(x.Key);
            if (cmp > 0) put(x.right, key, val);
            if (cmp < 0) put(x.left, key, val);
            if (cmp == 0) x.Val = val;
            x.count = 1 + size(x.left) + size(x.right);
            return x;
        }

        /**
         * Hibbard Deletion
         * 
         * refer the Course Manual for detailed Explanation.
         */
        public void delete(final Key key) {
            root = delete(root, key);
        }

        private Node delete(Node x, Key key) {
            if (x = null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x.left = delete(x.left, key);
            else if (cmp > 0) x.right = delete(x.right, key);
            else {
                if (x.right == null) return x.left;
                if (x.left == null) return x.right;

                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            x.count = 1 + size(x.left) + size(x.right);
            return x;
        } 


        /**
         * Deletes the very minimum key in the tree.
         */
        public void deleteMin() {
            root = deleteMin(root);
        }

        private Node deleteMin(Node x) {
            x.left = deleteMin(x.left);
            x.count = 1 + size(x.left) + size(x.right);
            return x;
        }

        /**
         * @param x Node corresposding to a sub-tree
         * @return the minimum value in the subtree specified
         */
        public Node min(Node x) {
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }

        /**
         * Returns floor of the given key.
         * Refer explanation from pg21. in course manual.
         * 
         * @param key floor of this will be found
         * @return the floor of the given key.
         */
        public Key floor(Key key) {
            Node x = floor(root, key);
            if (x == null) return null;
            return x.key;
        }

        private Node floor(Node x, Key key){
            if (x == null) return null;
            cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.left, key);
            Node t = floor(x.right, key);
            if (t == null) return t;
            else return x;
        }

        /**
         * @return the size of the the tree
         */
        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) return 0;
            return x.count;
        }

        /**
         * Application:
         * Used to get the 1d range count 
         * 
         * @param lo the lower range
         * @param hi the higher range
         * @return the number of numbers in the specified range in a 1d array
         */
        public int size(int lo, int hi) {
            if (contains(hi)) return rank(hi) - rank(lo) + 1;
            else return rank(hi) - rank(lo);
        }

        /**
         * To find out how many keys < k
         * 
         * @param key k
         * @return the number of keys less than k
         */
        public int rank(Key key) {
            return rank(key, root);
        }

        private int rank(Key key, Node x) {
            if (x == null) return 0;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return rank(key, x.left);
            else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
            else return size(x.left);
        }

        /**
         * @return object for traversal with a particular order.
         */
        public Iterable<Key> keys() {
            Queue<Key> q = new Queue<Key>();
            inorder(root, q);
            return q;
        }

        private void inorder(Node x, Queue<Key> q) {
            if (x == null) return;
            inorder(x.left, q);
            q.enqueue(x.key);
            inorder(x.right, q);
        }

        /**
         * Returns all keys in the symbol table in the given range,
         * as an {@code Iterable}.
         *
         * @param  lo minimum endpoint
         * @param  hi maximum endpoint
         * @return all keys in the symbol table between {@code lo} 
         *         (inclusive) and {@code hi} (inclusive)
         */
        public Iterable<Key> keys (Key lo, Key hi) {
            Queue<Key> q = new Queue<Key>();
            keys(root, q, lo, hi);
            return q;
        }

        private void keys(Node x, Queue q, Key lo, Key hi) {
            if (x == null) return;
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if (cmplo < 0) keys(x.left, q, lo, hi);
            if (cmplo <= 0 && cmphi >= 0) q.enqueue(x.key);
            if (cmphi > 0) keys(x.right, q, lo, hi);
        }
}