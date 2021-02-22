package MapsAndMultimaps;

import java.util.ArrayList;

public class SortedTableMap {
    private ArrayList<Entry> table = new ArrayList<>();

    public SortedTableMap() {};

    public Entry firstEntry() {return safeEntry(0);} // Smallest key
    public Entry lastEntry() {return safeEntry(size() - 1);} //largest key

    //smallest key >= key
    public Entry ceilingEntry(String key) {return safeEntry(findIndex(key));}

    // returns a key with <= given key
    public Entry floorEntry(String key) {
        int j = findIndex(key);
        if (j == size() || !key.equals(table.get(j).getKey())) j--;
        return safeEntry(j);
    }

    //returns entry with greatest key < given key
    public Entry lowerEntry(String key) {return safeEntry(findIndex(key) - 1);}

    // returns entry with least key > given key
    public Entry higherEntry(String key) {
        int j = findIndex(key);
        if (j < size() && key.equals(table.get(j).getKey())) j++;
        return safeEntry(j);
    }

    private Entry safeEntry(int j) {
        if (j < 0 || j >= table.size()) return null;
        return table.get(j);
    }

    // Uses binary search to find the index for better performance.
    private int findIndex(String key, int low, int high) {
        if (high < low) return high + 1; // no entry qualifies
        int mid = (low + high)/2;
        if (key.equals(table.get(mid).getKey())) return mid;
        else if (key.compareTo(table.get(mid).getKey()) < 0) return findIndex(key, low, mid - 1);
        else return findIndex(key, mid + 1, high);
    }

    private int findIndex(String key) {return findIndex(key, 0, table.size() - 1);}
    public int size() {return table.size();}

    public Integer get(String key) {
        int j = findIndex(key);
        if (j == size() || key.compareTo(table.get(j).getKey()) != 0) return null;
        return table.get(j).getValue();
    }

    public Integer put(String key, Integer value) {
        int j = findIndex(key);
        // Replace value
        if (j < size() && key.compareTo(table.get(j).getKey()) == 0) {
            table.set(j, new Entry(key, value));
            return table.get(j).getValue();
        }
        //Add new value
        table.add(j, new Entry(key, value));
        return null;
    }

    public Integer remove(String key) {
        int j = findIndex(key);
        if (j == size() || key.compareTo(table.get(j).getKey()) != 0) return null;
        return table.remove(j).getValue();
    }

    public String toString() {
        if (table.size() == 0) return "Map empty!";
        StringBuilder sb = new StringBuilder();
        for(Entry e : table) {
            sb.append("(" + e.getKey());
            sb.append(", " + e.getValue()+ ")");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        SortedTableMap map = new SortedTableMap();
        map.put("KSA", 1);
        map.put("USA", 2);
        map.put("Argentina", 5);
        map.put("Zambia", 6);
        map.put("England", 3);
        map.put("Netherlands", 4);
        System.out.println(map.toString());
        System.out.println(map.size());

        System.out.println(map.firstEntry().key); //Argentina
        System.out.println(map.lastEntry().key); //Zambia

        System.out.println(map.ceilingEntry("KSA").key); // KSA
        System.out.println(map.floorEntry("KSA").key); // KSA

        System.out.println(map.higherEntry("KSA").key); // Netherlands
        System.out.println(map.lowerEntry("KSA").key); // England
    }
}
