package Dequeue;

import Lists.DLList;

public class DLLDequeue {
    DLList list = new DLList();

    public DLLDequeue() {}
    public int size() {return list.size();}
    public boolean isEmpty() {return list.size() == 0;}
    public Object first() {return list.getHead();}
    public Object last() {return list.getTail();}
    public void addFirst(Object element) {list.addFirst(element);}
    public void addLast(Object element) {list.addLast(element);}
    public Object removeFirst() {return list.removeFirst();}
    public Object removeLast() {return list.removeLast();}
}
