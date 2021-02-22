package Heaps;

import java.util.Comparator;

public class PQEntry implements Comparator<PQEntry> {
    public int key;
    public int value;

    public PQEntry(int k, int v) {
        key = k;
        value = v;
    }

    @Override
    public int compare(PQEntry o1, PQEntry o2) {
        return o1.key - o2.key;
    }
}