package Sorting;

import Lists.SLList;

public class MergeSortSLL {

    public static SLList mergeSort(SLList list) {
        if (list == null) return null;
        if (list.getHeadNode().getNext() == null) return list;

        SLList secondHalf = splitList(list);
        list = mergeSort(list);
        secondHalf = mergeSort(secondHalf);
        return merge(list, secondHalf);
    }

    private static SLList merge(SLList list, SLList secondList) {
        if (list == null) return secondList;
        if (secondList == null) return list;

        SLList.Node firstHead = list.getHeadNode();
        SLList.Node secondHead = secondList.getHeadNode();
        SLList merged = new SLList();

        while (firstHead != null && secondHead != null) {
            if (firstHead.getValue() <= secondHead.getValue()) {
                merged.addLast(firstHead.getValue());
                firstHead = firstHead.getNext();
            } else {
                merged.addLast(secondHead.getElement());
                secondHead = secondHead.getNext();
            }
        }

        while (firstHead != null) {
            merged.addLast(firstHead.getElement());
            firstHead = firstHead.getNext();
        }

        while (secondHead != null) {
            merged.addLast(secondHead.getElement());
            secondHead = secondHead.getNext();
        }

        return merged;
    }

    public static SLList splitList(SLList list) {
        SLList.Node fast = list.getHeadNode();
        SLList.Node slow = list.getHeadNode();

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        SLList secondList = new SLList();
        SLList.Node temp = slow.getNext();
        slow.setNext(null);
        while (temp != null) {
            secondList.addFirst(temp.getElement());
            temp = temp.getNext();
        }
        return secondList;
    }

    public static void main(String[] args) {
        SLList list = new SLList();
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
        SLList res = mergeSort(list);
        System.out.println(res.toString());
    }
}



// --------------------- MERGE SORT USING A SLL NODE ------------------------------------

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode sortList(ListNode head) {
//         if (head == null) return null;
//         if (head.next == null) return head;
        
//         ListNode curr = head;
//         ListNode mid = head;
//         ListNode next = head.next;
        
//         while(next.next != null) {
//             mid = next;
//             next = next.next;
//         }
        
//         ListNode second = sortList(mid.next);
//         mid.next = null;
//         ListNode first = sortList(head);
        
//         return merge(first, second);
//     }
    
//     public ListNode merge(ListNode f, ListNode s) {
//         ListNode res = new ListNode();
//         ListNode head = res;
    
//        while(f!=null || s!=null) {
//             if (f == null) {
//             head.next = s;
//             s = s.next;
//         } else if (s == null) {
//             head.next = f;
//             f = f.next;
//         } else if (f.val > s.val) {
//             head.next = s;
//             s=s.next;
//         } else {
//              head.next = f;
//             f = f.next;
//         }
           
//            head = head.next;
//        }
        
//         return res.next;
//     }
    
    
// }