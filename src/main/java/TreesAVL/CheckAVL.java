package TreesAVL;

import TreesBinary.BinaryTree;

public class CheckAVL {

    public static boolean isTreeAVL(BinaryTree tree) {
        if (tree==null) return true;
        if (!isBST(tree)) return false;
        if (!isTreeBalanced(tree)) return false;
        return isTreeAVL(tree.getLeft()) && isTreeAVL(tree.getRight());
    }

    public static boolean isBST(BinaryTree tree) {
        return isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST(BinaryTree tree, int min, int max) {
        if (tree==null) return true;
        if (tree.getKey() <= min || tree.getKey() >= max) return false;
        return isBST(tree.getLeft(), min, tree.getKey()) && isBST(tree.getRight(), tree.getKey(), max);
    }


    public static boolean isTreeBalanced(BinaryTree tree) {
        if (tree==null) return true;
        if (Math.abs(getHeight(tree.getLeft()) - getHeight(tree.getRight())) <= 1) return true;
        return false;
    }

    public static int getHeight(BinaryTree tree) {
        if (tree== null) return 0;
        int left = getHeight(tree.getLeft());
        int right = getHeight(tree.getRight());
        return 1 + Math.max(left, right);
    }
}
