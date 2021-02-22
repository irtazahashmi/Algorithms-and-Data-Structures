package Trees;

import java.util.ArrayList;
import java.util.List;

public class Tree {
        private int key;
        private List<Tree> children;

        /**
         * Constructor without children
         * @param key - the key of the root
         */
        public Tree(int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }

        /**
         * Constructor with children
         * @param key - the key of the root
         * @param children - a list of all the children
         */
        public Tree(int key, List<Tree> children) {
            this.key = key;
            this.children = children;
        }

        /**
         * @return the key of the root of this tree
         */
        public int getKey() {
            return this.key;
        }

        /**
         * @return the children of the root of this tree
         */
        public List<Tree> getChildren() {
            return this.children;
        }

        /**
         * Add a children (subtree with one or more nodes) to this tree.
         * @param tree - the tree that needs to be added
         */
        public void addChildren(Tree tree) {
            this.children.add(tree);
        }
}
