package Queue;

import Lists.SLList;

public class SLLQueue {
    private SLList list = new SLList();

    public SLLQueue() {}
    public int size() {return list.size();}
    public boolean isEmpty() {return list.size() == 0;}
    public void enqueue(Object element) {list.addLast(element);}
    public Object first() {return list.getHead();}
    public Object dequeue() {return list.removeFirst();}
    public String toString() {return list.toString();}
}
