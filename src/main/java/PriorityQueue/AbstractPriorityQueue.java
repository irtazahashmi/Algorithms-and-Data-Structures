package PriorityQueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    // Nested Entry Class for PQ
    protected class PQEntry implements Entry {
        private K key;
        private V value;

        public PQEntry(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public K getKey() { return key;}

        @Override
        public V getValue() { return value;}

        protected void setKey(K k) {key = k;}
        protected void setValue(V v) {value = v;}
    }

    private Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> c) {comp = c;}
    protected int compare(Entry<K, V> a, Entry<K, V> b) {return comp.compare(a.getKey(), b.getKey()); }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try{
            return comp.compare(key, key) == 0;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty() {return size() == 0;}

}
