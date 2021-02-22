package Sorting;
//Select an element and insert it in the right position
//in the sorted partition which is in the beginning of the array
public class InsertionSort {

    public static void insertionSort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int key = elements[i];
            int j = (i - 1);

            //shifting ordered elements to the right
            while(j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j--;
            }

            // inserting the element at the right spot
            elements[j + 1] = key;
        }
    }
}
