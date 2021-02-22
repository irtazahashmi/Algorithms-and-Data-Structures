package Hashtables;

import java.util.ArrayList;



//
//        A variant on the ETH algorithm:
//        𝑏0 = 1
//        𝑏𝑖= 𝑐𝑖 ∗ ((𝑏𝑖−1 mod 257) + 1)
//        𝐻= 𝑏𝑛 mod 𝑠
class ETHHash extends HashTable {
    public ETHHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item==null) return 0;
        else {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            for(int i = 1; i <= item.length(); i++){
                char currChar = item.charAt(i-1);
                int bi = currChar * ((res.get(i-1) % 257) + 1);
                res.add(bi);
            }

            return res.get(res.size()-1) % getCapacity();
        }
    }
}
//        A variant on the GNU-cpp algorithm:
//        𝑏0 = 0
//        𝑏𝑖 = 4𝑏𝑖 − 1 + 𝑐𝑖
//        𝐻= (the last 31 bits of 𝑏𝑛) mod 𝑠
class GNUCPPHash extends HashTable {
    public GNUCPPHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item==null) return 0;
        else {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(0);
            for(int i = 1; i <= item.length(); i++){
                char currChar = item.charAt(i-1);
                int bi = 4 * res.get(i-1) + currChar;
                res.add(bi);
            }

            // getting last 31 bits of bn % s
            return ((1<<31) -1) & res.get(res.size()-1) % getCapacity();
        }
    }
}
//        A variant on the GNU-cc1 algorithm:
//        𝑏0 = 𝑛
//        𝑏𝑖 = 613𝑏𝑖 −1 + 𝑐𝑖
//        𝐻 = (the last 30 bits of 𝑏𝑛) mod 𝑠
class GNUCC1Hash extends HashTable {
    public GNUCC1Hash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item==null) return 0;
        else {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(item.length());
            for(int i = 1; i <= item.length(); i++){
                char currChar = item.charAt(i-1);
                int bi = 613* res.get(i-1) + currChar;
                res.add(bi);
            }
            // getting last 30 bits of bn % s
            return (((1<<30) -1) & res.get(res.size()-1)) % getCapacity();
        }
    }
}
//The hashCode() method of the Java String class.
// If this is negative, make it positive by using Math.abs()
// and put it in the right range by using the modulus operator.

class HashCodeHash extends HashTable {
    public HashCodeHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item==null) return 0;
        else return Math.abs(item.hashCode() % getCapacity());
    }
}
