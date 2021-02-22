package Trees;

import java.util.ArrayList;
import java.util.List;

public class CountNodesWithEvenChildren {
    public static int countNodesWithEvenChildren(LibraryTree tree) {
        if (tree == null) return 0;
        else{
            List<LibraryTree> children = tree.getChildren();
            int count = 0;

            if (children.isEmpty()) count++;
            else {
                if (children.size() % 2 == 0) count++;

                for(int i = 0; i < children.size();i++){
                    count += countNodesWithEvenChildren(children.get(i));
                }
            }
            return count;
        }
    }



    static class LibraryTree {
        private int key;
        private List<LibraryTree> children;

        public LibraryTree(int key) {
            this.key = key;
            children = new ArrayList<>();
        }

        public LibraryTree(int key, List<LibraryTree> children) {
            this.key = key;
            this.children = children;
        }

        public int getKey() {
            return this.key;
        }

        public List<LibraryTree> getChildren() {
            return this.children;
        }
    }
}
