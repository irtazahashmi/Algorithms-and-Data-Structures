package TreesMultiway;
import TreesMultiway.CheckMultiwaySearchTree;
import TreesMultiway.MultiwaySearchTree;

import java.util.ArrayList;

public class CheckTwoFourTree {

    public static boolean checkTwoFourTree(MultiwaySearchTree tree) {
        return CheckMultiwaySearchTree.checkMST(tree) && checkSizeProperty(tree)
                && checkDepthProperty(tree);
    }

    //every non-null node has at most four children
    public static boolean checkSizeProperty(MultiwaySearchTree tree) {
        if (tree == null) return true;
        MultiwaySearchTree[] children = tree.getChildren();
        if (children.length > 4) return false;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                if (!checkSizeProperty(children[i])) return false;
            }
        }
        return true;
    }

    //all null nodes have the same depth
    public static boolean checkDepthProperty(MultiwaySearchTree tree) {
        if(tree == null) return true;
        int[] keys = tree.getKeys();
        MultiwaySearchTree[] children = tree.getChildren();
        int depth = -1;

        //null node
        if (children.length == 0) {
            for(int i = 0; i < keys.length; i++) {
                int newDepth = depth(tree, keys[i]);
                if (depth == -1) depth = newDepth;
                if (newDepth != depth) return false;
            }
        }

       for (int i = 0; i < children.length; i++) {
           if(!checkDepthProperty(children[i])) return false;
       }
       return true;
    }

    public static int depth(MultiwaySearchTree tree, int key) {
        if (tree == null) return 0;
        else {
            int d = 0;
            int[] keys = tree.getKeys();

            for(int i = 0; i < keys.length; i++) {
                if (keys[i] == key) return d;
            }

            MultiwaySearchTree[] children = tree.getChildren();
            for (int i = 0; i < children.length; i++) {
               d += depth(children[i], key);
            }

            return d;
        }
    }

    public static void main(String[] args) {
        int[] root = new int[2];
        root[0] = 40;
        root[1] = 60;
        MultiwaySearchTree[] children = new MultiwaySearchTree[3];
        children[0] = new MultiwaySearchTree(new int[]{14, 20}, new MultiwaySearchTree[3]);
        children[1] = new MultiwaySearchTree(new int[]{44, 45}, new MultiwaySearchTree[3]);
        children[2] = new MultiwaySearchTree(new int[]{70,72,75}, new MultiwaySearchTree[4]);
        MultiwaySearchTree tree = new MultiwaySearchTree(root, children);
        System.out.println(inOrderTraversal(tree));
        System.out.println(checkTwoFourTree(tree));
    }

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
