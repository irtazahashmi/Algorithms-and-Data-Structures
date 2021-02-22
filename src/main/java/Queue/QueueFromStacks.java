package Queue;

import java.util.Stack;

public class QueueFromStacks {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    /**
     * @return true iff there are no elements left.
     */
    public boolean isEmpty() {
        return s1.size() == 0;
    }

    /**
     * @return the number of elements in the queue.
     */
    public int size() {
        return s1.size();
    }

    /**
     * Adds an element to the queue.
     *
     * @param i
     *     element to enqueue.
     */
    public void enqueue(Integer i) {
        if (i != null) s1.push(i);
    }

    /**
     * Removes the first element from the queue.
     *
     * @return the first element from the queue.
     * @throws NoSuchElementException
     *     iff the queue is empty.
     */
    public Integer dequeue() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();

        while(!s1.isEmpty()) s2.push(s1.pop());
        Integer r = s2.pop();
        while(!s2.isEmpty()) s1.push(s2.pop());
        return r;
    }

    /**
     * Only returns (i.e. does not remove) the first element from the queue.
     *
     * @return the first element from the queue.
     * @throws NoSuchElementException
     *     iff the queue is empty.
     */
    public Integer first() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();

        while(!s1.isEmpty()) s2.push(s1.pop());
        Integer r = s2.peek();
        while(!s2.isEmpty()) s1.push(s2.pop());
        return r;
    }

    static class NoSuchElementException extends Throwable {}
}


