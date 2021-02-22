package TreesBinary;

import java.util.Arrays;

public class ArrayBasedTree {
    int root;
    public Integer[] arr = new Integer[20];

    public ArrayBasedTree(int rootValue){
        this.root = 0;
        arr[0] = rootValue;
    }

    public void setLeft(int data, int root){
        arr[(root * 2) + 1] = data;
    }
    public int getLeft(int root){
        return arr[(root*2)+1];
    }
    public void setRight(int data , int root){
        arr[(root*2)+2] = data;
    }
    public int getRight(int root){
        return arr[(root*2)+2];
    }

    //ADD RECURSIVELY BY FINDING SPACE IN ARRAY

    public void add(Integer data) {
        if (arr[0] == null) arr[0] = data;
        recursiveAdd(0, data);
    }

    public void recursiveAdd(int root, Integer data) {
        if (arr[root] == null) return;

        if (data < arr[root]) {
            // this is the formula to access the left node
            if (arr[root * 2 + 1] == null) arr[root * 2 + 1] = data;
            else recursiveAdd(root * 2 + 1, data);
        } else {
            // this is the formula to access the right node
            if (arr[root * 2 + 2] == null) arr[root * 2 + 2] = data;
            else recursiveAdd(root * 2 + 2, data);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) sb.append(arr[i] + " ");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayBasedTree tree = new ArrayBasedTree(5);
        tree.add(1);
        tree.add(8);
        System.out.println(tree.toString());
    }
}
