/**
 * Left Leaning Red Black Balanced Tree Implementation
 * @credits Algortihms I - princeton university
 * Course Manual: https://bit.ly/2JIxa4t
 * 
 * @param <Key> Generic Key type for symbol table
 * @param <Val> Generic Value type for symbol table
 */
public class LLRedBlackTree<Key extends comparable<Key>, Val> {
    private class Node {
        private final Key key;
        private Val Val;
        private Node left, right;
        public Boolean colour;

        public Node(final Key key, final Val val, final Boolean colour) {
            this.key = key;
            this.val = val;
            this.colour = colour;
        }
    }

    private static final Boolean RED = true;
    private static final Boolean BLACK = false;
    private Node root;

    /**
     * Takes the key as input and returns the corresponding Value associated to it.
     * In a LLRB everything left to the node it smaller than the node and everything
     * right to the node is greater than the node
     * 
     * @param Key The key to be Looked for
     * @return the Value associated to the key.
     */
    public Val get(final Key key) {
        Node temp = root;
        while (temp != null) {
            final int cmp = key.compareTo(temp.Key);
            if (cmp > 0)
                temp = temp.right;
            else if (cmp < 0)
                temp = temp.left;
            else if (cmp == 0)
                return temp.Val;
        }
        return null;
    }

    /**
     * Puts a new value to a existing tree or the empty Tree for an empty tree the
     * private method just initializes a new node and for the others, the root is
     * replaced with the left or the right part of the tree. Sometimes the key is
     * overridden.
     * Once the node is added the tree is balanced using the colour property.
     * 
     * @param key the key for the new Node
     * @param val The Value for the new Node
     */
    public void put(final Key key, final Val val) {
        root = put(root, key, val);
    }

    private Node put(final Node x, final Key key, final Val val) {
        if (x == null) return new Node(key, val, RED);
        final int cmp = key.compareTo(x.Key);
        if (cmp > 0) put(x.right, key, val);
        if (cmp < 0) put(x.left, key, val);
        if (cmp == 0) x.Val = val;

        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.right) && isRed(x.left)) flipColours(x);
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
        return x;
    } 


    /**
     * Deletes the very minimum key in the tree.
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    /**
     * Maintains symmetric order and perfect black balance
     */
    private Node rotateLeft(Node x) {
        Node tmp = x.right;
        x.right = tmp.left;
        tmp.left = x;
        tmp.colour = x.colour;
        x.colour = RED;
        return tmp;
    }

    /**
     * Temporary right leaning trick
     */
    private Node rotateRight(Node x) {
        Node tmp = x.left;
        x.left = tmp.right;
        tmp.right = x;
        tmp.colour = x.colour;
        x.colour = RED;
        return tmp;
    }

    /**
     * Flip Colours to convert the temporary four node to balance the tree
     */
    private void flipColours(Node x) {
        x.colour = RED;
        x.left.colour = BLACK;
        x.right.colour = BLACK;
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

    private boolean isRed(Node x) {
        return x.colour == RED;
    }
}