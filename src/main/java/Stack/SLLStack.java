package Stack;

import Lists.SLList;

public class SLLStack {
    public SLList list;

    public SLLStack() {
        this.list = new SLList();
    }

    public int size() { return list.size(); }
    public boolean isEmpty() { return list.size() == 0; }
    public void push(Object element) { list.addFirst(element); }
    public Object top() {return list.getHead();}
    public Object pop() {return list.removeFirst();}
    public String toString() {return list.toString();}
}

