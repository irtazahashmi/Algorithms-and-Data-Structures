package Dequeue;

public class CircularArrayDequeue {
    int[] q;
    int front;
    int rear;
    int capacity;
    int size;
    

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularArrayDequeue(int k) {
        q = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
       if (isFull()) return false;
        //decrementing by 1 to avoid negative values
        front = ((front + capacity - 1) % capacity);
        q[front] = value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        q[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear + capacity - 1) % capacity;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return q[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
         if (isEmpty()) return -1;
         int last = (rear + capacity - 1) % capacity;
        return q[last];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}
