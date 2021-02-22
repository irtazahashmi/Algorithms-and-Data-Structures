package Hashtables;

public class HashTableLinearProbing {
    public Entry[] table;
    public int capacity;

    /**
     * Constructs a new HashTable.
     *
     * Capacity of the hash table can not be 0 or negative.
     *
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    public HashTableLinearProbing(int capacity) {
        if (capacity >= 1){
            table = new Entry[capacity];
            this.capacity = capacity;
        }else throw new IllegalArgumentException();
    }

    /**
     * Add a new Entry to the hash table,
     * uses linear probing to deal with collisions.
     *
     * Returns false, if the key is null or the table is full.
     *
     * @param key
     *     String representing the key of the entry.
     * @param value
     *     String representing the value of the entry.
     * @return true iff entry has been added successfully, else false.
     */
    public boolean put(String key, String value) {
        if (key!=null) return false;
        int h = hash(key);

        for(int i = 0; i < table.length; i++) {
            int index = (h + i) % capacity;
            if (table[index] == null || table[index].getKey() == null || table[index].getKey().equals(key)) {
                table[index] = new Entry(key, value);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieve the value of the entry associated with this key.
     *
     * Returns null, if the key is null.
     *
     * @param key
     *     String representing the key of the entry to look for.
     * @return value of the entry as String iff the entry with this key is found in the hash table, else null.
     */
    public String get(String key) {
        if (key != null){
            int h = hash(key);
            int end = h;

            do {
                if (table[h] == null) return null;
                if (key.equals(table[h].getKey())) return table[h].getValue();
                h = (h + 1) % capacity;
            } while (end != h);
        }
        return null;
    }

    /**
     * Remove the entry associated with this key from the hash table.
     *
     * Returns false, if the key is null.
     *
     * @param key
     *     String representing the key of the entry to remove.
     * @return true iff the entry has been successfully removed, else false.
     */
    public boolean remove(String key) {
        if (key != null){
            int h = hash(key);
            int end = h;

            do {
                if (table[h]==null) return false;
                if (key.equals(table[h].getKey())) {
                    setDefunct(h);
                    return true;
                }
                h = (h+1)%capacity;
            } while (end != h);
        }

        return false;
    }

    /**
     * Takes as input an index and sets the entry in that location as defunct.
     *
     * @param index
     *     The index of the spot that is defunct.
     */
    public void setDefunct(int index) {
        this.table[index] = new Entry(null, null);
    }

    /**
     * Hashes a string representing a key.
     *
     * @param key
     *     String that needs to be hashed.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
