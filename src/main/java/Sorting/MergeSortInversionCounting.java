package Sorting;
import java.io.*;

public class MergeSortInversionCounting {

  // number of inversions -> merge sort

  static int countInversions(int[] array) {
    return sortAndCount(array, 0, array.length - 1);
  }
  
  static int sortAndCount(int[] array, int start, int end) {
    if (end - start <= 0) return 0;
   
    int mid = (end + start) / 2;
    int inversions = 0;
    inversions += sortAndCount(array, start, mid);
    inversions += sortAndCount(array, mid + 1, end);
    inversions += mergeAndCount(array, start, mid + 1, end);
    return inversions;
  }
  
  static int mergeAndCount(int[] array, int start, int mid, int end) {
    int i = start;
    int j = mid;
    int[] temp = new int[array.length];
    int k = start;
    int count = 0;
    
    while(i <= mid - 1 && j <= end) {
      if (array[i] <= array[j]) {
        temp[k] = array[i];
        k++;
        i++;
      } else {
        temp[k] = array[j];
        k++;
        j++;
        count += (mid - i);
      }
    }
    
    while (i <= mid - 1) {
      temp[k] = array[i];
      k++;
      i++;
    }
    
    while(j <= end) {
      temp[k] = array[j];
      j++;
      k++;
    }
    
    for(i = start; i <= end; i++) {
      array[i] = temp[i];
    }
    
    return count;
  }
}