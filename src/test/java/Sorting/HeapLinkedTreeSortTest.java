package Sorting;

import org.junit.*;
import static org.junit.Assert.*;

public class HeapLinkedTreeSortTest {

    @Test
    public void testHeapifySmall() {
        int[] data = {10, 4, 8, 5, 12, 2, 6, 11, 3, 9, 7, 1};
        HeapSortInPlace.heapify(data);
        assertArrayEquals(new int[]{12, 11, 8, 10, 9, 2, 6, 5, 3, 4, 7, 1}, data);
    }

    @Test
    public void testHeapSortSmall() {
        int[] data = {10, 4, 8, 5, 12, 2, 6, 11, 3, 9, 7, 1};
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        HeapSortInPlace.heapSort(data);
        assertArrayEquals(sorted, data);
    }
}