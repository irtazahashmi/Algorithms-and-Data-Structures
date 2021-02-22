package TreesTraversals;

import java.util.*;

public class LinkedTreeLevelOrderIterator<V> implements Iterator<V> {
    private BTree<V> tree;
    private Queue<Position<V>> queue;

    /**
     * Constructor.
     * Should reset on a new tree.
     *
     * @param tree
     *     takes the tree
     */
    public LinkedTreeLevelOrderIterator(BTree<V> tree) {
        this.tree = tree;
        queue = new LinkedList<>();
        if (tree.getRoot() != null) queue.add(tree.getRoot());
    }

    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /**
     * Get the next element of the iterator and shift
     * iterator by one.
     *
     * @return current element value
     * @post iterator is moved to next element
     */
    @Override
    public V next() {
        if (!hasNext()) return null;

        Position<V> p = queue.remove();

        try {
            if (tree.hasLeft(p)) queue.add(tree.getLeft(p));
            if (tree.hasRight(p)) queue.add(tree.getRight(p));
        } catch(InvalidPositionException e) {}

        return p.getValue();
    }

    /**
     * Skip a single element of the iterator.
     *
     * @post iterator is moved to next element.
     */
    @Override
    public void remove() {
        if (hasNext()) {
            Position<V> p = queue.poll();

            try {
                if (tree.hasLeft(p)) queue.add(tree.getLeft(p));
                if (tree.hasRight(p)) queue.add(tree.getRight(p));
            } catch(InvalidPositionException e) {}
        }
    }


    interface BTree<V> {
        /**
         * @return the root of the tree
         */
        public Position<V> getRoot();

        /**
         * Get the left child of a position.
         *
         * @param v
         *     the position to get the child of.
         * @return the child of the position iff hasLeft(v) is true.
         * @throws InvalidPositionException
         *     else
         */
        public Position<V> getLeft(Position<V> v) throws InvalidPositionException;

        /**
         * Get the right child of a position.
         *
         * @param v
         *     the position to get the child of.
         * @return the child of the position iff hasRight(v) is true.
         * @throws InvalidPositionException
         *     else
         */
        public Position<V> getRight(Position<V> v) throws InvalidPositionException;

        /**
         * Check if a position has a left child.
         *
         * @param v
         *     position to check.
         * @return true iff v has a left child.
         * @throws InvalidPositionException
         *     if v is not valid (e.g. null)
         */
        public boolean hasLeft(Position<V> v) throws InvalidPositionException;

        /**
         * Check if a position has a right child.
         *
         * @param v
         *     position to check.
         * @return true iff v has a right child.
         * @throws InvalidPositionException
         *     if v is not valid (e.g. null)
         */
        public boolean hasRight(Position<V> v) throws InvalidPositionException;

        /**
         * Adds a new entry to the tree.
         *
         * @param key
         *     to use.
         * @param value
         *     to add.
         */
        public void add(int key, V value);
    }
}


