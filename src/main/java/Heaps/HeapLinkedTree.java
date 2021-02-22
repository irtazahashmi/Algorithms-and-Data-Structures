package Heaps;

class HeapLinkedTree {
    private int size = 0;
    private HeapLinkedTree.Node root;

    /**
     * Initializes a Heap with one Node.
     *
     * @param rootKey
     *     the key given to the root Node of the Heap.
     */
    public HeapLinkedTree(int rootKey) {
        root = new HeapLinkedTree.Node(rootKey);
        size++;
    }

    /**
     * @return the root Node of this Heap.
     */
    public HeapLinkedTree.Node getRoot() {
        return root;
    }

    /**
     * @param n
     *     The Node to get the left child from.
     * @return the left child of n.
     */
    public HeapLinkedTree.Node getLeft(HeapLinkedTree.Node n) {
        return n.left;
    }

    /**
     * @param n
     *     The Node to get the right child from.
     * @return the right child of n.
     */
    public HeapLinkedTree.Node getRight(HeapLinkedTree.Node n) {
        return n.right;
    }

    /**
     * @param n
     *     The Node to check the left child from.
     * @return true iff Node n has a left child, false otherwise.
     */
    public boolean hasLeft(HeapLinkedTree.Node n) {
        return n.left != null;
    }

    /**
     * @param n
     *     The Node to check the right child from.
     * @return true iff Node n has a right child, false otherwise.
     */
    public boolean hasRight(HeapLinkedTree.Node n) {
        return n.right != null;
    }

    /**
     * This method creates a new left child of n if it does not yet have a left child.
     *
     * @param n
     *     The Node to set the left child from.
     * @param leftKey
     *     The key to set in the left child of Node n.
     */
    public void setLeft(HeapLinkedTree.Node n, int leftKey) {
        if (n.left == null) {
            n.left = new HeapLinkedTree.Node(leftKey);
            size++;
        } else {
            n.left.key = leftKey;
        }
    }

    /**
     * This method creates a new right child of n if it does not yet have a right child.
     *
     * @param n
     *     The Node to set the right child from.
     * @param rightKey
     *     The key to set in the right child of Node n.
     */
    public void setRight(HeapLinkedTree.Node n, int rightKey) {
        if (n.right == null) {
            n.right = new HeapLinkedTree.Node(rightKey);
            size++;
        } else {
            n.right.key = rightKey;
        }
    }

    /**
     * @return The size of this Heap, i.e. the amount of Nodes.
     */
    public int size() {
        return size;
    }

    class Node {
        private int key;
        private HeapLinkedTree.Node left, right;

        /**
         * Simple constructor.
         *
         * @param key
         *     to set as key.
         */
        public Node(int key) {
            this.key = key;
        }

        /**
         * @return The integer key of this Node.
         */
        public int getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key + "(" + (left == null ? " " : left) + ',' + (right == null ? " " : right) + ')';
        }
    }
}
