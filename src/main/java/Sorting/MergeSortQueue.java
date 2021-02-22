package Sorting;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortQueue {

    public static Queue<Integer> mergeSort(Queue<Integer> queue) {
        if (queue.size() == 1) return queue;
        else {
            int halfSize = queue.size() / 2;
            Queue<Integer> firstHalf = new LinkedList();
            for (int i = 0; i < halfSize; i++) firstHalf.add(queue.remove());
            Queue<Integer> secondHalf = queue;
            Queue<Integer> f = mergeSort(firstHalf);
            Queue<Integer> s = mergeSort(secondHalf);
            return merge(f, s);
        }
    }

    public static Queue<Integer> merge(Queue<Integer> first, Queue<Integer> second) {
        Queue<Integer> result = new LinkedList();
        while (!first.isEmpty() && !second.isEmpty()) {
            if (first.peek() < second.peek()) result.add(first.remove());
            else result.add(second.remove());
        }

        while (!first.isEmpty()) result.add(first.remove());
        while (!second.isEmpty()) result.add(second.remove());
        return result;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(12);
        q.add(11);
        q.add(13);
        q.add(5);
        q.add(6);
        q.add(7);
        Queue<Integer> res = mergeSort(q);
        while (!res.isEmpty()) System.out.println(res.remove());
    }
}

