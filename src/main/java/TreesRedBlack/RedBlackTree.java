package TreesRedBlack;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree {
        private int value;
        private RedBlackTree left, right;
        private boolean isRed;
        private int height;

        public RedBlackTree(int value, boolean isRed) {
            this.value = value;
            this.isRed = isRed;
            this.height = 1;
        }

        public RedBlackTree(int value, boolean isRed, RedBlackTree left, RedBlackTree right) {
            this(value, isRed);
            setLeft(left);
            setRight(right);
        }

        public boolean get(int key) {
            if (value == key) return true;
            if (value < key) {
                if (left != null) return left.get(key);
            }
            else {
                if (right != null) return right.get(value);
            }
            return false; // no value in the tree
        }

        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }

        public RedBlackTree getLeft() {
            return left;
        }
        public RedBlackTree getRight() {
            return right;
        }

        public boolean isRed() {
            return isRed;
        }
        public boolean isBlack() {
            return !isRed;
        }

        public boolean hasLeft() {
            return left != null;
        }
        public boolean hasRight() {
            return right != null;
        }

        public void setLeft(RedBlackTree left) {
            this.left = left;
        }
        public void setRight(RedBlackTree right) {
            this.right = right;
        }

        public void setRed(boolean red) {
            isRed = red;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.isRed()) sb.append(value + "R ");
            else sb.append(value + "B ");
            Queue<RedBlackTree> q= new LinkedList<>();
            q.add(left);
            q.add(right);

            while(!q.isEmpty()) {
                RedBlackTree temp = q.poll();
                if (temp != null) {
                    if (temp.isRed())sb.append(temp.getValue() + "R ");
                    else sb.append(temp.getValue() + "B ");
                    if (temp.getLeft() != null) q.add(temp.getLeft());
                    if (temp.getRight() != null) q.add(temp.getRight());
                }
            }
            return sb.toString();
        }
}
