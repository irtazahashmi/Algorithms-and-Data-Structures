package Queue;

public class CircularArrayQueue {

    private int[] arr;
    int f;
    int size;
    int capacity;

    /**
     * Creates a new ArrayQueue with the given capacity.
     * @param capacity the capacity for this queue
     */
    public CircularArrayQueue(int capacity) {
        arr = new int[capacity];
        f = 0;
        size = 0;
        this.capacity = capacity;
    }

    /**
     * Adds the given element to the queue.
     * @param e the element to add to the queue
     * @throws FullQueueException if the queue is full
     */
    public void enqueue(int e) throws FullQueueException {
        if (size == capacity){
            throw new FullQueueException();
        }else{
            int avail = (f + size) % capacity;
            arr[avail] = e;
            size++;
        }
    }

    /**
     * Removes an element from the queue and returns it.
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    public int dequeue() throws EmptyQueueException {
        if (size == 0){
            throw new EmptyQueueException();
        }else{
            int res = arr[f];
            f = (f + 1) % capacity;
            size--;
            return res;
        }
    }

    public int front() throws EmptyQueueException {
        if (size == 0) throw new EmptyQueueException();
        else return arr[f];
    }

     public int rear() throws EmptyQueueException {
        if (size == 0) throw new EmptyQueueException();
        else return arr[(f + size - 1) % capacity];
    }

    static class EmptyQueueException extends Exception {}
    static class FullQueueException extends  Exception { }
}


