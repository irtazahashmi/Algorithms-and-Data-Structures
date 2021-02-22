package Stack;

import java.util.EmptyStackException;
//DYNAMIC ARRAY STACK
class ArrayStackDynamic {
    private Object[] elements;
    private int size;
    private int capacity;

    /**
     * Creates an empty ArrayStack with capacity 1.
     */
    public ArrayStackDynamic() {
        capacity = 1;
        elements = new Object[capacity];
        size = 0;
    }

    /**
     * @return The size of this ArrayStack.
     */
    public int size() {
        return size;
    }

    /**
     * @return `true` iff this ArrayStack is empty, `false` otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return `true` iff the size is equal to the capacity, `false` otherwise.
     */
    public boolean isFull() {
        return size() == capacity;
    }

    /**
     * @return the top element of the stack without removing it
     */
    public Object peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return elements[size - 1];
        }
    }

    /**
     * Adds `o` to the stack.
     * If capacity of stack was too small, capacity is doubled and `o` is added.
     *
     * @param o
     *     the element to add to the stack.
     */
    public void push(Object o) {
        if (o != null) {

            size++;

            if (size() > capacity) {

                capacity = capacity* 2;
                Object[] n = new Object[capacity];
                for (int i = 0; i < elements.length; i++) {
                    n[i] = elements[i];
                }
                elements = n;
            }

            elements[size() - 1] = o;
        }
    }

    /**
     * Removes the top element from the stack.
     * If removing top would make the stack use less than 25% of its capacity,
     * then the capacity is halved.
     *
     * @return the element which was at the top of the stack.
     * @throws EmptyStackException
     *     iff the stack is empty
     */
    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {

            Object re = elements[size() - 1];
            elements[size() - 1] = null;
            size--;

            if (size() < capacity * .25) {
                capacity = (int) Math.floor(.5 * capacity);
                if (capacity < 1) {
                    capacity  = 1;
                }
                Object[] n = new Object[capacity];
                for (int i = 0; i < capacity; i++) {
                    n[i] = elements[i];
                }
                elements = n;
            }

            return re;
        }
    }

    /**
     * @return a String representation of the ArrayStack
     * Example output for ArrayStack with 2 elements and capacity 5:
     * <ArrayStack[1,2]>(Size=2, Cap=5)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("<ArrayStack[");

        int s = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                if (s == size() - 1) {
                    sb.append(elements[i]);
                } else {
                    sb.append(elements[i] + ",");
                    s++;
                }
            }
        }

        sb.append("]>(Size=" + size + ", Cap=" + capacity + ")");
        return sb.toString();
    }

    // For testing, do not remove or change.
    public Object[] getElements() {
        return elements;
    }
}
