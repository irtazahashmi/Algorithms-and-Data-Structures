package TreesBinary;

import TreesBinary.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteBinaryTree {

    public static boolean isCompleteBST(BinaryTree root) {
        if (root == null) return true;

        Queue<BinaryTree> q = new LinkedList<>();
        q.add(root);
        boolean isComplete = false;
        while(!q.isEmpty()) {
            BinaryTree t = q.poll();

            if(t.getLeft() != null) {
                if (isComplete) return false;
                q.add(t.getLeft());
            } else isComplete = true;

            if(t.getRight() != null) {
                if(isComplete) return false;
                q.add(t.getRight());
            } else isComplete = true;
        }

        return true;
    }
}
