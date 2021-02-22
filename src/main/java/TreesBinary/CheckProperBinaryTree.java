package TreesBinary;

import TreesBinary.BinaryTree;

public class CheckProperBinaryTree {
    public static boolean isFullTree(BinaryTree root) {
        if(root == null) return true;

        if(root.getLeft() == null && root.getRight() == null ) return true;

        if(root.getLeft() != null && root.getRight() != null)
            return isFullTree(root.getLeft()) && isFullTree(root.getRight());

        return false;
    }

}
