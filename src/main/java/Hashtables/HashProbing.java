package Hashtables;

class Solution extends MyHashTable {

    public Solution(String[] table) {
        super(table);
    }

    /**
     * Does a linear probe of the hashtable.
     *
     * @param msg
     *            to find in the table.
     * @param hash
     *            hash of msg.
     * @return the index the string is found at or -1 if it is not in there.
     */
    public int linearProbe(String msg, int hash) {
        for (int i = 0; i < size(); i++) {
            int currIndex = (hash + i) % size();
            if (getString(currIndex).equals(msg)) {
                return currIndex;
            }
        }

        return -1;
    }

    /**
     * Does a hashing probe of the hashtable.
     *
     * @param msg
     *            to find in the table.
     * @param hash1
     *            hash1 of msg.
     * @param hash2
     *            hash2 of msg.
     * @return the index the string is found at or -1 if it is not in there.
     */
    public int hashProbe(String msg, int hash1, int hash2) {
        hash2++;
        for (int i = 0; i < size(); i++) {
            int currIndex = (hash1 + i * hash2) % size();
            if (getString(currIndex).equals(msg)) {
                return currIndex;
            }
        }

        return -1;
    }
}

interface Table {
    /**
     * @param index
     *            to find the string of.
     * @return the string at the given index in the table.
     */
    public String getString(int index);

    /**
     * @return The size of the table.
     */
    public int size();
}

class MyHashTable implements Table {

    public MyHashTable(String[] table) {
//        super(table);
    }

    @Override
    public String getString(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}


