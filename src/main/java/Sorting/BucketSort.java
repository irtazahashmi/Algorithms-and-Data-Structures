package Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BucketSort {
    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int e : array){
            if (e < minElement) minElement = e;
            if (e > maxElement) maxElement = e;
        }

        if (minElement == Integer.MAX_VALUE || maxElement == Integer.MIN_VALUE) return new Queue[0];

        // Bucket of keys -> {4, 4, 2, 1, 2, 1, 3, 0, 0} -> {0, 1, 2, 3, 4}
        Queue<Integer>[] buckets = new Queue[maxElement - minElement + 1];

        // Make sure all buckets filled
        for (int e : array) {
            int index = e - minElement;
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].add(e);
        }

        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        ArrayList<Integer> res = new ArrayList<>();
        for(Queue<Integer> bucket : buckets) if (bucket != null) res.addAll(bucket);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int arr[] = {14, 5, 1, 2, 15, 6, 16, 4, 9, 8, 7};
        int[] res = readBuckets((fillBuckets(arr)));
        for(int i : res) System.out.println(i);
    }
}
