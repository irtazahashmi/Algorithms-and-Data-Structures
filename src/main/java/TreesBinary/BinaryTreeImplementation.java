package TreesBinary;

import java.util.LinkedList;
import java.util.Queue;

// Binary Tree Implementation with ROOT
// insert, delete, get, min, max
public class BinaryTreeImplementation {
    private BinaryTree root;


    public BinaryTreeImplementation(BinaryTree root) {
        this.root = root;
    }

    public BinaryTree insert(int data) {
        return insert(root, data);
    }
    public BinaryTree insert(BinaryTree root, int data) {
        if(root == null) { return new BinaryTree(data);}
        else if(data > root.getKey()) root.setRight(insert(root.getRight(), data));
        else root.setLeft(insert(root.getLeft(), data));
        return root;
    }


    public BinaryTree delete(int data) {
        return delete(root, data);
    }
    private BinaryTree delete(BinaryTree root, Integer data) {
        if(root == null) return null;

        if(data < root.getKey()) root.setLeft(delete(root.getLeft(), data));// delete left
        else if(data > root.getKey()) root.setRight(delete(root.getRight(), data)); //delete right
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
                root.setLeft(delete(root.getLeft(), maxValue));
            }
        }

        return root;
    }

    public BinaryTree get(int data) {return get(root, data);}
    public BinaryTree get(BinaryTree root, int data) {
        if (root == null || root.getKey() == data) return root;
        else if(root.getKey() > data) return get(root.getLeft(), data);
        else return get(root.getRight(), data);
    }


    public int findMax() {return findMax(root);}
    public int findMax(BinaryTree root) {
        if (root.getRight() == null) return root.getKey();
        return findMax(root.getRight());
    }

    public int findMin() {return findMin(root);}
    public int findMin(BinaryTree root) {
        if (root.getLeft() == null) return root.getKey();
        return findMin(root.getLeft());
    }

    public boolean isEmpty() {return root == null;}
    public BinaryTree getRoot() {return root;}

    public String toString() {
        if (root == null) return "Empty Tree!";

        StringBuilder sb = new StringBuilder();
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(root);

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
        BinaryTreeImplementation bt = new BinaryTreeImplementation(new BinaryTree(5));
        bt.insert(8);
        bt.insert(3);
        bt.insert(7);
        bt.insert(4);
        bt.insert(1);
        bt.insert(9);
        System.out.println(bt.toString());
        bt.delete(5);
//        bt.delete(8);
//        bt.delete(4);
//        bt.delete(9);
//        bt.delete(1);
//        bt.delete(7);
//        bt.delete(3);
        System.out.println(bt.toString());
    }

}
