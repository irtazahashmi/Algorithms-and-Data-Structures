package Lists;
import java.util.Objects;

public class SLList<T> {

        public class Node {

            // Each node object has these two fields
            private Object element;
            private Node next;

            // Constructor: Creates a Node object with element = e and next = n
            Node(Object e, Node n) {
                element = e;
                next = n;
            }


            // This function gets Object e as input and sets e as the element of the Node
            public void setElement(Object e) {
                element = e;
            }

            // This function returns the element variable of the Node
            public Object getElement() {
                return element;
            }

            // This function gets Node n as input and sets the next variable of the current Node object as n.
            public void setNext(Node n) {
                next = n;
            }

            // This function returns the next Node
            public Node getNext() {
                return next;
            }

            public Integer getValue() {return (Integer) element;};
        }

    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public SLList() {
        head = null;
    }

    /**
     * @return The element in the head Node of the SLL
     */
    public Object getHead() {
        return head.getElement();
    }

    // to get node of the head!
    public Node getHeadNode() {return head;}

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(Object e) {
        if (e!=null) {
            if (head == null) {
                Node n = new Node(e, null);
                head = n;
            } else {
                Node n = new Node(e, head);
                head = n;
            }
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        if (head == null) return null;
        else {
            if (head.next == null) {
                Object r = head.getElement();
                head = null;
                return r;
            } else {
                Object r = head.getElement();
                head = head.next;
                return r;
            }
        }
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addLast(Object e) {
        if (e!=null) {
            if (head == null) {
                Node n = new Node(e, null);
                head = n;
            } else {
                Node n = new Node(e, null);
                Node curr = head;

                while(curr.next!=null) {
                    curr = curr.next;
                }

                curr.next = n;
            }
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (head == null) return null;
        else {
            if (head.next == null) {
                Object r = head.getElement();
                head = null;
                return r;
            } else {

                Node curr = head;
                Node prev = null;

                while(curr.next!=null) {
                    prev = curr;
                    curr = curr.next;
                }

                Object r = curr.getElement();
                prev.next = null;
                return r;
            }
        }
    }


    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (pos == 0) return removeFirst();
        else if (pos == size() - 1) return removeLast();
        else {

            Object r = null;
            Node curr = head;
            Node prev = null;
            int currPos = 0;

            while(curr != null) {
                if (currPos == pos) {
                    r = curr.getElement();
                    prev.next = curr.next;
                    break;
                } else {
                    prev = curr;
                    curr = curr.next;
                    currPos++;
                }
            }

            return r;
        }
    }

    public SLList<Pair<T, T>> zip(SLList<T> other) {
        SLList<Pair<T, T>> res = new SLList<>();
        if (other == null) {
            return res;
        }

        Node thisH = this.head;
        Node otherH = other.head;

        while (thisH != null && otherH != null) {
            Pair<Object,Object> p = new Pair<Object, Object>(thisH.getElement(), otherH.getElement());
            res.addLast(p);

            thisH = thisH.next;
            otherH = otherH.next;
        }

        return res;
    }

    public void addAfter(Node node, int e) {
        if (head == null) return;
        Node newNode = new Node(e, node.getNext());
        node.setNext(newNode);
    }

    /**
     * Appends another SLL to this SLL.
     *
     * @param other
     *     The list to append to this list. Is treated as an empty list if it is null.
     */
    public void append(SLList<T> other) {
        if (this.head == null) {
            this.head = other.head;
            return;
        }
        if (other == null) {
            return;
        }

        Node thisH = this.head;
        Node oH = other.head;

        while (thisH.next != null) {
            thisH = thisH.next;
        }

        thisH.next = oH;
    }

    /**
     * Removes all elements at the even positions in this list.
     * Note that the head of the list is element number 0, which is an even position.
     */
    public void dropEven() {
        if(head==null) {
            return;
        } else if (head.next == null){
            removeFirst();
        } else {
            int size = size();
            for (int i = 0; i < size; i++) {
                T e = (T) removeFirst();

                if (i % 2 != 0) {
                    addLast(e);
                }
            }
        }
    }

    public int size() {
        int s = 0;
        if (head == null) {
            return s;
        } else {
            Node c = head;
            while (c!=null) {
                c = c.next;
                s++;
            }
            return s;
        }
    }

    public SLList<T> clone() throws CloneNotSupportedException {
    	SLList<T> other = (SLList<T>) super.clone();
    	if (size() > 0) {
    		other.head = new Node(head.getElement(), null);
    		Node walk = head.getNext();
    		Node otherTail = other.head;
    		while(walk != null) {
    			Node newest = new Node(walk.getElement(), null);
    			otherTail.setNext(newest);
    			otherTail = newest;
    			walk = walk.getNext();
    		}
    	}
    	return other;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SLList other = (SLList) o;
        if (size() != other.size()) return false;
        Node currA = head;
        Node currB = other.head;
        while(currA != null) {
            if (!Objects.equals(currA.getElement(), currB.getElement())) return false;
            currA = currA.getNext();
            currB = currB.getNext();
        }
        return true;
    }

    public String toString() {
    	StringBuilder sb = new StringBuilder("(");
    	int si = 0;
    	Node curr = head;
    	while(curr!=null) {
    		sb.append(curr.getElement());
    		if (si != size() - 1) sb.append(",");
    		curr = curr.getNext();
    		si++;
    	}
    	sb.append(")");
    	return sb.toString();
    }






    static class Pair<A, B> {
        private A a;
        private B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(a, pair.a) && Objects.equals(b, pair.b);
        }

        @Override
        public String toString() {
            return "Pair{" + a + ", " + b + '}';
        }
    }
}



