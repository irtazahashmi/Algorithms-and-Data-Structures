package MapsAndMultimaps;
import java.util.*;

class MapPersonal {
    protected ArrayList<Entry> map;

    /**
     * Constructor of the map. Represented by a sorted ArrayList.
     */
    public MapPersonal() {
        map = new ArrayList<>();
    }

    /**
     * Takes a String as input and finds the corresponding value in the map.
     * If the Entry with this key can't be found, this will return -1.
     *
     * @param key
     *     - Key that you are looking for.
     * @return - value corresponding to the Entry found.
     */
    public int get(String key) {
        if (key == null) return -1;
        int index = findIndex(key);
        if (index == map.size() || key.compareTo(map.get(index).getKey()) != 0) return -1;
        return map.get(index).getValue();
    }

    // Uses binary search to find the index for better performance.
    private int findIndex(String key, int low, int high) {
        if (high < low) return high + 1; // no entry qualifies
        int mid = (low + high)/2;
        if (key.equals(map.get(mid).getKey())) return mid;
        else if (key.compareTo(map.get(mid).getKey()) < 0) return findIndex(key, low, mid - 1);
        else return findIndex(key, mid + 1, high);
    }

    private int findIndex(String key) {return findIndex(key, 0, map.size() - 1);}

    /**
     * Left biased union of two maps, adds all entries from the map given as input to this map, keeping the maps sorted alphabetically on the key.
     * If a duplicate key occurs, takes the value from this map.
     *
     * @param other
     *     - other map used for the union
     */
    public MapPersonal union(MapPersonal other) {
        MapPersonal newMap = new MapPersonal();

        if (other == null) {
            newMap.map.addAll(map);
            return newMap;
        }

        int arr1Index = 0;
        int arr2Index = 0;

        while (true) {

            Entry arr1Entry = null;
            if (arr1Index < map.size()) arr1Entry = map.get(arr1Index);

            Entry arr2Entry = null;
            if (arr2Index < other.map.size()) arr2Entry = other.map.get(arr2Index);

            if (arr1Entry == null && arr2Entry != null) {
                newMap.map.add(arr2Entry);
                arr2Index++;
            } else if (arr1Entry != null && arr2Entry == null) {
                newMap.map.add(arr1Entry);
                arr1Index++;
            } else if (arr1Entry == null) {
                break;
            } else {
                int compare = arr1Entry.getKey().compareTo(arr2Entry.getKey());
                if (compare == 0) {
                    newMap.map.add(arr1Entry);
                    arr1Index++;
                    arr2Index++;
                } else if (compare < 0) {
                    newMap.map.add(arr1Entry);
                    arr1Index++;
                } else {
                    newMap.map.add(arr2Entry);
                    arr2Index++;
                }
            }
        }

        return newMap;
    }
}


