package Sorting;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if(arr == null) return null;
        return mergeSortA(arr, 0, arr.length - 1);
    }

    public static int[] mergeSortA(int[] arr, int start, int end) {
        if (end - start <= 0) return null;

        int mid = (end + start) / 2;
        //divide the array into left and right array
        //keep splitting till all arrays have one element in it.
        mergeSortA(arr, start, mid); //sort the first half
        mergeSortA(arr, mid + 1, end); //sort the second half
        return merge(arr, start, mid, end); //merge boh
    }

    //Do sorting in the merging phase. Merge 1 element arrays to 2
    public static int[] merge(int[]arr, int start, int mid, int end) {
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
    	// copy all of temp to arr from index start.
        for(int ind = start; ind <= end; ind++) {
            arr[ind] = temp[ind - start];
        }

        return arr;
    }
}
