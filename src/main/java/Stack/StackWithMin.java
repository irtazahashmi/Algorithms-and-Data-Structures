package Stack;

import java.util.Stack;

public class StackWithMin {
    Stack<Integer> stack;
    Integer minElement;

    StackWithMin() { stack = new Stack<Integer>(); }

    public int getMin() {
        if (stack.isEmpty()) return -1;
        else return minElement;
    }

    public int peek() {
        if (stack.isEmpty()) return -1;

        Integer t = stack.peek();
        if (t < minElement) return minElement;
        else return t;
    }

   public int pop() {
        if (stack.isEmpty()) return -1;

        Integer t = stack.pop();

        if (t < minElement) {
            int m = minElement;
            minElement = 2 * minElement - t;
            return m;
        }

        else return t;
    }

    public void push(Integer x) {
        if (stack.isEmpty()){
            minElement = x;
            stack.push(x);
            return;
        }


        if (x < minElement) {
            stack.push(2 * x - minElement);
            minElement = x;
        }

        else stack.push(x);
    }

    public static void main(String[] args) {
        StackWithMin s = new StackWithMin();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        s.peek();
    }
}

