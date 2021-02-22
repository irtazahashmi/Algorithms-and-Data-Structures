package Heaps;

public class FindLastPosition {

	// get the last node in the heap (logn)
    public static HeapLinkedTree.Node findLastPosition(HeapLinkedTree heap) {
        if (heap == null) return null;
    
    	int height = (int) Math.floor(Math.log(heap.size()) / Math.log(2));
    	int index = heap.size() - (int) Math.pow(2, height);
    
    	int mask = 1 << (height - 1);
    	HeapLinkedTree.Node node = heap.getRoot();
    
	    for(int i = 0; i < height; i++) {
	      if ((mask & index) == 0) node = heap.getLeft(node);
	      else node = heap.getRight(node);
	      mask = mask >> 1;
	    }
	    
	    return node;
    }
}
