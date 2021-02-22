package Sorting;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSortQueue {

    public static void radixSort(Queue<Integer> queue) {
        Queue<Integer> zeroBit = new LinkedList<>();
        Queue<Integer> oneBit = new LinkedList<>();

        //32 bits in each int
        for (int i = 0; i < 32; i++) {

            //for each number, add number to queue according to its current bit
            while (!queue.isEmpty()) {
                Integer element = queue.remove();
                if ((element >>> i) % 2 == 0) zeroBit.add(element); //bit is zero
                else oneBit.add(element); //bit is one
            }

            /* Combine the elements from the queues back together.  As a quick
             * note - if this is the 31st bit, we want to put back the 1 elements
             * BEFORE the 0 elements, since the sign bit is reversed.
             */
            if (i == 31) {
                Queue<Integer> temp = zeroBit;
                zeroBit = oneBit;
                oneBit = temp;
            }

            //combining queues back
            while (!zeroBit.isEmpty()) queue.add(zeroBit.remove());
            while (!oneBit.isEmpty()) queue.add(oneBit.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(3);
        q.add(5);
        q.add(10);
        q.add(6);
        q.add(2);
        q.add(0);
        q.add(-3);
        q.add(60);
        radixSort(q);
        while (!q.isEmpty()) System.out.println(q.remove());
    }
}
