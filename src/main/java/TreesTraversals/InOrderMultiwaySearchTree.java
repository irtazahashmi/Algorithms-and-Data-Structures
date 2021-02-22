package TreesTraversals;

import TreesMultiway.MultiwaySearchTree;

import java.util.ArrayList;

public class InOrderMultiwaySearchTree {

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
