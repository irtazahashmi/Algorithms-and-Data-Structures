package MapsAndMultimaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderedMap {
    private ArrayList<Entry> map = new ArrayList<>();

    public OrderedMap() {}

    // Return the index of the key using binary search. -1 if key not found.
    private int findIndex(String key) {
        if (key.isEmpty()) return -1;
        int index = Collections.binarySearch(map, new Entry(key, null), Comparator.comparing(Entry::getKey));
        if (index < 0) return -1;
        return index;
    }

    public int size() {return map.size();}

    public Entry put(String key, int value) {
        // Put a new value in the map.
        if (findIndex(key) == -1) {
            map.add(new Entry(key, value));
            return null;
        } else {
            // Replace the value and return it
            map.add(findIndex(key), new Entry(key, value));
            return map.get(findIndex(key));
        }
    }

    public Entry remove(String key) {
        if (findIndex(key) == -1) return null; // Nothing to remove
        int n = map.size();
        int j = findIndex(key);
        Entry remove = map.get(j);
        //relocate last entry to fill "hole" created by removal
        if (j != n - 1) map.set(j, map.get(n - 1));
        map.remove(n-1);
        return remove;
    }

    public String toString() {
        if (map.size() == 0) return "Map empty!";
        StringBuilder sb = new StringBuilder();
        for(Entry e : map) {
            sb.append("(" + e.getKey());
            sb.append(", " + e.getValue()+ ")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UnorderedMap map = new UnorderedMap();
        map.put("KSA", 1);
        map.put("USA", 2);
        map.put("England", 3);
        map.put("Netherlands", 4);
        System.out.println(map.toString());
        System.out.println(map.size());
        map.remove("England");
        System.out.println(map.toString());
        System.out.println(map.size());
    }
}
