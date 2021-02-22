package Queue;

public class ArrayQueue {
    int[] q;
    int front;
    int back;
    int cap;

    public ArrayQueue(int capacity) {
        q = new int[capacity];
        front = 0;
        back = 0;
        cap = capacity;
    }

    public void enqueue(int element) {
        if (isFull()) return; // full queue
        q[back] = element;
        back++;
    }

    public int dequeue() {
        if (isEmpty()) return -1; //empty queue
        int r = q[front];
        // move all elements to the left
        for(int i = 0; i < back - 1; i++) q[i] = q[i+1];
        if (back < cap) q[back] = 0; // put q[back]= 0 so empty
        back--;
        return r;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return q[front];
    }

    public String toString() {
        if (isEmpty()) return "Empty!";
        StringBuilder sb = new StringBuilder("[");
        for(int i = front; i < back; i++) sb.append(q[i] + " ");
        return sb.append("]").toString();
    }

    public boolean isEmpty() {return back == front;}
    public boolean isFull() {return cap == back;}


    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(4);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q.toString());

        q.dequeue();
        System.out.println(q.toString());

        q.dequeue();
        System.out.println(q.toString());

        q.dequeue();
        System.out.println(q.toString());
    }

}
