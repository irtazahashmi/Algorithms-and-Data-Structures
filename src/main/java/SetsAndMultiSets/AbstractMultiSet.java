package SetsAndMultiSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class AbstractMultiSet {
    //list in sorted order
    protected final List<Integer> elements;

    public AbstractMultiSet(List<Integer> elements) {
        this.elements = new ArrayList<>(elements);
        Collections.sort(this.elements);
    }

    public AbstractMultiSet() {
        this(new ArrayList<>());
    }


    public List<Integer> getElements() {
        return new ArrayList<>(elements);
    }

    public abstract void insert(int element);

    // number of occurences of the element
    public abstract int count(int element);

    /**
     *  Calculates the intersection between `this` and `other`.
     * In the intersection of `this` and `other`, the frequency of each distinct element in the result set
     * is defined as follows:
     * Given `C = A.intersection(B)`. Then for every integer `i`, `C.count(i) == min(A.count(i), B.count(i))`.
     *
     * @param other
     * the other multiset to take the intersection with.
     * @return The intersection of multisets `this` and `other`.
     */

    public abstract SetsAndMultiSets.AbstractMultiSet intersection(SetsAndMultiSets.AbstractMultiSet other);
    public abstract SetsAndMultiSets.AbstractMultiSet union(SetsAndMultiSets.AbstractMultiSet other);
    public abstract SetsAndMultiSets.AbstractMultiSet difference(SetsAndMultiSets.AbstractMultiSet other);
}

