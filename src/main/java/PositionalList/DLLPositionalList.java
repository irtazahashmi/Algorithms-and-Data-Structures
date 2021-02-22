package PositionalList;


import javafx.geometry.Pos;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Using a DLL to implement Positional List
public class DLLPositionalList implements PositionalList<Object> {

    //node implements position object
    private class Node implements Position<Object> {
        private Object element;
        private Node prev;
        private Node next;

        public Node(Object e, Node p, Node n) {
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public Object getElement() throws IllegalArgumentException {
            if (next == null) throw new IllegalArgumentException();
            return element;
        }

        public Node getPrev() {return prev;}
        public Node getNext() {return next;}
        public void setElement(Object e) {element = e;}
        public void setPrev(Node p) {prev = p;}
        public void setNext(Node n) {next = n;}
    }

    private Node header;
    private Node trailer;
    private int size = 0;

    public DLLPositionalList() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.setNext(trailer);
    }

    // Validates position and returns it as a Node
    private Node validate(Position<Object> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("invalid p");
        Node node = (Node) p;
        if (node.getNext() == null) throw new IllegalArgumentException("p no longer in list");
        return node;
    }

    // Returns given Node as Position
    private Position<Object> position(Node node) {
        if (node == header || node == trailer) return null;
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<Object> first() {
        return position(header.getNext());
    }

    @Override
    public Position<Object> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<Object> before(Position<Object> p) throws IllegalArgumentException {
        Node node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<Object> after(Position<Object> p) throws IllegalArgumentException {
        Node node = validate(p);
        return position(node.getNext());
    }

    private Position<Object> addBetween(Object e, Node pred, Node succ) {
        Node newNode = new Node(e, pred, succ);
        pred.setNext(newNode);
        succ.setPrev(newNode);
        size++;
        return newNode;
    }

    @Override
    public Position<Object> addFirst(Object e) {
        return addBetween(e, header, header.getNext());
    }

    @Override
    public Position<Object> addLast(Object p) {
        return addBetween(p, trailer.getPrev(), trailer);
    }

    @Override
    public Position<Object> addBefore(Position<Object> p, Object e) throws IllegalArgumentException {
        Node node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    @Override
    public Position<Object> addAfter(Position<Object> p, Object e) throws IllegalArgumentException {
        Node node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public Object set(Position<Object> p, Object e) throws IllegalArgumentException {
        Node node = validate(p);
        Object remove = node.getElement();
        node.setElement(e);
        return remove;
    }

    @Override
    public Object remove(Position<Object> p) throws IllegalArgumentException {
        Node node = validate(p);
        Node pred = node.getPrev();
        Node succ = node.getNext();
        pred.setNext(succ);
        succ.setPrev(pred);
        size--;
        Object remove = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return remove;
    }

    public String toString() {
        if (header.getNext() == trailer) return "Empty List";
        StringBuilder sb = new StringBuilder();
        Node curr = header.getNext();
        while(curr != trailer) {
            sb.append(curr.getElement() + " ");
            curr = curr.getNext();
        }
        return sb.toString();
    }
}
