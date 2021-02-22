package TreesTraversals;

import TreesBinary.BinaryTree;

import java.util.Iterator;
import java.util.Stack;

public class PostOrderIterator implements Iterator {
    BinaryTree currNode;
    Stack<BinaryTree> stack = new Stack<>();

    public PostOrderIterator(BinaryTree root) {
        currNode=null;
        getEndTree(root);
    }

    //get to the bottom to start the traversal
    public void getEndTree(BinaryTree node) {
        while(true) {
            stack.push(node);
            if(node.getLeft()!= null) node =node.getLeft();
            else if(node.getRight() !=null) node = node.getRight();
            else break;
        }
    }

    public Object next() {
        if (!hasNext()) return null;

        BinaryTree node = stack.peek();
        if(currNode == node.getRight()){
            currNode = node;
            return stack.pop().getKey();
        } else {
            getEndTree(node.getRight());
            currNode = stack.pop();
            return currNode.getKey();
        }
    }

    public boolean hasNext() { return !stack.isEmpty(); }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(42);
        bt.insert(21);
        bt.insert(84);
        bt.insert(20);
        bt.insert(25);
        PostOrderIterator iterator = new PostOrderIterator(bt);
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext());
    }
}

