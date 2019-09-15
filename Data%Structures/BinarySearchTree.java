/**
 * Binary Search Tree API
 */
public class BinarSearchTree<Key extends Comparable<Key>, Val> {
    private class Node {
            private Key key;
            private Val Val;
            private Node left, right;
            public Node(Key key, Val val) {
                this.key = key;
                this.val = val;
            }       
        }

    private Node root;

    /**
     * Takes the key as input and returns the corresponding
     * Value associated to it.
     * In a BST everything left to the node it smaller than the node
     * and everything right to the node is greater than the node
     * 
     * @param Key The key to be Looked for
     * @return the Value associated to the key.
     */
    public Val get(Key key) {
        Node temp = root;
        while (temp != null) {
            int cmp = key.compareTo(temp.Key);
            if (cmp > 0) temp = temp.right;
            else if (cmp < 0) temp = temp.left;
            else if (cmp == 0) return temp.Val;
        }
        return null;
    }

    /**
     * Puts a new value to a existing tree or the empty Tree
     * for an empty tree the private method just initializes a 
     * new node and for the others, the root is replaced with
     * the left or the right part of the tree.
     * Sometimes the key is overridden.
     * 
     * @param key the key for the new Node
     * @param val The Value for the new Node
     */
    public void put(Key key, Val val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Val val) {
    
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.Key);
        if (cmp > 0) put(x.right, key, val);
        if (cmp < 0) put(x.left, key, val);
        if (cmp == 0) x.Val = val;
        return x;
    }

    private Node delete(Key key) {

    }
}