package PriorityQueue;

import java.util.*;

public class AdaptablePQ {

    private static class PQEntry implements Comparable<PQEntry> {
        private int key;
        private Vertex value;
        private int index;

        public PQEntry(int key, Vertex value, int index) {
            this.key = key;
            this.value = value;
            this.index = index;
        }

        protected int getKey() {
            return key;
        }

        protected void setKey(int key) {
            this.key = key;
        }

        protected Vertex getValue() {
            return value;
        }

        protected int getIndex() {
            return index;
        }

        protected void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(PQEntry o) {
            return Integer.compare(this.getKey(), o.getKey());
        }
    }

    private ArrayList<PQEntry> heap = new ArrayList<>();
    private Map<Vertex, PQEntry> entries = new HashMap<>();

    private int parent(int j) {return (j - 1) / 2; }
    private int left(int j) { return 2 * j + 1; }
    private int right(int j) {return 2 * j + 2; }

    private boolean hasLeft(int j) {return left(j) < heap.size(); }
    private boolean hasRight(int j) { return right(j) < heap.size(); }

    private void swap(int i, int j) {
        PQEntry temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        heap.get(i).setIndex(i);
        heap.get(j).setIndex(j);
    }

    private void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (heap.get(j).compareTo(heap.get(p)) >= 0)
                break;
            swap(j, p);
            j = p;
        }
    }

    private void downheap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            }
            if (heap.get(smallChildIndex).compareTo(heap.get(j)) >= 0)
                break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    private void bubble(int j) {
        if (j > 0 && heap.get(j).compareTo(heap.get(parent(j))) < 0)
            upheap(j);
        else
            downheap(j);
    }

    private void insert(Vertex vertex, int key) {
        PQEntry newest = new PQEntry(key, vertex, heap.size());
        heap.add(newest);
        upheap(heap.size() - 1);
        entries.put(vertex, newest);
    }

    public int size() {
        return heap.size();
    }

    public void insertOrReplace(Vertex vertex, int key) {
        if (!entries.containsKey(vertex)) {
            this.insert(vertex, key);
        } else {
            PQEntry entry = entries.get(vertex);
            entry.setKey(key);
            bubble(entry.getIndex());
        }
    }
    public VertexNumPair removeMin() {
        if (isEmpty())
            return null;
        PQEntry entry = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        entries.remove(entry.getValue());
        return new VertexNumPair(entry.getValue(), entry.getKey());
    }


    public boolean isEmpty() {
        return heap.isEmpty();
    }






    static class VertexNumPair {

        private Vertex vertex;

        private int num;

        public VertexNumPair(Vertex vertex, int num) {
            this.vertex = vertex;
            this.num = num;
        }

        public Vertex getVertex() {
            return vertex;
        }

        public int getNum() {
            return num;
        }
    }


    static class Vertex implements Comparable<Vertex> {

        private int id;

        private Set<VertexNumPair> neighbours;

        public Vertex(int id) {
            this.id = id;
            neighbours = new HashSet<>();
        }

        public int getId() {
            return id;
        }

        public void addNeighbour(Vertex v, int weight) {
            neighbours.add(new VertexNumPair(v, weight));
        }

        @Override
        public String toString() {
            return "<vertex: " + id + ">";
        }

        public Collection<VertexNumPair> getNeighbours() {
            return new ArrayList<>(this.neighbours);
        }

        @Override
        public int compareTo(Vertex o) {
            return this.getId() - o.getId();
        }

        @Override
        public int hashCode() {
            return this.getId();
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Vertex && ((Vertex) o).getId() == this.getId();
        }
    }

}
