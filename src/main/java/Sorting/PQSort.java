//package Sorting;

//import java.util.ArrayList;
//import java.util.List;

//public class pqSort {
//public static List<Integer> pqSort(List<Integer> list) {
//        if (list == null) return null;
//
//        LibraryPQ queue = new SolutionPQ();
//        List<Integer> res = new ArrayList<>();
//        for(Integer i : list) queue.insert(i);
//
//        int s = list.size();
//
//        while(s != 0) {
//          Integer r = queue.removeMax();
//          res.add(r);
//          s--;
//        }
//
//        return res;
//        }
//}
//
//class SolutionPQ extends LibraryPQ {
//    /**
//     * Restores the heap property in a heap represented as an arraylist.
//     * The method compares the node to its parent and swaps if necessary.
//     *
//     * @param i
//     *     index of the node
//     */
//    @Override
//    public void upHeap(int i) {
//        while(i >= 1) {
//            int parent = (i-1)/2;
//            if (getInHeap(parent) > getInHeap(i)) break;
//            swap(parent, i);
//            i = parent;
//        }
//    }
//}
