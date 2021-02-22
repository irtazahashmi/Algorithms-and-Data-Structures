package Sorting;

import java.util.*;

public class MergeKSortedArrays {

    public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
        PriorityQueue<ArrayObj> pq = new PriorityQueue<>();
        for (int[] i : arrays) pq.add(new ArrayObj(i, 0));

        ArrayList<Integer> merged = new ArrayList<>();

        while (!pq.isEmpty()) {
            ArrayObj current = pq.remove();
            merged.add(current.array[current.index]);
            if (current.index < current.array.length - 1) {
                current.index++;
                pq.add(current);
            }
        }
        return merged;
    }

    public static class ArrayObj implements Comparable<ArrayObj> {
        int[] array;
        int index;

        public ArrayObj(int[] a, int i) {
            array = a;
            index = i;
        }

        @Override
        public int compareTo(ArrayObj a) {
            if(array[index] < a.array[a.index]) return -1;
            if(array[index] > a.array[a.index]) return 1;
            else return 0;
        }
    }
}
