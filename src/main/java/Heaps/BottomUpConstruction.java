package Heaps;

import java.util.ArrayList;
import java.util.List;


//BOTTOM CONSTRUCTION OF MIN-HEAP in O(n)

public class BottomUpConstruction {

    ArrayList<PQEntry> heap = new ArrayList<>();

    public void HeapPriorityQueue(List<PQEntry> entries) {
        for(int i = 0; i < entries.size(); i++)
            heap.add(new PQEntry(entries.get(i).key, entries.get(i).value));

        heapify();
    }

    protected void heapify() {
        int n = heap.size() - 1;
        for(int i = n / 2; i >= 0; i--)
            downHeap(i, heap.size() - 1);
    }

    public void downHeap(int root, int range) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        int smallest;

        if (left <= range && heap.get(left).key < heap.get(root).key)
            smallest = left;
        else
            smallest = root;

        if (right <= range && heap.get(right).key < heap.get(smallest).key)
            smallest = right;

        if (smallest != root) {
            swap(root, smallest);
            downHeap(smallest, range);
        }
    }

    private void swap(int i, int j) {
        PQEntry t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }


    public static void main(String[] args) {
        PQEntry a = new PQEntry(9, 5);
        PQEntry b = new PQEntry(7, 2);
        PQEntry c = new PQEntry(5, 1);
        PQEntry d = new PQEntry(2, 4);
        PQEntry e = new PQEntry(6, 3);
        PQEntry f = new PQEntry(4, 4);
        List<PQEntry> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        l.add(e);
        l.add(f);
        BottomUpConstruction bt = new BottomUpConstruction();
        bt.HeapPriorityQueue(l);
        for(PQEntry p : bt.heap) System.out.println(p.key);
    }
}


