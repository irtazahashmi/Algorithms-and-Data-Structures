package Sorting;

public class InsertionSortRecursive {
    public static void insertionSort(int[] input, int numItems) {
        if (numItems < 2) return;
        insertionSort(input, numItems - 1);
        int newElement = input[numItems - 1];
        int i;
        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;
    }
}
