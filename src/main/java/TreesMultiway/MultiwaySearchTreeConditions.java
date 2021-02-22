package TreesMultiway;

import TreesMultiway.MultiwaySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class MultiwaySearchTreeConditions {

    //Condition 1: every node has at most 7 children.
    public static boolean satisfiesCondition1(MultiwaySearchTree tree) {
        if (tree == null) return true;

        Queue<MultiwaySearchTree> q = new LinkedList<>();
        q.add(tree);

        while(!q.isEmpty()) {
            MultiwaySearchTree node = q.poll();

            MultiwaySearchTree[] children = node.getChildren();
            int count = 0;
            for(MultiwaySearchTree child : children) {
                if (child!=null) count++;
            }

            if (count > 7) return false;

            if (children != null) {
                for(MultiwaySearchTree child : children) {
                    if (child != null) q.add(child);
                }
            }
        }

        return true;
    }

    //Condition 2: every non-leaf node (except the root) has at least 4 children.
    public static boolean satisfiesCondition2(MultiwaySearchTree tree) {
        if (tree==null) return true;

        Queue<MultiwaySearchTree> q = new LinkedList<>();

        // put children in queue
        MultiwaySearchTree[] rootChildren = tree.getChildren();
        if (rootChildren != null) {
            for(MultiwaySearchTree child : rootChildren) {
                if (child != null) q.add(child);
            }
        }

        while(!q.isEmpty()) {
            MultiwaySearchTree node = q.poll();
            if (isLeaf(node)) continue;

            int children = 0;
            for(MultiwaySearchTree child : node.getChildren()){
                if (child!=null) children++;
            }

            if (children < 4) return false;

            for(MultiwaySearchTree child : node.getChildren()) {
                if (child != null) q.add(child);
            }
        }

        return true;
    }

    //Condition 3: the root has at least two children if it is not a leaf node.
    public static boolean satisfiesCondition3(MultiwaySearchTree tree) {
        if (tree==null || isLeaf(tree)) return true;

        int children = 0;
        for(MultiwaySearchTree child : tree.getChildren()) {
            if (child != null) children++;
        }

        if (children < 2) return false;
        else return true;
    }


    //check if root of tree is a leaf
    public static boolean isLeaf(MultiwaySearchTree tree) {
        if (tree==null) return false;
        MultiwaySearchTree[] children = tree.getChildren();
        // if even one child is non null -> not leaf
        for(MultiwaySearchTree child : children) {
            if (child != null) return false;
        }
        return true;
    }

}
