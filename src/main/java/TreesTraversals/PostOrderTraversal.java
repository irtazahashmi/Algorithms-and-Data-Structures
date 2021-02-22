package TreesTraversals;

import TreesBinary.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public static List<Integer> postOrder(BinaryTree tree) {
        List<Integer> res = new ArrayList<>();
        if (tree==null){
            return res;
        }else{

            left(tree, res);
            right(tree, res);
            res.add(tree.getKey());

            return res;
        }
    }

    public static void left(BinaryTree tree, List<Integer> list){
        if (tree.getLeft()!=null){
            list.addAll(postOrder(tree.getLeft()));
        }
    }


    public static void right(BinaryTree tree, List<Integer> list){
        if (tree.getRight()!=null){
            list.addAll(postOrder(tree.getRight()));
        }
    }

}
