package TreesAVL;

import java.util.*;

// AVL TREE: put, get, remove, rotateLeft, rotateRight, recalculateHeight

public class AVLImplementation {

    static class AVLNode extends BSTNode {

        public AVLNode(int key, String value) {
            super(key,value);
        }

        public void recalculateHeight() {
            height = 1 + Math.max(leftChildHeight(), rightChildHeight());
        }

        public void rotateLeft() {
            AVLNode oldRight = (AVLNode) getRight();
            setRight(oldRight.getRight());
            oldRight.setRight(oldRight.getLeft());
            oldRight.setLeft(getLeft());
            setLeft(oldRight);

            int tempkey = key;
            String tempvalue = value;
            key = oldRight.getKey();
            value = oldRight.getValue();
            oldRight.setKey(tempkey);
            oldRight.setValue(tempvalue);

            this.recalculateHeight();
            oldRight.recalculateHeight();
        }

        public void rotateRight() {
            AVLNode oldLeft = (AVLNode) getLeft();
            setLeft(oldLeft.getLeft());
            oldLeft.setLeft(oldLeft.getRight());
            oldLeft.setRight(getRight());
            setRight(oldLeft);

            int tempkey = key;
            String tempvalue = value;
            key = oldLeft.getKey();
            value = oldLeft.getValue();
            oldLeft.setKey(tempkey);
            oldLeft.setValue(tempvalue);

            this.recalculateHeight();
            oldLeft.recalculateHeight();
        }

        @Override
        public String get(int key) {
            return super.get(key);
        }

        @Override
        public String put(int key, String value) {
            String ret;

           //put normally same as binary tree
            if(this.key == key) {
                ret = getValue();
                setValue(value);
            } else if(key < this.key) {
                if(getLeft() == null) {
                    setLeft(new AVLNode(key,value));
                    ret = null;
                } else {
                    ret = getLeft().put(key,value);
                }
            } else {
                if(getRight() == null) {
                    setRight(new AVLNode(key,value));
                    ret = null;
                } else {
                    ret = getRight().put(key,value);
                }
            }

            // balance if needed. 4 cases.

            // left height > right height by at least 1
            if(leftChildHeight() - rightChildHeight() > 1) {
                // Left Right Child > Left Left Child
                if (getLeft().rightChildHeight() > getLeft().leftChildHeight()) {
                    getLeft().rotateLeft();
                    rotateRight();
                } else {
                    rotateRight();
                }
            } else if(rightChildHeight() - leftChildHeight() > 1) {
                // Right Left Child > Right Right Child
                if (getRight().leftChildHeight() > getRight().rightChildHeight()) {
                    getRight().rotateRight();
                    rotateLeft();
                } else {
                    rotateLeft();
                }
            }

            recalculateHeight(); //update height
            return ret;
        }

        public String remove(int data) {
            return remove(this, data).value;
        }
        private AVLNode remove(AVLNode root, Integer data) {

            // remove like in binary tree
            if(root == null) return null;

            if(data < root.getKey())
                root.setLeft(remove((AVLNode)root.getLeft(), data));// delete left
            else if(data > root.getKey())
                root.setRight(remove((AVLNode)root.getRight(), data)); //delete right
                //delete root
            else {
                // no children
                if(root.getLeft() == null && root.getRight() == null) return null;

                    // one of the child is null
                else if (root.getLeft() == null) return (AVLNode) root.getRight();
                else if(root.getRight() == null) return (AVLNode) root.getLeft();

                    // two children
                else {
                    int maxValue = findMax(root.getLeft());
                    root.setKey(maxValue);
                    root.setLeft(remove((AVLNode) root.getLeft(), maxValue));
                }
            }

            // balance if needed. 4 cases.

            // left height > right height by at least 1
            if(leftChildHeight() - rightChildHeight() > 1) {
                // Left Right Child > Left Left Child
                if (getLeft().rightChildHeight() > getLeft().leftChildHeight()) {
                    getLeft().rotateLeft();
                    rotateRight();
                } else {
                    rotateRight();
                }
            } else if(rightChildHeight() - leftChildHeight() > 1) {
                // Right Left Child > Right Right Child
                if (getRight().leftChildHeight() > getRight().rightChildHeight()) {
                    getRight().rotateRight();
                    rotateLeft();
                } else {
                    rotateLeft();
                }
            }

            recalculateHeight();
            return root;
        }

