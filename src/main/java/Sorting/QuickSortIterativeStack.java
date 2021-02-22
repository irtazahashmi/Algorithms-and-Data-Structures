package Sorting;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class QuickSortIterativeStack {

    public static void quickSortIterative(int arr[]){
        if (arr == null) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        // push start and end indexes to the stack
        stack.push(start);
        stack.push(end);

        while(!stack.isEmpty()){
            //pop end and start indexes from the stack
            end = stack.pop();
            start = stack.pop();

            // get the pivotIndex of start and end
            int pivotIndex = partition(arr, start, end);

            // if elements on both side, push to stack
            if (start < pivotIndex - 1 && end > pivotIndex + 1) {
                stack.push(start);
                stack.push(pivotIndex-1);
                stack.push(pivotIndex + 1);
                stack.push(end);
            }
            // if elements on the left side of pivot, push to stack
            else if(start < pivotIndex - 1){
                stack.push(start);
                stack.push(pivotIndex - 1);
                // if elements right side of stack push them
            } else if(end > pivotIndex + 1){
                stack.push(pivotIndex + 1);
                stack.push(end);
            }
        }
    }

    private static int partition(int arr[], int start, int end){
        // select first element
        int pivot = arr[start];
        //start and end indexes
        int i = start;
        int j = end;

        while(i < j) {
            i++; // start from 1 because 0 is pivot
            while(i <= end && arr[i] < pivot) i++; //greater than pivot
            while(j >= start && arr[j] > pivot) j--; // smaller than pivot
            if (i <= end && i < j) swap(arr, i, j); //swap pivot
        }
        swap(arr, start, j); //putting pivot in correct place
        return j;
    }


    private static void swap(int arr[], int a, int b){
        if (a == b) return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {14, 5, 1, 2, 15, 6, 16, -1, 9, 8, 7};
        quickSortIterative(arr);
        for(int i : arr) System.out.println(i);
    }
}
