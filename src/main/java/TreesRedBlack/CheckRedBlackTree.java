package TreesRedBlack;

public class CheckRedBlackTree {
    public static boolean isRedBlackTree(RedBlackTree tree) {
        return isSearchTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE) && isRootBlack(tree) && childRedBlack(tree) && blackDepth(tree);
    }

    // root is black
    private static boolean isRootBlack(RedBlackTree tree) {
        return tree.isBlack();
    }

    // is child red black
    private static boolean childRedBlack(RedBlackTree tree) {
        if (tree == null) return true;
        if (tree.isRed()) {
            if (tree.getLeft() != null) {
                if (!tree.getLeft().isBlack()) return false;
            }
            if (tree.getRight()!=null){
                if (!tree.getRight().isBlack()) return false;
            }
        }

        return childRedBlack(tree.getLeft()) && childRedBlack(tree.getRight());
    }

    // all external nodes have same black  depth
    private static boolean blackDepth(RedBlackTree tree) {
        return blackDepth(tree, 0) >= 0;
    }

    public static int blackDepth(RedBlackTree tree, int d) {
        if (tree == null) return d;
        if (!(tree.hasLeft() || tree.hasRight())) return tree.isBlack() ? d + 1 : d;
        int left = blackDepth(tree.getLeft(), d);
        int right = blackDepth(tree.getRight(), d);
        if (left != right || left == -1) return -1;
        return tree.isBlack() ? left + 1 : left;
    }

    // is bst
    private static boolean isSearchTree(RedBlackTree tree, int low, int high) {
        if (tree == null) return true;
        if (tree.getValue() > high || tree.getValue() < low) return false;
        return isSearchTree(tree.getLeft(), low, tree.getValue() - 1) && isSearchTree(tree.getRight(), tree.getValue() + 1, high);
    }
}

