package Sorting;

public class SelectionSortRecursive {
    public static void selectionSort(int[] array, int start) {
        if (start >= array.length - 1) return;
        int minIndex = start;

        for (int i = start + 1; i < array.length; i++)
            if (array[i] < array[minIndex]) minIndex = i;

        swap(array, start, minIndex);
        selectionSort(array, start + 1);
    }

    public static void swap(int[]arr, int a, int b) {
        if (a == b) return;
        else {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        selectionSort(arr, 0);
        for(int i : arr) System.out.println(i);
    }
}
