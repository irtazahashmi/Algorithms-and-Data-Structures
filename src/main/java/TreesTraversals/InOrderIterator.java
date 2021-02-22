package TreesTraversals;

import TreesBinary.BinaryTree;
import java.util.Stack;

public class InOrderIterator {
    private BinaryTree root;
    Stack<BinaryTree> stack;


    public InOrderIterator(BinaryTree root){
        this.root = root;
        this.stack = new Stack<>();
    }

    public boolean hasNext(){
        if (root != null || !stack.isEmpty()) return true;
        return false;
    }

    public Object next(){
        if (!hasNext()) return null;

        while(root != null){
            stack.push(root);
            root = root.getLeft(); //left most
        }
        root = stack.pop();
        BinaryTree node = root;
        root = root.getRight();
        return node.getKey();
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(42);
        bt.insert(21);
        bt.insert(84);
        InOrderIterator iterator = new InOrderIterator(bt);
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext());
    }
}

