package SetsAndMultiSets;
import java.util.*;

class MultiSet extends AbstractMultiSet {

    // Creates a new MultiSet that will contain the elements from `elements`.
    // The list of elements will be SORTED in the constructor of the superclass.
    public MultiSet(List<Integer> elements) {
        super(elements);
    }

    public MultiSet() {
        super();
    }

    // Inserts an element into this MultiSet, PRESERVING the order of the elements.
    @Override
    public void insert(int element) {
        int index = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(index) > element) {
                break;
            }
            index++;
        }
        elements.add(index, element);
    }

    public boolean contains(int element) {
        int index = Collections.binarySearch(elements, element);
        return index >= 0;
    }

    //the number of occurrences of `element` in `this` multiset.
    @Override
    public int count(int element) {
        int count = 0;
        for (int currElement : elements) {
            if (currElement == element) count++;
        }
        return count;
    }

    // remove single occurrence of element
    public void remove(int element) {
        int count = count(element);
        if (count == 0) return; // nothing to remove
        int index = Collections.binarySearch(elements, element);
        elements.remove(index);
    }

    // remove n occurrence of element
    public void removeN(int element, int n) {
        int count = count(element);
        int deleted = 0;
        while (deleted < n && deleted < count) {
            int index = Collections.binarySearch(elements, element);
            elements.remove(index);
            deleted++;
        }
    }


    //Calculates the union between `this` and `other`.
    // the frequency of each distinct element in the result set is defined as
    // C = A.union(B). Then for every integer i, C.count(i) == max(A.count(i), B.count(i))
    @Override
    public AbstractMultiSet union(AbstractMultiSet other) {
        MultiSet result = new MultiSet();
        result.elements.addAll(elements); //add all this elements
        if (other == null) return result;

        for (int element : other.elements) {
            if (result.elements.contains(element)) {
                int countResult = result.count(element);
                int countOther = other.count(element);
                // if result has less than other, add!
                if (countOther > countResult) {
                    result.elements.add(element);
                }
            } else {
                result.elements.add(element);
            }
        }

        result.elements.sort(Comparator.comparingInt(Integer::intValue));
        return result;
    }


    //Calculates the intersection between `this` and `other`.
    // C = A.intersection(B). Then for every integer i, C.count(i) == min(A.count(i), B.count(i))
    @Override
    public AbstractMultiSet intersection(AbstractMultiSet other) {
        MultiSet result = new MultiSet();
        if (other == null) return result;

        List<Integer> otherElements = other.getElements();

        for (int element : elements) {
            if (otherElements.contains(element)) {
                result.elements.add(element);
                // remove the added element because multi sets has duplicates!
                otherElements.remove(Integer.valueOf(element));
            }
        }

        return result;
    }

    @Override
    public AbstractMultiSet difference(AbstractMultiSet other) {
        MultiSet result = new MultiSet();
        if (other == null) result.elements.addAll(this.elements);
        else {
            for(int element : elements) {
                if (!other.elements.contains(element)) result.insert(element);
            }
        }
        return result;
    }

    public String toString() {
        return elements.toString();
    }

    public static void main(String[] args) {
        AbstractMultiSet multiSet = new MultiSet();
        multiSet.insert(3);
        multiSet.insert(3);
        multiSet.insert(5);
        multiSet.insert(1);
        multiSet.insert(6);
        multiSet.insert(8);

        AbstractMultiSet other = new MultiSet();
        other.insert(9);
        other.insert(2);
        other.insert(4);
        other.insert(0);
        other.insert(10);
        other.insert(6);

        AbstractMultiSet res = multiSet.difference(other);
        System.out.println(res.toString());
    }

}

