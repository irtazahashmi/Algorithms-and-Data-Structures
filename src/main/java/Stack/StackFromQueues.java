package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueues {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    static int size = 0;

    public StackFromQueues() { }

    public static void push(int element) {
        size++;
        q2.add(element);
        while (!q1.isEmpty()) q2.add(q1.remove());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public static void pop() {
        if (q1.isEmpty()) return;
        q1.remove();
        size--;
    }

    public static int top() {
        if (q1.isEmpty()) return -1;
        else return q1.peek();
    }


    public static void main(String[] args) {
        StackFromQueues s = new StackFromQueues();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + size);
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + size);
    }
}
