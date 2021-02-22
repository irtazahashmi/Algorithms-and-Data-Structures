///**
// * Simple constructor.
// *
// * @param key
// *     to set as key.
// * @param value
// *     to set as value.
// */
//public BTNode(int key, V value) {
//        this.key = key;
//        this.value = value;
//        }
//
//@Override
//public int getKey() {
//        return key;
//        }
//
//@Override
//public V getValue() {
//        return value;
//        }
//
///**
// * @param value
// *     to set.
// */
//public void setValue(V value) {
//        this.value = value;
//        }
//
///**
// * @return the parent.
// */
//public Position<V> getParent() {
//        return parent;
//        }
//
///**
// * @return the left child.
// */
//public Position<V> getLeft() {
//        return left;
//        }
//
///**
// * @return the right child.
// */
//public Position<V> getRight() {
//        return right;
//        }
//
///**
// * @param parent
// *     to set
// */
//public void setParent(Position<V> parent) {
//        this.parent = parent;
//        }
//
///**
// * @param left
// *     to set
// */
//public void setLeft(Position<V> left) {
//        this.left = left;
//        }
//
///**
// * @param right
// *     to set
// */
//public void setRight(Position<V> right) {
//        this.right = right;
//        }
//  }




//
//class BinaryTree<V> implements BTree<V> {
//    private Position<V> root;
//
//    /**
//     * Simple constructor.
//     */
//    public BinaryTree() {
//        this.root = null;
//    }
//
//    @Override
//    public Position<V> getRoot() {
//        return root;
//    }
//
//    @Override
//    public Position<V> getLeft(Position<V> v) throws InvalidPositionException {
//        BTNode<V> node = checkPosition(v);
//        return node.getLeft();
//    }
//
//    @Override
//    public Position<V> getRight(Position<V> v) throws InvalidPositionException {
//        BTNode<V> node = checkPosition(v);
//        return node.getRight();
//    }
//
//    @Override
//    public boolean hasLeft(Position<V> v) throws InvalidPositionException {
//        BTNode<V> node = checkPosition(v);
//        return node.getLeft() != null;
//    }
//
//    @Override
//    public boolean hasRight(Position<V> v) throws InvalidPositionException {
//        BTNode<V> node = checkPosition(v);
//        return node.getRight() != null;
//    }
//
//    @Override
//    public void add(int key, V value) {
//        if (root == null) {
//            root = new BTNode<>(key, value);
//        } else {
//            this.add((BTNode<V>) root, new BTNode<>(key, value));
//        }
//    }
//
//    /**
//     * Adds the newNode recursively at the right position.
//     *
//     * @param node
//     *     currently examining this node to see if the newnode goes here
//     * @param newNode
//     *     to place somewhere.
//     */
//    private void add(BTNode<V> node, BTNode<V> newNode) {
//        if (node.getKey() == newNode.getKey()) {
//            node.setValue(newNode.getValue());
//        } else {
//            if (node.getKey() > newNode.getKey()) {
//                if (node.getLeft() == null) {
//                    newNode.setParent(node);
//                    node.setLeft(newNode);
//                } else {
//                    this.add((BTNode<V>) node.getLeft(), newNode);
//                }
//            } else {
//                if (node.getRight() == null) {
//                    newNode.setParent(node);
//                    node.setRight(newNode);
//                } else {
//                    this.add((BTNode<V>) node.getRight(), newNode);
//                }
//            }
//        }
//    }
//
//    /**
//     * Checks if the position is valid
//     *
//     * @param v
//     *     position to check
//     * @return v iff v instanceof BTNode.
//     * @throws InvalidPositionException
//     *     else
//     */
//    private BTNode<V> checkPosition(Position<V> v) throws InvalidPositionException {
//        if (!(v instanceof BTNode)) {
//            throw new InvalidPositionException("Position was null");
//        }
//        BTNode<V> result = (BTNode<V>) v;
//        return result;
//    }
//}
//
//class InvalidPositionException extends Exception {
//    private static final long serialVersionUID = -8010862139713793775L;
//
//    public InvalidPositionException(String string) {
//        super(string);
//    }
//}



//
//class BTNode<V> implements Position<V> {
//    private int key;
//    private V value;
//    private Position<V> parent, left, right;
//
//    /**
//     * Simple constructor.
//     *
//     * @param key
//     *     to set as key.
//     * @param value
//     *     to set as value.
//     */
//    public BTNode(int key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    @Override
//    public int getKey() {
//        return key;
//    }
//
//    @Override
//    public V getValue() {
//        return value;
//    }
//
//    /**
//     * @param value
//     *     to set.
//     */
//    public void setValue(V value) {
//        this.value = value;
//    }
//
//    /**
//     * @return the parent.
//     */
//    public Position<V> getParent() {
//        return parent;
//    }
//
//    /**
//     * @return the left child.
//     */
//    public Position<V> getLeft() {
//        return left;
//    }
//
//    /**
//     * @return the right child.
//     */
//    public Position<V> getRight() {
//        return right;
//    }
//
//    /**
//     * @param parent
//     *     to set
//     */
//    public void setParent(Position<V> parent) {
//        this.parent = parent;
//    }
//
//    /**
//     * @param left
//     *     to set
//     */
//    public void setLeft(Position<V> left) {
//        this.left = left;
//    }
//
//    /**
//     * @param right
//     *     to set
//     */
//    public void setRight(Position<V> right) {
//        this.right = right;
//    }
//}