package Sorting;

//Traverse the array and find and find the minElement
// and put it in the beginning of the array
public class SelectionSort {
    public static void selectionSort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[minIndex]) {
                    minIndex = j;
                }
            }
            swap(elements, minIndex, i);
        }
    }

    public static void swap(int[]arr, int a, int b) {
        if (a==b) return;
        else {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        selectionSort(arr);
        for(int i : arr) System.out.println(i);
    }
}
