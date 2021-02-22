package PositionalList;

public interface PositionalList<Object> {
    int size();
    boolean isEmpty();
    Position<Object> first();
    Position<Object> last();
    Position<Object> before(Position<Object> p) throws IllegalArgumentException;
    Position<Object> after(Position<Object> p) throws IllegalArgumentException;
    Position<Object> addFirst(Object p);
    Position<Object> addLast(Object p);
    Position<Object> addBefore(Position<Object> p, Object e) throws IllegalArgumentException;
    Position<Object> addAfter(Position<Object> p, Object e) throws IllegalArgumentException;
    Object set(Position<Object> p, Object e) throws IllegalArgumentException;
    Object remove(Position<Object> p) throws IllegalArgumentException;
}
