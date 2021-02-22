package TreesBinary;

import java.util.LinkedList;
import java.util.Queue;

// Binary tree with: insert, get, delete, min, max
// has KEY instead of ROOT
// to say: root -> this !!!

public class BinaryTree {
    private int key;
    private BinaryTree left, right;


    public BinaryTree(int key) {
        this.key = key;
    }

    public BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this(key);
        setLeft(left);
        setRight(right);
    }


    public void insert(int value) {
        if (value == key) return; // already in the tree

        if (value < key) {
            if (left == null) left = new BinaryTree(value);
            else left.insert(value);
        }
        else {
            if (right == null) right = new BinaryTree(value);
            else right.insert(value);
        }
    }

    public boolean get(int value) {
        if (value == key) return true;
        if (value < key) {
            if (left != null) return left.get(value);
        }
        else {
            if (right != null) return right.get(value);
        }
        return false; // no value in the tree
    }

    public BinaryTree remove(int data) {
        return remove(this, data);
    }
    private BinaryTree remove(BinaryTree root, Integer data) {
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
                int maxValue = root.getLeft().max();
                root.setKey(maxValue);
                root.setLeft(remove(root.getLeft(), maxValue));
            }
        }

        return root;
    }

    public int min() {
        if (left == null) return key;
        else return left.min();
    }

    public int max() {
        if (right == null) return key;
        else return right.max();
    }

    public int getKey() {
        return key;
    }
    public BinaryTree getLeft() {
        return left;
    }
    public BinaryTree getRight() {
        return right;
    }
    public boolean hasLeft() {
        return left != null;
    }
    public boolean hasRight() {
        return right != null;
    }
    public void setLeft(BinaryTree left) {
        this.left = left;
    }
    public void setKey(int key) {this.key = key;}
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        //bfs toString
       StringBuilder sb = new StringBuilder();
       sb.append(key + " ");
       Queue<BinaryTree> q= new LinkedList<>();
       q.add(left);
       q.add(right);

        while(!q.isEmpty()) {
            BinaryTree temp = q.poll();
            if (temp != null) {
                sb.append(temp.getKey() + " ");
                if (temp.getLeft() != null) q.add(temp.getLeft());
                if (temp.getRight() != null) q.add(temp.getRight());
            }
        }
       return sb.toString();
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(5);
        bt.insert(3);
        bt.insert(8);
        bt.insert(7);
        bt.insert(4);
        bt.insert(9);
        bt.insert(1);
        System.out.println(bt.toString());
        bt.remove(7);
        System.out.println(bt.toString());
    }
}