package TreesMultiway;

import TreesMultiway.MultiwaySearchTree;

import java.util.ArrayList;

public class CheckMultiwaySearchTree {

    //Check the tree is a multiway search tree with DISTINCT keys.

    public static boolean checkMST(MultiwaySearchTree tree) {
        return rightNumberOfKids(tree) && isSortedAndUnique(inOrderTraversal(tree));
    }

    public static boolean rightNumberOfKids(MultiwaySearchTree tree) {
        if (tree == null) return true;
        int[] values = tree.getKeys();
        MultiwaySearchTree[] kids = tree.getChildren();
        if (values.length != kids.length - 1) return false;
        for (int i = 0; i < kids.length - 1; i++) {
            if (!rightNumberOfKids(kids[i])) return false;
        }
        return true;
    }

    // multiway search tree sorted properly using inOrderTraversal
    public static boolean isSortedAndUnique(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    // In order traversal of multiway search tree
    public static ArrayList<Integer> inOrderTraversal(MultiwaySearchTree tree) {
        if (tree == null) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] values = tree.getKeys();
        MultiwaySearchTree[] kids = tree.getChildren();
        for (int i = 0; i < kids.length - 1; i++) {
            result.addAll(inOrderTraversal(kids[i]));
            result.add(values[i]);
        }
        if (kids.length > 0) result.addAll(inOrderTraversal(kids[kids.length - 1]));
        return result;
    }
}
