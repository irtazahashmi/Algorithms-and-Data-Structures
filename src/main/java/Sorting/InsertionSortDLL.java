package Sorting;

import Lists.DLList;

public class InsertionSortDLL {

    static DLList insertionSort(DLList list) {
        DLList res = new DLList();
        if (list == null) return null;
        if (list.getHeadNode() == null) return res;

        res.addFirst(list.removeFirst());

        while (list.getHeadNode() != null) {
            DLList.Node currNode = (DLList.Node) list.getHeadNode();
            DLList.Node sortedNode = (DLList.Node) res.getHeadNode();

            if (sortedNode.getValue() > currNode.getValue()) {
                res.addFirst(list.removeFirst());
            } else {
                while(sortedNode.getNext() != null && sortedNode.getNext().getValue() < currNode.getValue())
                    sortedNode = sortedNode.getNext();

                res.addAfter(sortedNode, list.removeFirst());
            }
        }
        return res;
    }
}
