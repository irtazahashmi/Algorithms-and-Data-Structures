package TreesAVL;

import TreesBinary.BinaryTree;

public class CheckHeightBalanceProperty {
    public static boolean isTreeBalanced(BinaryTree tree) {
        if (tree==null) return true;
        else {
            int leftH = height(tree.getLeft());
            int rightH = height(tree.getRight());

            if (Math.abs(leftH - rightH) <= 1) return true;
            else return false;
        }
    }

    public static int height(BinaryTree tree){
        if (tree==null) return 0;
        else {
            int left = 0;
            int right = 0;

            if(tree.getLeft() != null) left = height(tree.getLeft());
            if (tree.getRight() != null) right = height(tree.getRight());
            return 1 + Math.max(left, right);
        }
    }
}
