package TreesMultiway;

import java.util.Arrays;

public class MultiwaySearchTree {
    int[] keys;
    MultiwaySearchTree[] children;

    public MultiwaySearchTree(int[] keys, MultiwaySearchTree[] children) {
        this.keys = keys;
        this.children = children;
    }


    private boolean contains(MultiwaySearchTree tree, int value) {
        MultiwaySearchTree place = search(tree, value);
        int[] keys = place.getKeys();
        for (int i = 0; i < keys.length; i++) {
            if (value == keys[i]) {
                return true;
            }
        }
        return false;
    }

    private MultiwaySearchTree search(MultiwaySearchTree tree, int value) {
        if (tree == null) return null;

        int[] keys = tree.getKeys();
        MultiwaySearchTree[] kids = tree.getChildren();
        MultiwaySearchTree res = null;
        for (int i = 0; i < keys.length; i++) {
            if (value == keys[i]) {
                return tree;
            }
            if (value < keys[i]) {
                res = search(kids[i], value);
                break;
            }
        }
        if (value > keys[keys.length - 1]) {
            res = search(kids[kids.length - 1], value);
        }
        if (res == null) res = tree;
        return res;
    }

    private MultiwaySearchTree getParent(MultiwaySearchTree tree, MultiwaySearchTree node) {
        if (tree == null || tree == node) {
            return null;
        }
        int[] values = tree.getKeys();
        MultiwaySearchTree[] kids = tree.getChildren();
        MultiwaySearchTree res = null;
        for (int i = 0; i < values.length; i++) {
            if (node.getKeys()[0] == values[i]) {
                return null;
            }
            if (node.getKeys()[0] < values[i]) {
                res = getParent(kids[i], node);
                break;
            }
        }
        if (node.getKeys()[0] > values[values.length - 1]) {
            res = getParent(kids[kids.length - 1], node);
        }
        if (res == null) res = tree;
        return res;
    }

    private MultiwaySearchTree insert(MultiwaySearchTree tree, int value) {
        MultiwaySearchTree placeToInsert = search(tree, value);
        MultiwaySearchTree newRoot = insertIntoNode(tree, value, placeToInsert);
        if (newRoot == null) return tree;
        return newRoot;
    }

    private MultiwaySearchTree insertIntoNode(MultiwaySearchTree tree, int value, MultiwaySearchTree placeToInsert) {
        return insertIntoNode(tree, value, placeToInsert, true);
    }

    private MultiwaySearchTree insertIntoNode(MultiwaySearchTree tree, int value, MultiwaySearchTree placeToInsert, boolean split) {
        int maxChildren = 14;
        int insertIndex = 0;
        int[] keys = placeToInsert.getKeys();
        MultiwaySearchTree[] children = placeToInsert.getChildren();
        while (insertIndex < keys.length && keys[insertIndex] < value) {
            insertIndex++;
        }
        MultiwaySearchTree newLeaf = null;
        int[] newKeys = new int[keys.length + 1];
        MultiwaySearchTree[] newValues = new MultiwaySearchTree[children.length + 1];
        for (int i = 0; i < newKeys.length; i++) {
            newKeys[i] = i == insertIndex ? value : keys[i - (i > insertIndex ? 1 : 0)];
            newValues[i] = i == insertIndex ? newLeaf : children[i - (i > insertIndex ? 1 : 0)];
        }
        newValues[newValues.length - 1] = insertIndex == keys.length ? newLeaf : children[children.length - 1];
        placeToInsert.keys = newKeys;
        placeToInsert.children = newValues;
        if (newValues.length > maxChildren && split) {
            return split(tree, placeToInsert);
        }
        return null;
    }

    private MultiwaySearchTree split(MultiwaySearchTree tree, MultiwaySearchTree placeToInsert) {
        int maxChildren = 14;
        int[] keys = placeToInsert.getKeys();
        MultiwaySearchTree[] children = placeToInsert.getChildren();
        int[] leftKeys = new int[keys.length / 2];
        int[] rightKeys = new int[keys.length - keys.length / 2 - 1];
        MultiwaySearchTree[] leftChildren = new MultiwaySearchTree[leftKeys.length + 1];
        MultiwaySearchTree[] rightChildren = new MultiwaySearchTree[rightKeys.length + 1];
        int skippedKey = 0;
        for (int i = 0; i < keys.length; i++) {
            if (i < leftKeys.length) {
                leftKeys[i] = keys[i];
            } else if (i == leftKeys.length) {
                skippedKey = keys[i];
            } else {
                rightKeys[i - leftKeys.length - 1] = keys[i];
            }
        }
        for (int i = 0; i < children.length; i++) {
            if (i < leftChildren.length) {
                leftChildren[i] = children[i];
            } else {
                // No kid in the left most place of the right subnode.
                rightChildren[i - leftChildren.length] = children[i];
            }
        }
        MultiwaySearchTree leftSplit = new MultiwaySearchTree(leftKeys, leftChildren);
        MultiwaySearchTree rightSplit = new MultiwaySearchTree(rightKeys, rightChildren);
        MultiwaySearchTree parent = getParent(tree, placeToInsert);
        if (parent == null) {
            // This is the root
            int[] rootKeys = { skippedKey };
            MultiwaySearchTree[] rootChildren = { leftSplit, rightSplit };
            MultiwaySearchTree newRoot = new MultiwaySearchTree(rootKeys, rootChildren);
            return newRoot;
        } else {
            keys = parent.getKeys();
            children = parent.getChildren();
            int value = skippedKey;
            int insertIndex = 0;
            while (insertIndex < keys.length && keys[insertIndex] < value) {
                insertIndex++;
            }
            int[] newKeys = new int[keys.length + 1];
            MultiwaySearchTree[] newValues = new MultiwaySearchTree[children.length + 1];
            for (int i = 0; i < newKeys.length; i++) {
                newKeys[i] = i == insertIndex ? value : keys[i - (i > insertIndex ? 1 : 0)];
                newValues[i] = i == insertIndex ? leftSplit : (i == insertIndex + 1 ? rightSplit : children[i - (i > insertIndex ? 1 : 0)]);
            }
            newValues[newValues.length - 1] = insertIndex == keys.length ? rightSplit : children[children.length - 1];
            parent.keys = newKeys;
            parent.children = newValues;
            if (newValues.length > maxChildren) {
                return split(tree, parent);
            }
            return null;
        }
    }

    public int[] getKeys() {
        return keys;
    }

    public MultiwaySearchTree[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "MultiwaySearchTree{" + "keys=" + Arrays.toString(keys) + '}';
    }
}