        public int findMax() {return findMax(this);}
        public int findMax(AVLNode root) {
            if (root.getRight() == null) return root.getKey();
            return findMax(root.getRight());
        }
    }

    static class AVLTree {
        private AVLNode root;

        public AVLTree() { root = null;}

        public AVLNode getRoot() {return root;}

        public String get(int key) {
            if(root == null) return null;
            else return root.get(key);
        }

        public String put(int key, String value) {
            if(root == null) {
                root = new AVLNode(key, value);
                return null;
            } else {
                return root.put(key,value);
            }
        }

        public String remove(int key) {
            if(root == null) return null;
            else return root.remove(key);
        }

        public String toString() {
            if(root == null) return "Empty";

            Queue<AVLNode> q = new LinkedList<>();
            q.add(root);
            String ret = "";

            while(!q.isEmpty()) {
                AVLNode node = q.poll();
                if(node.getLeft() != null) {
                    q.offer((AVLNode)node.getLeft());
                }
                if(node.getRight() != null) {
                    q.offer((AVLNode)node.getRight());
                }
                ret += node.getKey() + ",";
            }
            return ret;
        }
    }


    static abstract class BSTNode {
        protected int key;
        protected String value;
        protected int height;

        private BSTNode left, right;


        public BSTNode(int key, String value) {
            this.key = key;
            this.value = value;
            height = 1;
        }

        public abstract void recalculateHeight();
        public abstract void rotateLeft();
        public abstract void rotateRight();


        public int getKey() {return key;}
        public String getValue() {return value;}
        public void setKey(int key) {this.key = key;}
        public void setValue(String value) { this.value = value; }

        public BSTNode getLeft() { return left; }
        public BSTNode getRight() {return right;}
        public void setLeft(BSTNode left) {this.left = left;}
        public void setRight(BSTNode right) { this.right = right; }

        public int getHeight() { return height; }


        public int leftChildHeight() {
            if(getLeft() == null) return 0;
            else return getLeft().getHeight();
        }

        public int rightChildHeight() {
            if(getRight() == null) return 0;
            else return getRight().getHeight();
        }

        public String get(int key) {
            if (this.key == key) return getValue();
            else if (key < this.key) return getLeft().get(key);
            else return getRight().get(key);
        }

        public String put(int key, String value) {
            String ret;

            // If we found the key or arrive at a leaf, do the put operation, otherwise proceed downwards
            if(this.key == key) {
                ret = getValue();
                setValue(value);
            } else if(key < this.key) {
                if(getLeft() == null) {
                    setLeft(new AVLNode(key,value));
                    ret = null;
                } else {
                    ret = getLeft().put(key,value);
                }
            } else {
                if(getRight() == null) {
                    setRight(new AVLNode(key,value));
                    ret = null;
                } else {
                    ret = getRight().put(key,value);
                }
            }

            return ret;
        }

        public String remove(int data) {
            return remove(this, data).value;
        }
        private BSTNode remove(BSTNode root, Integer data) {
            if(root == null) return null;
            if(data < root.getKey()) root.setLeft(remove(root.getLeft(), data));// delete left
            else if(data > root.getKey()) root.setRight(remove(root.getRight(), data)); //delete right
                //delete root
            else {
                // no children
                if(root.getLeft() == null && root.getRight() == null) return null;

                    // one of the child is null
                else if (root.getLeft() == null) return root.getRight();
                else if(root.getRight() == null) return root.getLeft();

                    // two children
                else {
                    int maxValue = findMax(root.getLeft());
                    root.setKey(maxValue);
                    root.setLeft(remove(root.getLeft(), maxValue));
                }
            }

            return root;
        }

        public int findMax() {return findMax(this);}
        public int findMax(BSTNode root) {
            if (root.getRight() == null) return root.getKey();
            return findMax(root.getRight());
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.put(9, "nine");
        avlTree.put(5, "five");
        avlTree.put(10, "ten");
        avlTree.put(0, "zero");
        avlTree.put(6, "zero");
        avlTree.put(11, "zero");
        avlTree.put(-1, "zero");
        avlTree.put(1, "zero");
        avlTree.put(2, "zero");
        System.out.println(avlTree.toString());
        avlTree.remove(10);
        System.out.println(avlTree.toString());
    }
}
