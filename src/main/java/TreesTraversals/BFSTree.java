package TreesTraversals;

import Trees.Tree;

import java.util.*;

public class BFSTree {

    public static List<Integer> bfs(Tree tree) {
        List<Integer> res = new ArrayList<>();
        if (tree == null) return res;
        else {
            Queue<Tree> q = new LinkedList<>();
            q.add(tree);

            while(!q.isEmpty()) {
                Tree temp = q.poll();
                res.add(temp.getKey());

                if(temp.getChildren() != null) q.addAll(temp.getChildren());
            }
            return res;
        }
    }
}
