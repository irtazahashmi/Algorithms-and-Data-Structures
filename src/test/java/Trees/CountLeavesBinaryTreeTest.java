package Trees;

import TreesBinary.BinaryTree;
import TreesBinary.CountLeavesBinaryTree;
import org.junit.Test;
import static org.junit.Assert.*;

public class CountLeavesBinaryTreeTest {

        @Test
        public void testEmptyTree() {
            assertEquals(0, CountLeavesBinaryTree.countLeaves(null));
        }

        @Test
        public void testOneLevel() {
            BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
            assertEquals(2, CountLeavesBinaryTree.countLeaves(tree));
        }

        @Test
        public void testOneLeftChild() {
            BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
            assertEquals(1, CountLeavesBinaryTree.countLeaves(tree));
        }
}