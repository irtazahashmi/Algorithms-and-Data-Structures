package TreesBinary;

import TreesBinary.BinaryTree;

public class CheckBST {

    public static boolean isTreeBST(BinaryTree tree) {
        return checkBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean checkBST(BinaryTree tree, int min, int max) {
        if (tree==null) {
            return true;
        }

        if (tree.getKey() <= min || tree.getKey() >= max) {
            return false;
        } else {
            return checkBST(tree.getLeft(), min, tree.getKey()) && checkBST(tree.getRight(), tree.getKey(), max);
        }
    }
}
