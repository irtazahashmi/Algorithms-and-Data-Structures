package Sorting;

import java.util.Stack;

public class MergeSortStack {

    public static void mergeSort(Stack stack) {
        if (stack.size() == 1) return;

        Stack first = new Stack();
        Stack second = new Stack();

        int mid = stack.size()/2;
        int size = stack.size();
        for(int i = 0; i < mid; i++) first.push(stack.pop());
        for(int i = mid; i < size; i++) second.push(stack.pop());

        mergeSort(first);
        mergeSort(second);
        merge(first, second, stack);
    }

    public static void merge(Stack s1, Stack s2, Stack stack) {
        Stack merged = new Stack();

        while (!s1.isEmpty() && !s2.isEmpty()) {
            if ((Integer) s1.peek() < (Integer) s2.peek()) merged.push(s2.pop());
            else merged.push(s1.pop());
        }

        while (!s1.isEmpty()) merged.push(s1.pop());
        while (!s2.isEmpty()) merged.push(s2.pop());

        while (!merged.isEmpty()) stack.push(merged.pop());
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack();
        stack.push(5);
        stack.push(9);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(2);
        stack.push(-1);
        stack.push(100);
        stack.push(0);
        mergeSort(stack);
        while (!stack.isEmpty()) System.out.println(stack.pop());
    }
}
