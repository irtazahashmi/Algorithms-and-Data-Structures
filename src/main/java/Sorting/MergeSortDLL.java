package Sorting;

import Lists.DLList;

public class MergeSortDLL {

    public static DLList mergeSort(DLList list) {
        if (list == null) return null;
        if (list.getHeadNode().getNext() == null) return list;

        DLList secondHalf = splitList(list);
        list = mergeSort(list);
        secondHalf = mergeSort(secondHalf);
        return merge(list, secondHalf);
    }

    private static DLList merge(DLList list, DLList secondList) {
        if (list == null) return secondList;
        if (secondList == null) return list;

        DLList.Node firstHead = list.getHeadNode();
        DLList.Node secondHead = secondList.getHeadNode();
        DLList merged = new DLList();

        while (firstHead != null && secondHead != null) {
            if (firstHead.getValue() <= secondHead.getValue()) {
                merged.addLast(firstHead.getValue());
                firstHead = firstHead.getNext();
            } else {
                merged.addLast(secondHead.getValue());
                secondHead = secondHead.getNext();
            }
        }

        while (firstHead != null) {
            merged.addLast(firstHead.getValue());
            firstHead = firstHead.getNext();
        }

        while (secondHead != null) {
            merged.addLast(secondHead.getValue());
            secondHead = secondHead.getNext();
        }

        return merged;
    }

    public static DLList splitList(DLList list) {
        DLList.Node fast = list.getHeadNode();
        DLList.Node slow = list.getHeadNode();

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        DLList secondList = new DLList();
        DLList.Node temp = slow.getNext();
        slow.setNext(null);
        while (temp != null) {
            secondList.addFirst(temp.getValue());
            temp = temp.getNext();
        }
        return secondList;
    }

    public static void main(String[] args) {
        DLList list = new DLList();
        list.addLast(2);
        list.addLast(6);
        list.addLast(-1);
        list.addLast(7);
        list.addLast(9);
        list.addLast(1);
        list.addLast(8);
        list.addLast(0);
        list.addLast(2);
        list.addLast(10);
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        DLList res = mergeSort(list);
        System.out.println(res.toString());
    }
}

// --------------------- MERGE SORT USING A DLL NODE ------------------------------------
//
//    public static Node sortDoubly(Node node)
//    {
//        if (node == null || node.next == null) {
//            return node;
//        }
//
//        Node second = splitList(node);
//
//
//        node = sortDoubly(node);
//        second = sortDoubly(second);
//
//
//        return merge(node, second);
//    }
//
//
//    public static Node splitList(Node node)
//    {
//        Node fast = node, slow = node;
//        while (fast.next != null && fast.next.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        Node temp = slow.next;
//        slow.next = null;
//        return temp;
//    }
//
//    public static Node merge(Node first, Node second)
//    {
//        if (first == null) {
//            return second;
//        }
//
//
//        if (second == null) {
//            return first;
//        }
//
//
//        if (first.data < second.data) {
//            first.next = merge(first.next, second);
//            first.next.prev = first;
//            first.prev = null;
//            return first;
//        } else {
//            second.next = merge(first, second.next);
//            second.next.prev = second;
//            second.prev = null;
//            return second;
//        }
//    }