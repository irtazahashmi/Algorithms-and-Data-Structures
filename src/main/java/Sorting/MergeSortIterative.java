package Sorting;

public class MergeSortIterative {

    public static void mergeSortIterative(int arr[]) {
        if (arr == null) return;
        // Merging sub array of size 1, then size 2, size 4...
        for (int i = 1; i < arr.length; i *= 2) {
            // Pick the starting point, mid and end for each sub array
            for (int j = 0; j < arr.length - 1; j += i * 2) {
                int mid = Math.min(j + i - 1, arr.length - 1);
                int end = Math.min(j + 2 * i - 1, arr.length - 1);
                // merge the array
                merge(arr, j, mid, end);
            }
        }
    }

    //Do sorting in the merging phase. Merge 1 element arrays to 2, 2 to 4 etc.
    public static void merge(int[]arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        // adding remaining left elements
        while(i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        // adding remaining right elements
        while(j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        //merge keeps merging elements. (4, 2, 5, 1, 3) -> (2 4) -> (2,4) (5, 1, 3) -> (1, 2, 3, 4 5)
        // 2 4 2 4 5 1 3 1 2 3 4 5 -> get the sorted part only
        for(int ind = start; ind <= end; ind++)
            arr[ind] = temp[ind - start];
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        mergeSortIterative(arr);
        for(int i : arr) System.out.println(i);
    }
}
