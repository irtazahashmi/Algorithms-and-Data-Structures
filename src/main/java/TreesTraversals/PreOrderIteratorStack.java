package TreesTraversals;

import TreesBinary.BinaryTree;

import java.util.Iterator;
import java.util.Stack;

public class PreOrderIteratorStack implements Iterator {
        private final Stack<BinaryTree> stack;

        public PreOrderIteratorStack(BinaryTree root) {
            stack = new Stack<>();
            stack.add(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Object next() {
            if (!hasNext()) return null;

            // node, left, right
            BinaryTree node = stack.pop();
            if (node.getRight() != null) stack.push(node.getRight());
            if (node.getLeft() != null) stack.push(node.getLeft());
            return node.getKey();
        }

        @Override
        public void remove() {
            if (!hasNext()) return;

            BinaryTree node = stack.pop();
            if (node.getRight() != null) stack.push(node.getRight());
            if (node.getLeft() != null) stack.push(node.getLeft());
        }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(42);
        bt.insert(21);
        bt.insert(84);
        PreOrderIteratorStack iterator = new PreOrderIteratorStack(bt);
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext());
    }



    static class Node {
        int data;
        Node left;
        Node right;

    }
}


