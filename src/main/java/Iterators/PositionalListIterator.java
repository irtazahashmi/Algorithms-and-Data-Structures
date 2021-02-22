package Iterators;

// lazy positonal list iterator
//nested class in positional list

//private class PositionIterator implements Iterator<Position> {
//    private Position cursor = first(); //next element
//    private Position recent = null; //last element
//
//    @Override
//    public boolean hasNext() {return cursor != null;}
//
//    @Override
//    public Position next() throws NoSuchElementException {
//        if(cursor == null) throw  new NoSuchElementException("empty");
//        recent = cursor;
//        cursor = after(cursor);
//        return recent;
//    }
//
//    @Override
//    public void remove() throws IllegalStateException {
//        if(recent==null) throw new IllegalStateException("nothing to remove");
//        DLLPositionalList.this.remove(recent);
//        recent = null;
//    }
//}
//
//private class PositionIterable implements Iterable<Position> {
//    @Override
//    public Iterator<Position> iterator() {
//        return new PositionIterator();
//    }
//}
//
//    public Iterable<Position> positions() {
//        return new PositionIterable();
//    }
//
//private class ElementIterator implements Iterator {
//    Iterator<Position> positionIterator = new PositionIterator();
//    @Override
//    public boolean hasNext() {return positionIterator.hasNext(); }
//    @Override
//    public Object next() {return positionIterator.next(); }
//    @Override
//    public void remove() {positionIterator.remove();}
//}
//
//public Iterator iterator() {return new ElementIterator();}
