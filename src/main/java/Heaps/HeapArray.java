package Heaps;

import java.util.*;

//MIN-HEAP
//3 changes to MAX-HEAP

class SolutionPQ {

    private List<Integer> heap;

    public SolutionPQ() {
        heap = new ArrayList<>();
    }

    /**
     * Swaps two elements in the list.
     *
     * @param i
     *     Position of element to swap in a.
     * @param j
     *     Position of element to swap in a.
     */
    private void swap(int i, int j) {
        int t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }

    /**
     * Restores the heap property in a heap represented as an arraylist.
     * When the heap property is invalid at root,
     * the method fixes the heap first locally before fixing the affected subtree.
     *
     * @param root
     *     Index of the root of the heap, which might be a subtree of the overall heap.
     * @param range
     *     Index of the last element in the heap, array elements with an index > range are not part of the heap.
     */
    public void downHeap(int root, int range) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        int smallest;

        if (left <= range && heap.get(left) > heap.get(root)) //change 1
            smallest = left;
        else
            smallest = root;

        if (right <= range && heap.get(right) > heap.get(smallest)) //change 2
            smallest = right;

        // heap property invalid at root
        if (smallest != root) {
            swap(root, smallest);
            downHeap(smallest, range);
        }
    }

    /**
     * Restores the heap property in a heap represented as an arraylist.
     * The method compares the node to its parent and swaps if necessary.
     *
     * @param i index of the node
     */
    public void upHeap(int i) {
        while (i >= 1) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) >= heap.get(i)) break; //change 3
            swap(parent,i);
            i = parent;
        }
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param i
     *     element to add
     */
    public void add(int i) {
        heap.add(i);
        upHeap(heap.size() - 1);
    }

    /**
     * Retrieves and removes the first element of this priority queue.
     *
     * @return the first element of the queue
     */
    public int poll() {
        int i = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0, heap.size() - 1);
        return i;
    }

    public int getInHeap(int i) {
        return heap.get(i);
    }

    /**
     * @return the current number of elements in the heap
     */
    public int size() {
        return this.heap.size();
    }
}