package Sorting;
//start from left to right
//if element1 > element2, SWAP
//Traverse the array multiple times till everything is sorted
//left is unsorted, right is sorted
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--){
            for (int j = 0 ; j < i; j++)
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
        }
    }

    public static void swap(int[]arr, int a, int b) {
        if (a == b) {
            return;
        } else {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
