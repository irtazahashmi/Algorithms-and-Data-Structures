package Heaps;

public class IsMaxHeap {
    /**
     * @param arr integer array to be checked (root at index 0)
     * @param n the size of the array to be checked
     * @return true if the array satisfied the heap property, false otherwise
     */
    public static boolean isMaxHeap(int[] arr, int n) {
        if (arr == null) return false;
        if (arr.length == 0 || arr.length == 1) return true;

        int root = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int parentIndex = getParent(arr, i);
            if (arr[parentIndex] < arr[i]) return false; // child should always be >= parent
            if (arr[i] > root) return false; // any node is smaller than root
        }

        return true;
    }

    /**
     * @param arr array representation of a heap (you may assume it is a valid heap)
     * @param i index of node whose parent we're looking for (make no assumptions about it's validity)
     * @return index of the parent of node i, or -1 if: (a) i is not a valid index, (b) i doesn't have a parent
     */
    public static int getParent(int[] arr, int i) {
        if (i == 0) return - 1;
        int parentIndex = (i - 1) / 2;
        if (parentIndex >= 0 && parentIndex <= arr.length - 1) return parentIndex;
        else return -1;
    }
}

