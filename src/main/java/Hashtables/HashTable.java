package Hashtables;

import java.util.LinkedList;

abstract class HashTable {
    protected LinkedList<EntryString>[] myTable;

    /**
     * Constructs a new HashTable.
     *
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        if (capacity >= 1) {
            myTable = new LinkedList[capacity];
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Add a key value pair to the HashTable.
     *
     * @param key
     *     to identify the value.
     * @param value
     *     that is identified by the key.
     */
    public void put(String key, Integer value) {
        int h = hash(key);
        if (myTable[h] == null) myTable[h] = new LinkedList<>();

        if (containsKey(key)) {
            for (int i = 0; i < myTable[h].size(); i++) {
                if (myTable[h].get(i).equals(key)) {
                    myTable[h].set(i, new EntryString(key, value));
                }
            }
        } else {
            myTable[h].add(new EntryString(key, value));
        }
    }

    /**
     * @param key
     *     to look for in the HashTable.
     * @return true iff the key is in the HashTable.
     */
    public boolean containsKey(String key) {
        int h = hash(key);
        if (myTable[h] != null) {
            for (int i = 0; i < myTable[h].size(); i++) {
                if (myTable[h].get(i).equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Get a value from the HashTable.
     *
     * @param key
     *     that identifies the value.
     * @return the value associated with the key or `null` if the key is not in the HashTable.
     */
    public Integer get(String key) {
        int h = hash(key);
        if (myTable[h] != null) {
            for (int i = 0; i < myTable[h].size(); i++) {
                if (myTable[h].get(i).equals(key)) {
                    return myTable[h].get(i).getValue();
                }
            }
        }

        return null;
    }

    /**
     * @return the capacity of the HashTable.
     */
    public int getCapacity() {
        return myTable.length;
    }

    /**
     * Hashes a string/key.
     *
     * @param item
     *     to hash.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public abstract int hash(String item);
}

class EntryString {
    public final String key;
    public final Integer value;

    public EntryString(String s, Integer v) {
        key = s;
        value = v;
    }

    public boolean equals(String s) {
        return s == null && key == null || key.equals(s);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && this.equals(((Entry) o).key);
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
