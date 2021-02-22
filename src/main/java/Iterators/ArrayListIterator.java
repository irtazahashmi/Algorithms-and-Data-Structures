package Iterators;

// Lazy iterator for array lists
// THIS CLASS NESTED WITHIN ARRAYLIST CLASS


//public class ArrayIterator implements Iterator {
//    private int j = 0; //index of next element
//    private boolean removable = false; // can remove be called?
//
//    @Override
//    public boolean hasNext() {return j < size};
//
//    @Override
//    public Object next() throws NoSuchElementException {
//        if (j == size) throw new NoSuchElementException();
//        removable = true;
//        return data[j++];
//    }
//
//    @Override
//    public void remove() throws IllegalStateException{
//        if(!removable) throw new IllegalStateException();
//        ArrayList.this.remove(j-1);
//        j--;
//        removable = false;
//    }
//
//    public Iterator iterator() return new ArrayIterator();
//}
