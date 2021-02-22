package Sorting;

public class QuickSortLastPivot {

    public static void quickSort(int[] elements) {
        if (elements == null) return;
        else quickSortA(elements, 0, elements.length - 1);
    }

    public static void quickSortA(int[] arr, int start, int end) {
        //one element array
        if (end < start) return;
        int pivotIndex = partition(arr, start, end); // partition and get pivot index
        quickSortA(arr, start, pivotIndex - 1); //sort left array, all smaller than pivot
        quickSortA(arr, pivotIndex + 1, end); //sort right array, all bigger than pivot
    }

    // Takes last element as pivot. Places all smaller to the left and
    // all greater to the right.
    public static int partition(int arr[], int start, int end) {
        //last element as pivot
        int pivotIndex = end;

        //Traverse the array (except pivot) and order the array according to the pivot
        end--;
        while(start <= end) {
            // Smaller elements go to the left of pivot
            if (arr[start] < arr[pivotIndex]) start++;
            else {
                swap(arr, start, end); //swap if bigger element found
                end--;
            }
        }
        //Put the pivot into correct position
        swap(arr, start, pivotIndex);
        return start; //pivotIndex
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
