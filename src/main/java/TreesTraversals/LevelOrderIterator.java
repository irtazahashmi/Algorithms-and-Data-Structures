package TreesTraversals;

import TreesBinary.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderIterator {
    BinaryTree root;
    Queue<BinaryTree> queue;

    public LevelOrderIterator(BinaryTree root) {
        this.root = root;
        this.queue = new LinkedList<>();
        if (root!=null) this.queue.add(root);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public Object next() {
        if (!hasNext()) return null;

        BinaryTree curr = queue.poll();
        Object result = curr.getKey();
        if (curr.getLeft() != null) queue.add(curr.getLeft());
        if (curr.getRight() != null) queue.add(curr.getRight());
        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(42);
        bt.insert(21);
        bt.insert(84);
        LevelOrderIterator iterator = new LevelOrderIterator(bt);
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext() + " " + iterator.next());
        System.out.println(iterator.hasNext());
    }
}
