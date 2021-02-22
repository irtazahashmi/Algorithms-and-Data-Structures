package Sorting;

import java.util.LinkedList;
import java.util.Queue;

public class QuickSortQueue {

    public static void quickSort(Queue<Integer> queue) {
        if (queue.size() < 2) return;

        Queue<Integer> pivot = new LinkedList<Integer>();
        Queue<Integer> smaller  = new LinkedList<Integer>(); //smaller than pivot
        Queue<Integer> larger = new LinkedList<Integer>(); //larger than pivot
        pivot.add(queue.remove()); //first element is pivot

        while (!queue.isEmpty()) {
            Integer e = queue.remove();
            if (e < pivot.peek()) smaller.add(e);
            else if (e > pivot.peek()) larger.add(e);
            else pivot.add(e);
        }

        quickSort(smaller);
        quickSort(larger);

        while (!smaller.isEmpty()) queue.add(smaller.remove());
        while (!pivot.isEmpty()) queue.add(pivot.remove());
        while (!larger.isEmpty()) queue.add(larger.remove());
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(12);
        q.add(11);
        q.add(13);
        q.add(5);
        q.add(6);
        q.add(7);
        quickSort(q);
        while (!q.isEmpty()) System.out.println(q.remove());
    }
}
