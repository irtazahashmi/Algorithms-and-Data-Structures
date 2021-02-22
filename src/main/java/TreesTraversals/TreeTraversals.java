package TreesTraversals;
import TreesBinary.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class TreeTraversals {
    public static List<BinaryTree> getAllNodesDF(BinaryTree tree, String order) {
        if (tree == null) return new ArrayList<>();

        if (order.equals("preorder")) {
            List<BinaryTree> currList = new ArrayList<>();
            currList.add(tree);
            traverseLeft(tree, currList, "preorder");
            traverseRight(tree, currList, "preorder");
            return currList;
        } else if (order.equals("postorder")) {
            List<BinaryTree> currList = new ArrayList<>();
            traverseLeft(tree, currList, "postorder");
            traverseRight(tree, currList, "postorder");
            currList.add(tree);
            return currList;
        } else {
            List<BinaryTree> currList = new ArrayList<>();
            traverseLeft(tree, currList, "inorder");
            currList.add(tree);
            traverseRight(tree, currList, "inorder");
            return currList;
        }
    }

    private static void traverseLeft(BinaryTree tree, List<BinaryTree> list, String order) {
        if (tree.hasLeft()) {
            list.addAll(getAllNodesDF(tree.getLeft(), order));
        }
    }

    private static void traverseRight(BinaryTree tree, List<BinaryTree> list, String order) {
        if (tree.hasRight()) {
            list.addAll(getAllNodesDF(tree.getRight(), order));
        }
    }
}


