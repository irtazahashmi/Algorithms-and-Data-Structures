package TreesBinary;

import TreesBinary.BinaryTree;

public class CountNodesAtALevel {

    public static int countNodesAtLevel(BinaryTree tree, int level) {
        if (tree==null)return 0;
        else return count(tree, 0, level);
    }

    public static int count(BinaryTree tree, int currLevel, int level){
        if (tree==null) return 0;
        else {
            if(currLevel == level) return 1;
            else return count(tree.getLeft(), currLevel + 1, level) +
                        count(tree.getRight(), currLevel + 1, level);
        }
    }
}
