package Sorting;

public class QuickSortFirstPivot {
    public static void quickSort(int[] elements) {
        if (elements == null) return;
        else quickSortA(elements, 0, elements.length - 1);
    }

    public static void quickSortA(int[] arr, int start, int end) {
        //one element array
        if (end < start) return;
        int pivotIndex = partition(arr, start, end); //partition and get pivot index
        quickSortA(arr, start, pivotIndex - 1); //sort left array, all smaller than pivot
        quickSortA(arr, pivotIndex + 1, end); //sort right array, all bigger than pivot
    }

    public static int partition(int[] arr, int start, int end){
        // select first element as pivot
        int pivot = arr[start];

        int i = start;
        int j = end;

        while(i < j) {
            i++; // start from 1 because 0 is pivot
            while(i <= end && arr[i] < pivot) i++; //i smaller than pivot
            while(j >= start && arr[j] > pivot) j--; // j greater than pivot
            if (i < j && i <= end) swap(arr, i, j); //swap element
        }
        swap(arr, start, j); //putting pivot in correct place from start to correct place
        return j; //pivot index
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
        int arr[] = {14, 5, 1, 2, 15, 6, 16, 4, 9, 8, 7};
        quickSort(arr);
        for(int i : arr) System.out.println(i);
    }
}
