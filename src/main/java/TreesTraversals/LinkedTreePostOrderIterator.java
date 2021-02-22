package TreesTraversals;

import java.util.Iterator;
import java.util.Stack;

public class LinkedTreePostOrderIterator<V> implements Iterator<V> {
    private BTree<V> tree;
    private Stack<Position<V>> stack = new Stack<>();
    Position<V> currNode;


    public LinkedTreePostOrderIterator(BTree<V> tree) {
        this.tree = tree;
        getEndTree(tree.getRoot());
    }

    public void getEndTree(Position<V> node) {
        try {
            while(true) {
                stack.push(node);
                if(tree.hasLeft(node)) node = tree.getLeft(node);
                else if(tree.hasRight(node)) node = tree.getRight(node);
                else break;
            }
        } catch(InvalidPositionException e) {}
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public V next() {
        if (!hasNext()) return null;

        Position<V> node = stack.peek();
        try {

            if (currNode == tree.getRight(node)) {
                currNode = tree.getRoot();
                return stack.pop().getValue();
            } else {

                getEndTree(tree.getRight(node));
                currNode = stack.pop();
                return currNode.getValue();
            }


        } catch(InvalidPositionException e) {}

        return null;
    }

    /**
     * Skip a single element of the iterator.
     *
     * @post iterator is moved to next element.
     */
    @Override
    public void remove() {
        Position<V> node = stack.peek();
        try {

            if (currNode == tree.getRight(node)) {
                currNode = tree.getRoot();
            } else {

                getEndTree(tree.getRight(node));
                currNode = stack.pop();
            }

        } catch(InvalidPositionException e) {}
    }

}
