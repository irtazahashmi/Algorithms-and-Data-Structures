package Hashtables;
import java.util.*;


public class HashTableSeperateChaining {
    public LinkedList<Entry>[] table;
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
    @SuppressWarnings("unchecked")
    public HashTableSeperateChaining(int capacity) {
        if (capacity >= 1){
            table = new LinkedList[capacity];
            this.capacity = capacity;
        }else throw new IllegalArgumentException();
    }

    /**
     * Add a new Entry to the hash table,
     * uses separate chaining to deal with collisions.
     *
     * Returns false, if the key is null.
     *
     * @param key
     *     String representing the key of the entry.
     * @param value
     *     String representing the value of the entry.
     * @return true iff entry has been added successfully, else false.
     */
    public boolean put(String key, String value) {
        if (key == null) return false;
        else {
            int hashed = hash(key);
            if (table[hashed] == null) table[hashed] = new LinkedList<>();
            remove(key);
            table[hashed].add(new Entry(key, value));
            return true;
        }
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
        if (key == null) return null;
        int hashed = hash(key);
        if (table[hashed] != null){
            for (Entry s : table[hashed]){
                if (s.getKey().equals(key)){
                    return s.getValue();
                }
            }
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
		if (key != null) {
		    int index = hash(key);
		    if (table[index] != null) {
		        for (int i = 0; i < table[index].size(); i++){
		            if (table[index].get(i).getKey().equals(key)){
		                table[index].remove(i);
		                return true;
		            }
		        }
		    }
		}
		return false;
	}


    /**
     * Hashes a string representing a key
     *
     * @param key
     *     String that needs to be hashed.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}




