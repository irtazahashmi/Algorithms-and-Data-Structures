package Sorting;

import java.util.Random;

public class QuickSortRandomised {

    public static void quickSortRandomised(int[] arr) {
        if (arr == null) return;
        else quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end < start) return;
        int pivotIndex = partition(arr, start, end);// partition and get pivot index
        quickSort(arr, start, pivotIndex - 1); //sort left array, all smaller than pivot
        quickSort(arr, pivotIndex + 1, end); //sort right array, all bigger than pivot
    }

    public static int partition(int[] arr, int start, int end){
        // Select a random pivot index
        Random random = new Random();
        int randomPivot = start + random.nextInt(end - start + 1);
        // Put the pivot at the end of array
        swap(arr, randomPivot, end);
        int lastIndex = end;

        // Go through array from start till end - 1 (not the pivot)
        end--;
        while(start <= end){
            // Putting all elements less than pivot to left side of arr
            if(arr[start] < arr[lastIndex]) start++;
            else {
                swap(arr, start, end); //swap if bigger element found
                end--;
            }
        }

        // Moving pivot to right position in arr
        swap(arr, start, lastIndex);
        return start; //pivot index
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
        quickSortRandomised(arr);
        for(int i : arr) System.out.println(i);
    }
}
