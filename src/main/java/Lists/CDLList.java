package Lists;

class CDLList<T> {
    class Node {
        // Each Node object has these three fields
        private T element;
        private Node previous;
        private Node next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        Node(T e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        // This function gets T e as input and sets e as the element of the Node
        public void setElement(T e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public T getElement() {
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
    }

    // Each object in Lists.CDLList has one field head, which points to the starting Node of Lists.CDLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public CDLList() {
        head = null;
    }

    /**
     * @return The element in the first Node of this CDLL. If the list is empty, this method returns null.
     */
    public T getFirst() {
        if (head != null) {
            return head.element;
        } else {
            return null;
        }
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(T e) {
        if (e == null) {
            return;
        } else {
            if (head == null) {
                Node newNode = new Node(e, null, null);
                newNode.next = newNode;
                newNode.previous = newNode;
                head = newNode;
            } else {
                Node newNode = new Node(e, head, head.next);
                head.next.previous = newNode;
                head.next = newNode;
                head = head.next;
            }
        }
    }


    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the first Node. If the list is empty, this method returns null.
     */
    public T removeFirst() {
        if (head == null) {
            return null;
        } else {
            T r = head.getElement();
            if (head.next == head) {
                head = null;
            } else {
                head.previous.next = head.next;
                head.next.previous = head.previous;
                head = head.next;
            }
            return r;
        }
    }
    

    /**
     * @return The element in the last Node of the CDLL. If the list is empty, this method returns null.
     */
    public T getLast() {
        if (head != null) {
            return head.previous.element;
        } else {
            return null;
        }
    }

    /**
     * Adds element e in a new Node to the end of the list.
     *
     * @param e The element to add.
     */
    public void addLast(T e) {
        if (head != null) {
            Node newNode = new Node(e, head.previous, head);
            head.previous.next = newNode;
            head.previous = newNode;
        } else {
            addFirst(e);
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the last Node. If the list is empty, this method returns null.
     */
    public T removeLast() {
        if (head==null) {
            return null;
        } else {
            T r = head.previous.getElement();
            if (head.next == head) {
                head = null;
            } else {
                head.previous.previous.next = head;
                head.previous = head.previous.previous;
            }
            return r;
        }
    }

    /**
     * Moves the head reference to the next element.
     */
    public void rotateForward() {
        if (head != null) {
            head = head.next;
        }
    }

    /**
     * Moves the head reference to the previous element.
     */
    public void rotateBackward() {
        if (head != null) {
            head = head.previous;
        }
    }
}

