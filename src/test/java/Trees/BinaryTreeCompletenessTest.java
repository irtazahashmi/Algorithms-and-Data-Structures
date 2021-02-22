package Trees;

import TreesBinary.BinaryTree;
import org.junit.Test;

import static Trees.BinaryTreeCompleteness.isTreeComplete;
import static org.junit.Assert.*;

public class BinaryTreeCompletenessTest {
    @Test
    public void testEmptyTree() {
        assertTrue(isTreeComplete(null));
    }

    @Test
    public void testOneLevel() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertTrue(isTreeComplete(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(isTreeComplete(tree));
    }

    @Test
    public void testOneRightChild() {
        BinaryTree tree = new BinaryTree(42, null, new BinaryTree(21));
        assertFalse(isTreeComplete(tree));
    }

}