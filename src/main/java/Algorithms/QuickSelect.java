package Algorithms;

public class QuickSelect {

    public static int quickselect(int[] nums, int k) {
        return kthLargest(nums, 0, nums.length - 1, k -1);
    }

    public static int kthLargest(int[] arr, int start, int end, int k) {
        if (start == end) return arr[start];
        int pivot = partition(arr, start, end);
        if (k == pivot) return arr[k];
        if (k < pivot ) return kthLargest(arr, start, pivot - 1, k);
        else return kthLargest(arr, pivot + 1, end, k);
    }

    public static int partition(int[] arr, int start, int end){
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
        // Test 1: 4
        int[] arr = {5, 3, 52, 42, 6, 123, 2, 1, 4, 44, 64};
        int k = 4;
        System.out.println(quickselect(arr, k));

        // Test 1: 42
        int[] arr2 = {5, 3, 52, 42, 6, 123, 2, 1, 4, 44, 64};
        int k2 = 7;
        System.out.println(quickselect(arr2, k2));
    }
}
