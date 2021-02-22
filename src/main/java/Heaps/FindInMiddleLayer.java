package Heaps;

public class FindInMiddleLayer {

    // find middle element in last layer (logn)

    // to get middle in second last layer for(int i = 0; i < height - 1; i++)

    public static HeapLinkedTree.Node findMiddleInLastLayer(HeapLinkedTree heap) {
        if (heap == null) return null;

        int height = (int) Math.floor(Math.log(heap.size()) / Math.log(2));
        int index = heap.size() - (int) Math.pow(2, height);
        index = index / 2;

        int mask = 1 << (height - 1);
        HeapLinkedTree.Node node = heap.getRoot();

        // if we want findMiddleInSecondLastLayer, iterate < height - 1
        for(int i = 0; i < height; i++) {
            if ((mask & index) == 0) node = heap.getLeft(node);
            else node = heap.getRight(node);
            mask = mask >> 1;
        }

        return node;
    }
}
