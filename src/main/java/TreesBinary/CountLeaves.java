package TreesBinary;

import TreesBinary.BinaryTree;

public class CountLeaves {

    // Count LEAVES!
    public static int countLeaves(BinaryTree tree) {
        if (tree==null) return 0;
        else{
            int count = 0;

            if (tree.getLeft() == null && tree.getRight()==null) count++;
            else {
                count+=countLeaves(tree.getLeft());
                count+=countLeaves(tree.getRight());
            }

            return count;
        }
    }
}

