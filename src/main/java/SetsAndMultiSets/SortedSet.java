package SetsAndMultiSets;

import MapsAndMultimaps.Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MySet<E extends Comparable<E>> extends LibrarySet<E> {
    public List<E> set;

    public MySet() {
        this.set = new ArrayList<>();
    }
    public MySet(List<E> set) {
        this.set = set;
    }

    @Override
    protected List<E> getList() {
        return this.set;
    }

    // adding the element to the sorted set
    public void add(E element) {
        if (element != null && !set.contains(element)) {
            boolean hasInserted = false;
            for (int i = 0; i < set.size(); i++) {
                E currElement = set.get(i);
                if (currElement.compareTo(element) >= 0) {
                    set.add(i, element);
                    hasInserted = true;
                    break;
                }
            }
            if (!hasInserted) set.add(element);

        }

    }

    public void addAll(MySet<E> other) {
        for(E e : other.set) set.add(e);
    }

    public void remove(E element) {
        if (element != null && set.contains(element)) {
            set.remove(element);
        }
    }

    public MySet<E> union(MySet<E> that) {
        MySet<E> res = new MySet<>();
        if (that == null) res.addAll(this);
        else {
            res.addAll(this);
            res.addAll(that);
        }
        return res;
    }


    // Difference of two sets. Should use the fact that they have sorted lists. (O(n))
    // a set containing all elements of this, which do not belong to that
    public MySet<E> difference(MySet<E> that) {
        MySet<E> diff = new MySet<>();

        if (that != null) {
            int thisIndex = 0;
            int thatIndex = 0;

            while (true){
                // this set reached end
                if (thisIndex == set.size()) break;

                // that set reached end
                if (thatIndex == that.set.size()) {
                    for (; thisIndex < set.size(); thisIndex++) {
                        diff.set.add(set.get(thisIndex));
                    }
                    break;
                }

                // get this and that element
                E thisElement = set.get(thisIndex);
                E thatElement = that.set.get(thisIndex);

                int compare = thisElement.compareTo(thatElement);
                // not in that -> add to diff
                if (compare < 0) {
                    diff.set.add(thisElement);
                    thisIndex++;
                } else if (compare == 0) { // in both -> keep going
                    thisIndex++;
                    thatIndex++;
                } else {
                    thatIndex++;
                }
            }
        }

        return diff;
    }

    public int size() {return set.size();}
    public boolean isEmpty() {return set.size() == 0;}

    public E first() {return getSafely(0);}
    public E last() {return getSafely(set.size() - 1);}

    public E getSafely(int j) {
        if (j < 0 || j >= set.size()) return null;
        return set.get(j);
    }

    // smallest element >= element
    public E ceiling(E element) {
        int index = Collections.binarySearch(this.set, element);
        if (index < 0) return null;
        else return getSafely(index);
    }

    public E floor(E element) {
        int index = Collections.binarySearch(this.set, element);
        if (index < 0) return null;
        if (index == size() || !element.equals(this.set.get(index))) index--;
        return getSafely(index);
    }

    //returns entry with greatest key < given key
    public E lower(E element) {
        int index = Collections.binarySearch(this.set, element);
        if (index < 0) return null;
        return getSafely(index - 1);
    }

    // returns entry with least key > given key
    public E higher(E element) {
        int index = Collections.binarySearch(this.set, element);
        if (index < size() && element.equals(set.get(index))) index++;
        return getSafely(index);
    }

    // O(logn) because sorted list
    public boolean contains(E element) {
        int index = Collections.binarySearch(this.set, element);
        return index >= 0;
    }

    public String toString() {
        return set.toString();
    }


    public static void main(String[] args) {
        MySet<String> set = new MySet<>();
        set.add("lion");
        set.add("bird");
        set.add("cat");
        set.add("dog");
        set.add("elephant");
        set.add("zebra");
        System.out.println(set.toString());
    }
}

class LibrarySet<E> {
    protected List<E> getList() {
        return null;
    }
}


