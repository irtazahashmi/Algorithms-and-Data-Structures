package Sorting;

import java.util.LinkedList;
import java.util.Objects;

public class InsertionSortSLL {

    static SLList insertionSort(SLList list) {
        SLList res = new SLList();
        if (list == null) return null;
        if (list.getFirst() == null) return res;

        res.addFirst(list.removeFirst());

        while (list.getFirst() != null) {
            SLList.Node currNode = list.getFirst();
            SLList.Node sortedNode = res.getFirst();

            if (sortedNode.getElement() > currNode.getElement()) {
                res.addFirst(list.removeFirst());
            } else {

                while(sortedNode.getNext() != null && sortedNode.getNext().getElement() < currNode.getElement())
                    sortedNode = sortedNode.getNext();

                res.addAfter(sortedNode, list.removeFirst());
            }
        }
        return res;
    }


}
//ANOTHER INSERTION SORT LIST USING REFERENCE TO HEAD
// public ListNode insertionSortList(ListNode head) {
//         if (head == null) return null;
//         if (head.next == null) return head;
        
//         ListNode res = new ListNode();
     
        
//         while(head != null) {
//             ListNode node = res;
//             while (node.next != null && node.next.val < head.val) {
//                 node = node.next;
//             }
            
//             ListNode temp = head.next;
//             head.next = node.next;
//             node.next = head;
//             head = temp;
//         }
        
//         return res.next;
//     }


class SLList {
    class Node {
        // Each Node object has these two fields
        private int element;
        private Node next;

        // Constructor: Creates a Node object with element = e and next = n
        Node(int e, Node n) {
            element = e;
            next = n;
        }

        // This function gets int e as input and sets e as the element of the Node
        public void setElement(int e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public int getElement() {
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
    }

    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public SLList() {
        head = null;
    }

    public SLList(int... elements) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (int element : elements) {
            reversed.add(element);
        }
        while (!reversed.isEmpty()) {
            this.addFirst(reversed.removeLast());
        }
    }

    /**
     * @return The element in the first Node of this SLL. If the list is empty, this method returns null.
     */
    public Node getFirst() {
        if (head == null)
            return null;
        return head;
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e
     *     The element to add.
     */
    public void addFirst(int e) {
        head = new Node(e, head);
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the first Node.
     * @throws NullPointerException
     *     If the list is empty.
     */
    public int removeFirst() {
        Node result = head;
        head = head.getNext();
        return result.getElement();
    }

    /**
     * Adds an element after an already existing node.
     *
     * @param node
     *     The node to add a new element after.
     * @param e
     *     The new element to add.
     */
    public void addAfter(Node node, int e) {
        Node newNode = new Node(e, node.getNext());
        node.setNext(newNode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SLList slList = (SLList) o;
        Node a = this.head;
        Node b = slList.head;
        while (a != null && b != null) {
            if (!Objects.equals(a.getElement(), b.getElement())) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return Objects.equals(a, b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SLList[");
        Node current = this.head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(",");
            current = current.next;
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }
}

