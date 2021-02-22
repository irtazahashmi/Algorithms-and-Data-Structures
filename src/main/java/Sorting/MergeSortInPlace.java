package Sorting;

public class MergeSortInPlace {

  public static void mergeSortInPlace(int[] arr) {
    if (arr == null) return;
    mergeSortInPlace(arr, 0, arr.length - 1);
  }
  
  public static void mergeSortInPlace(int[] arr, int start, int end) {
    if (end - start <= 0) return;
    int mid = (end + start) / 2;
    mergeSortInPlace(arr, start, mid);
    mergeSortInPlace(arr, mid + 1, end);
    merge(arr, start, mid, end);
  }
  
  public static void merge(int[] arr, int start, int mid, int end) {
    if (arr[mid] <= arr[mid+1]) return;
    
    int i = start;
    int j = mid + 1;
    
    while (i <= mid && j <= end) {
      if (arr[i] <= arr[j]) {
        i++;
      } else {
        int element = arr[j];
        int index = j;
        
        //move all elements to right by 1
        while(index != i) {
          arr[index] = arr[index - 1];
          index--;
        }
        //place the element
        arr[index] = element;
        i++;
        j++;
        mid++;
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    mergeSortInPlace(arr);
    for(int i : arr) System.out.println(i);
  }
}