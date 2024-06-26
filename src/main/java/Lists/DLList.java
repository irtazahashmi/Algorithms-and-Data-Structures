package Lists;

public class DLList {
    public class Node {
        // Each node object has these three fields
        private Object element;
        private Node previous;
        private Node next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        Node(Object e, Node p, Node n) {
            element = e;
            previous = p;
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

        // This function gets Node p as input and sets the previous variable of the current Node object as p.
        public void setPrevious(Node p) {
            previous = p;
        }

        // This function returns the previous Node
        public Node getPrevious() {
            return previous;
        }

        //returns integer value of element
        public Integer getValue() {return (Integer) element;};
    }

    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private Node head;
    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private Node tail;

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public DLList() {
        head = null;
        tail = null;
    }

    /**
     * @return The element in the head Node of the DLL
     */
    public Object getHead() {
        return head.getElement();
    }

    //returns head node itself!!
    public Node getHeadNode() {
        return head;
    }

    /**
     * @return The element in the tail Node of the DLL
     */
    public Object getTail() {
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addFirst(Object e) {
        if (e == null) {
            return;
        } else {
            if (head == null) {
                Node n = new Node(e, null, null);
                head = n;
                tail = n;
            } else {
                Node n = new Node(e, null, head);
                head.previous = n;
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
        if (head == null) {
            return null;
        } else {
            if (head == tail) {
                Object r = head.getElement();
                head = null;
                tail = null;
                return r;
            } else {
                Object r = head.getElement();
                head = head.next;
                head.previous = null;
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
        if (e == null) {
            return;
        } else {
            if (head == null) {
                Node n = new Node(e, null, null);
                head = n;
                tail = n;
            } else {
                Node n = new Node(e, tail, null);
                tail.next = n;
                tail = n;
            }
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (head == null) {
            return null;
        } else {
            if (head == tail) {
                Object r = head.getElement();
                head = null;
                tail = null;
                return r;
            } else {
                Object r = tail.getElement();
                tail = tail.previous;
                tail.next = null;
                return r;
            }
        }
    }

    /**
     * @return the number of Nodes in the list
     */
    public int size() {
        if(head == null) {
            return 0;
        } else {
            int s = 0;
            Node curr = head;
            while(curr != null) {
                curr = curr.next;
                s++;
            }

            return s;
        }
    }

    /**
     * Adds element e in a new Node which is inserted at position pos.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
     * If there is no Node in position pos, this method adds it to the last position.
     *
     * @param pos
     *     The position to insert the element at.
     * @param e
     *     The element to add.
     */
    public void addAtPosition(int pos, Object e) {
        if (e == null) {
            return;
        } else {
            if (pos == 0) {
                addFirst(e);
            } else if (pos < 0 || pos >= size()) {
                addLast(e);
            } else {
                Node curr = head;
                Node prev = null;
                int currPos = 0;
                Node n = new Node(e, null, null);

                while(curr != null) {
                    if (pos == currPos) {
                        prev.next = n;
                        n.previous = prev;
                        n.next = curr;
                        curr.previous = n;
                        break;

                    } else {
                        prev = curr;
                        curr = curr.next;
                        currPos++;
                    }
                }
            }
        }
    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos
     *     The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (head == null) {
            return null;
        } else {
            if (pos == 0) {
                return removeFirst();
            } else if (pos == size() - 1) {
                return removeLast();
            } else {
                Node curr = head;
                Node prev = null;
                int currPos = 0;
                Object r = null;

                while(curr != null) {
                    if (pos == currPos) {
                        r = curr.getElement();
                        prev.next = curr.next;
                        curr.next.previous = prev;
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
    }

    public void addBetween(Object e, Node prev, Node succ) {
        Node newNode = new Node(e, prev, succ);
        prev.setNext(newNode);
        succ.setPrevious(newNode);
    }

    /**
     * @return A new DLL that contains the elements of the current one in reversed order.
     */
    public DLList reverse() {
        DLList re = new DLList();
        Node curr = head;
        while (curr != null) {
            re.addFirst(curr.getElement());
            curr = curr.next;
        }

        return re;
    }

    public String toString() {
        if (head == null) return "EMPTY";
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr!=null) {
            sb.append(curr.getElement() + " ");
            curr = curr.next;
        }
        return sb.toString();
    }

    public void addAfter(Node node, Object e) {
        Node newNode = new Node(e, node, node.getNext());
        node.setNext(newNode);
        node.next.setPrevious(newNode);
    }
}
