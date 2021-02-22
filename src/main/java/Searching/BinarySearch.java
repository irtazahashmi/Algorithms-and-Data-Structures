package Searching;
import java.util.*;

public class BinarySearch {

	
    public static boolean search(int[] a, int x) {
    if (a == null) return false;
    return binarySearch(a, x, 0, a.length - 1);
  }
  
  public static boolean binarySearch(int[] a, int x, int low, int high) {
    if (high < low) return false;
    
    int mid = (high + low)/2;
    
    if (a[mid] == x) return true;
    else if (a[mid] > x) return binarySearch(a, x, low, mid - 1);
    else return binarySearch(a, x, mid + 1, high);
  }
}
