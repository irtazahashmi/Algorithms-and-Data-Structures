package Sorting;

import Heaps.PQEntry;

import java.util.ArrayList;
import java.util.List;

public class HeapSortPQEntry {
    ArrayList<PQEntry> heap = new ArrayList<>();

    public List<PQEntry> heapSort(List<PQEntry> entries) {
        for(int i = 0; i < entries.size(); i++)
            heap.add(new PQEntry(entries.get(i).key, entries.get(i).value));

        buildHeap();
        List<PQEntry> sorted = new ArrayList<>();
        while(!heap.isEmpty()) {
            PQEntry element = heap.get(0);
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            downHeap(0, heap.size() - 1);
            sorted.add(element);
        }
        return sorted;
    }

    protected void buildHeap() {
        int n = heap.size();
        for(int i = n / 2 - 1; i >= 0; i--) downHeap(i, heap.size() - 1);
    }

    public void downHeap(int root, int range) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int smallest = root;

        if (left <= range && heap.get(left).key < heap.get(root).key) smallest = left;

        if (right <= range && heap.get(right).key < heap.get(smallest).key) smallest = right;

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
        PQEntry g = new PQEntry(-1, 4);
        PQEntry h = new PQEntry(0, 4);
        PQEntry i = new PQEntry(3, 4);
        List<PQEntry> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        l.add(e);
        l.add(f);
        l.add(g);
        l.add(h);
        l.add(i);
        HeapSortPQEntry hp = new HeapSortPQEntry();
        List<PQEntry> res = hp.heapSort(l);
        for(PQEntry p : res) System.out.println(p.key);
    }
}

