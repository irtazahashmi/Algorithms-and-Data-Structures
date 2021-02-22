package MapsAndMultimaps;

import java.util.*;

class MultiMap {
    private Map<Integer, List<Integer>> map;
    private int size;

    public MultiMap() {
        this.map = new HashMap<>();
    }

    // The number of (key, value) pairs in the MultiMap.
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //Adds the given (key, value) pair to the MultiMap.
    public void put(int key, int value) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(value);
        size++;
    }

    //Returns all values in the MultiMap for the given key, else empty list.
    public List<Integer> get(int key) {
        if (!map.containsKey(key)) return new ArrayList<>();
        return new ArrayList<>(map.get(key));
    }

    //Removes the given (key, value) pair from the MultiMap.
    public boolean remove(int key, int value) {
        if (!map.containsKey(key)) return false;
        boolean res = map.get(key).remove((Integer) value);
        if (res) {
            size--;
            if (map.get(key).isEmpty())
                map.remove(key);
        }

        return res;
    }

    public List<Integer> removeAll(int key) {
        if (!map.containsKey(key)) return new ArrayList<>();
        List<Integer> values = map.get(key);
        map.remove(key);
        size -= values.size();
        return values;
    }
}
