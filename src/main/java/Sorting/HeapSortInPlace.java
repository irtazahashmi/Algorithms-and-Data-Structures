package Sorting;

public class HeapSortInPlace {

    // in place heap sort using MAX HEAP

    //build the max heap
    public static void heapSort(int[] arr){
        if (arr != null){
            buildHeap(arr, arr.length); //build the heap
            for (int i = arr.length - 1; i >= 0; i--) {
                swap(arr, 0, i); // keep swapping the root with the last element
                downHeap(arr, 0, i); // keep heapifying
            }
        }
    }

    //build heap using bottom up construction
    static void buildHeap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            downHeap(arr, i, n);
    }

    //heapify
    public static void downHeap(int[]arr, int root, int range){
        int left = 2 * root + 1;
        int right = 2* root + 2;
        int largest = root;

        if (left < range && arr[left] > arr[largest]) largest = left;

        if (right < range && arr[right] > arr[largest]) largest = right;
        // If largest is not root
        if (largest != root) {
            swap(arr, largest, root);
            downHeap(arr, largest, range);
        }
    }

    public static void swap(int[] arr, int i, int j){
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int x [] = {1,3,2,9,7,4,6,8,5};
        heapSort(x);
        for(int i : x) System.out.println(i + " ");
    }
}