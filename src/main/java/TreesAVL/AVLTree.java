package TreesAVL;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class AVLTree {
    public class AVLTreeST<Key extends Comparable<Key>, Value> {
        private class Node {
            private final Key key;   // the key
            private Value val;       // the associated value
            private int height;      // height of the subtree
            private int size;        // number of nodes in subtree
            private Node left;       // left subtree
            private Node right;      // right subtree

            public Node(Key key, Value val, int height, int size) {
                this.key = key;
                this.val = val;
                this.size = size;
                this.height = height;
            }
        }


        private Node root;

        public AVLTreeST() {}

        public boolean isEmpty() {return root == null; }

        public int size() {return size(root);}
        private int size(Node root) {
            if (root == null) return 0;
            return root.size;
        }

        public int height() { return height(root); }
        private int height(Node root) {
            if (root == null) return -1;
            return root.height;
        }

        public Value get(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to get() is null");
            Node x = get(root, key);
            if (x == null) return null;
            return x.val;
        }

        // Binary Search to get the key
        private Node get(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return get(x.left, key);
            else if (cmp > 0) return get(x.right, key);
            else return x;
        }

        public boolean contains(Key key) { return get(key) != null;}

        /**
         * Inserts the specified key-value pair into the symbol table, overwriting
         * the old value with the new value if the symbol table already contains the
         * specified key. Deletes the specified key (and its associated value) from
         * this symbol table if the specified value is {@code null}.
         *
         * @param key the key
         * @param val the value
         * @throws IllegalArgumentException if {@code key} is {@code null}
         */
        public void put(Key key, Value val) {
            if (key == null) throw new IllegalArgumentException("first argument to put() is null");
            if (val == null) {
                delete(key);
                return;
            }
            root = put(root, key, val);
            assert check();
        }

        /**
         * Inserts the key-value pair in the subtree. It overrides the old value
         * with the new value if the symbol table already contains the specified key
         * and deletes the specified key (and its associated value) from this symbol
         * table if the specified value is {@code null}.
         *
         * @param x the subtree
         * @param key the key
         * @param val the value
         * @return the subtree
         */
        private Node put(Node x, Key key, Value val) {
            if (x == null) return new Node(key, val, 0, 1);
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x.left = put(x.left, key, val);
            else if (cmp > 0) x.right = put(x.right, key, val);
            else {
                x.val = val;
                return x;
            }
            x.size = 1 + size(x.left) + size(x.right);
            x.height = 1 + Math.max(height(x.left), height(x.right));
            return balance(x);
        }

        /**
         * Restores the AVL tree property of the subtree.
         *
         * @param x the subtree
         * @return the subtree with restored AVL property
         */
        private Node balance(Node x) {
            if (balanceFactor(x) < -1) {
                if (balanceFactor(x.right) > 0) {
                    x.right = rotateRight(x.right);
                }
                x = rotateLeft(x);
            }
            else if (balanceFactor(x) > 1) {
                if (balanceFactor(x.left) < 0) {
                    x.left = rotateLeft(x.left);
                }
                x = rotateRight(x);
            }
            return x;
        }

        private int balanceFactor(Node x) {
            return height(x.left) - height(x.right);
        }

        /**
         * Rotates the given subtree to the right.
         *
         * @param x the subtree
         * @return the right rotated subtree
         */
        private Node rotateRight(Node x) {
            Node y = x.left;
            x.left = y.right;
            y.right = x;

            y.size = x.size;
            x.size = 1 + size(x.left) + size(x.right);

            x.height = 1 + Math.max(height(x.left), height(x.right));
            y.height = 1 + Math.max(height(y.left), height(y.right));
            return y;
        }

        /**
         * Rotates the given subtree to the left.
         *
         * @param x the subtree
         * @return the left rotated subtree
         */
        private Node rotateLeft(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;

            y.size = x.size;
            x.size = 1 + size(x.left) + size(x.right);

            x.height = 1 + Math.max(height(x.left), height(x.right));
            y.height = 1 + Math.max(height(y.left), height(y.right));
            return y;
        }

        /**
         * Removes the specified key and its associated value from the symbol table
         * (if the key is in the symbol table).
         *
         * @param key the key
         * @throws IllegalArgumentException if {@code key} is {@code null}
         */
        public void delete(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to delete() is null");
            if (!contains(key)) return;
            root = delete(root, key);
            assert check();
        }

        /**
         * Removes the specified key and its associated value from the given
         * subtree.
         *
         * @param x the subtree
         * @param key the key
         * @return the updated subtree
         */
        private Node delete(Node x, Key key) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = delete(x.left, key);
            }
            else if (cmp > 0) {
                x.right = delete(x.right, key);
            }
            else {
                if (x.left == null) {
                    return x.right;
                }
                else if (x.right == null) {
                    return x.left;
                }
                else {
                    Node y = x;
                    x = min(y.right);
                    x.right = deleteMin(y.right);
                    x.left = y.left;
                }
            }
            x.size = 1 + size(x.left) + size(x.right);
            x.height = 1 + Math.max(height(x.left), height(x.right));
            return balance(x);
        }

        /**
         * Removes the smallest key and associated value from the symbol table.
         *
         * @throws NoSuchElementException if the symbol table is empty
         */
        public void deleteMin() {
            if (isEmpty()) throw new NoSuchElementException("called deleteMin() with empty symbol table");
            root = deleteMin(root);
            assert check();
        }

        /**
         * Removes the smallest key and associated value from the given subtree.
         *
         * @param x the subtree
         * @return the updated subtree
         */
        private Node deleteMin(Node x) {
            if (x.left == null) return x.right;
            x.left = deleteMin(x.left);
            x.size = 1 + size(x.left) + size(x.right);
            x.height = 1 + Math.max(height(x.left), height(x.right));
            return balance(x);
        }

        /**
         * Removes the largest key and associated value from the symbol table.
         *
         * @throws NoSuchElementException if the symbol table is empty
         */
        public void deleteMax() {
            if (isEmpty()) throw new NoSuchElementException("called deleteMax() with empty symbol table");
            root = deleteMax(root);
            assert check();
        }

        /**
         * Removes the largest key and associated value from the given subtree.
         *
         * @param x the subtree
         * @return the updated subtree
         */
        private Node deleteMax(Node x) {
            if (x.right == null) return x.left;
            x.right = deleteMax(x.right);
            x.size = 1 + size(x.left) + size(x.right);
            x.height = 1 + Math.max(height(x.left), height(x.right));
            return balance(x);
        }

        /**
         * Returns the smallest key in the symbol table.
         *
         * @return the smallest key in the symbol table
         * @throws NoSuchElementException if the symbol table is empty
         */
        public Key min() {
            if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
            return min(root).key;
        }

        /**
         * Returns the node with the smallest key in the subtree.
         *
         * @param x the subtree
         * @return the node with the smallest key in the subtree
         */
        private Node min(Node x) {
            if (x.left == null) return x;
            return min(x.left);
        }

        /**
         * Returns the largest key in the symbol table.
         *
         * @return the largest key in the symbol table
         * @throws NoSuchElementException if the symbol table is empty
         */
        public Key max() {
            if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
            return max(root).key;
        }

        /**
         * Returns the node with the largest key in the subtree.
         *
         * @param x the subtree
         * @return the node with the largest key in the subtree
         */
        private Node max(Node x) {
            if (x.right == null) return x;
            return max(x.right);
        }

        /**
         * Returns the largest key in the symbol table less than or equal to
         * {@code key}.
         *
         * @param key the key
         * @return the largest key in the symbol table less than or equal to
         *         {@code key}
         * @throws NoSuchElementException if the symbol table is empty
         * @throws IllegalArgumentException if {@code key} is {@code null}
         */
        public Key floor(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to floor() is null");
            if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
            Node x = floor(root, key);
            if (x == null) return null;
            else return x.key;
        }

        /**
         * Returns the node in the subtree with the largest key less than or equal
         * to the given key.
         *
         * @param x the subtree
         * @param key the key
         * @return the node in the subtree with the largest key less than or equal
         *         to the given key
         */
        private Node floor(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.left, key);
            Node y = floor(x.right, key);
            if (y != null) return y;
            else return x;
        }

        /**
         * Returns the smallest key in the symbol table greater than or equal to
         * {@code key}.
         *
         * @param key the key
         * @return the smallest key in the symbol table greater than or equal to
         *         {@code key}
         * @throws NoSuchElementException if the symbol table is empty
         * @throws IllegalArgumentException if {@code key} is {@code null}
         */
        public Key ceiling(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
            if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
            Node x = ceiling(root, key);
            if (x == null) return null;
            else return x.key;
        }

        /**
         * Returns the node in the subtree with the smallest key greater than or
         * equal to the given key.
         *
         * @param x the subtree
         * @param key the key
         * @return the node in the subtree with the smallest key greater than or
         *         equal to the given key
         */
        private Node ceiling(Node x, Key key) {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp > 0) return ceiling(x.right, key);
            Node y = ceiling(x.left, key);
            if (y != null) return y;
            else return x;
        }

        /**
         * Returns the kth smallest key in the symbol table.
         *
         * @param k the order statistic
         * @return the kth smallest key in the symbol table
         * @throws IllegalArgumentException unless {@code k} is between 0 and
         *             {@code size() -1 }
         */
        public Key select(int k) {
            if (k < 0 || k >= size()) throw new IllegalArgumentException("k is not in range 0-" + (size() - 1));
            Node x = select(root, k);
            return x.key;
        }

        /**
         * Returns the node with key the kth smallest key in the subtree.
         *
         * @param x the subtree
         * @param k the kth smallest key in the subtree
         * @return the node with key the kth smallest key in the subtree
         */
        private Node select(Node x, int k) {
            if (x == null) return null;
            int t = size(x.left);
            if (t > k) return select(x.left, k);
            else if (t < k) return select(x.right, k - t - 1);
            else return x;
        }

        /**
         * Returns the number of keys in the symbol table strictly less than
         * {@code key}.
         *
         * @param key the key
         * @return the number of keys in the symbol table strictly less than
         *         {@code key}
         * @throws IllegalArgumentException if {@code key} is {@code null}
         */
        public int rank(Key key) {
            if (key == null) throw new IllegalArgumentException("argument to rank() is null");
            return rank(key, root);
        }

        /**
         * Returns the number of keys in the subtree less than key.
         *
         * @param key the key
         * @param x the subtree
         * @return the number of keys in the subtree less than key
         */
        private int rank(Key key, Node x) {
            if (x == null) return 0;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return rank(key, x.left);
            else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
            else return size(x.left);
        }

        /**
         * Returns all keys in the symbol table.
         *
         * @return all keys in the symbol table
         */
        public Iterable<Key> keys() {
            return keysInOrder();
        }

        /**
         * Returns all keys in the symbol table following an in-order traversal.
         *
         * @return all keys in the symbol table following an in-order traversal
         */
        public Iterable<Key> keysInOrder() {
            Queue<Key> queue = new LinkedList<>();
            keysInOrder(root, queue);
            return queue;
        }

        /**
         * Adds the keys in the subtree to queue following an in-order traversal.
         *
         * @param x the subtree
         * @param queue the queue
         */
        private void keysInOrder(Node x, Queue<Key> queue) {
            if (x == null) return;
            keysInOrder(x.left, queue);
            queue.add(x.key);
            keysInOrder(x.right, queue);
        }

        /**
         * Returns all keys in the symbol table following a level-order traversal.
         *
         * @return all keys in the symbol table following a level-order traversal.
         */
        public Iterable<Key> keysLevelOrder() {
            Queue<Key> queue = new LinkedList<>();
            if (!isEmpty()) {
                Queue<Node> queue2 = new LinkedList<>();
                queue2.add(root);
                while (!queue2.isEmpty()) {
                    Node x = queue2.poll();
                    queue.add(x.key);
                    if (x.left != null) {
                        queue2.add(x.left);
                    }
                    if (x.right != null) {
                        queue2.add(x.right);
                    }
                }
            }
            return queue;
        }

        /**
         * Returns all keys in the symbol table in the given range.
         *
         * @param lo the lowest key
         * @param hi the highest key
         * @return all keys in the symbol table between {@code lo} (inclusive)
         *         and {@code hi} (exclusive)
         * @throws IllegalArgumentException if either {@code lo} or {@code hi}
         *             is {@code null}
         */
        public Iterable<Key> keys(Key lo, Key hi) {
            if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
            if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
            Queue<Key> queue = new LinkedList<>();
            keys(root, queue, lo, hi);
            return queue;
        }

        /**
         * Adds the keys between {@code lo} and {@code hi} in the subtree
         * to the {@code queue}.
         *
         * @param x the subtree
         * @param queue the queue
         * @param lo the lowest key
         * @param hi the highest key
         */
        private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
            if (x == null) return;
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if (cmplo < 0) keys(x.left, queue, lo, hi);
            if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
            if (cmphi > 0) keys(x.right, queue, lo, hi);
        }

        /**
         * Returns the number of keys in the symbol table in the given range.
         *
         * @param lo minimum endpoint
         * @param hi maximum endpoint
         * @return the number of keys in the symbol table between {@code lo}
         *         (inclusive) and {@code hi} (exclusive)
         * @throws IllegalArgumentException if either {@code lo} or {@code hi}
         *             is {@code null}
         */
        public int size(Key lo, Key hi) {
            if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
            if (hi == null) throw new IllegalArgumentException("second argument to size() is null");
            if (lo.compareTo(hi) > 0) return 0;
            if (contains(hi)) return rank(hi) - rank(lo) + 1;
            else return rank(hi) - rank(lo);
        }

        /**
         * Checks if the AVL tree invariants are fine.
         *
         * @return {@code true} if the AVL tree invariants are fine
         */
        private boolean check() {
            if (!isBST()) return false;
            if (!isAVL()) return false;
            if (!isSizeConsistent()) return false;
            if (!isRankConsistent()) return false;
            return isBST() && isAVL() && isSizeConsistent() && isRankConsistent();
        }

        /**
         * Checks if AVL property is consistent.
         *
         * @return {@code true} if AVL property is consistent.
         */
        private boolean isAVL() {
            return isAVL(root);
        }

        /**
         * Checks if AVL property is consistent in the subtree.
         *
         * @param x the subtree
         * @return {@code true} if AVL property is consistent in the subtree
         */
        private boolean isAVL(Node x) {
            if (x == null) return true;
            int bf = balanceFactor(x);
            if (bf > 1 || bf < -1) return false;
            return isAVL(x.left) && isAVL(x.right);
        }

        /**
         * Checks if the symmetric order is consistent.
         *
         * @return {@code true} if the symmetric order is consistent
         */
        private boolean isBST() {
            return isBST(root, null, null);
        }

        /**
         * Checks if the tree rooted at x is a BST with all keys strictly between
         * min and max (if min or max is null, treat as empty constraint) Credit:
         * Bob Dondero's elegant solution
         *
         * @param x the subtree
         * @param min the minimum key in subtree
         * @param max the maximum key in subtree
         * @return {@code true} if if the symmetric order is consistent
         */
        private boolean isBST(Node x, Key min, Key max) {
            if (x == null) return true;
            if (min != null && x.key.compareTo(min) <= 0) return false;
            if (max != null && x.key.compareTo(max) >= 0) return false;
            return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
        }

        /**
         * Checks if size is consistent.
         *
         * @return {@code true} if size is consistent
         */
        private boolean isSizeConsistent() {
            return isSizeConsistent(root);
        }

        /**
         * Checks if the size of the subtree is consistent.
         *
         * @return {@code true} if the size of the subtree is consistent
         */
        private boolean isSizeConsistent(Node x) {
            if (x == null) return true;
            if (x.size != size(x.left) + size(x.right) + 1) return false;
            return isSizeConsistent(x.left) && isSizeConsistent(x.right);
        }

        /**
         * Checks if rank is consistent.
         *
         * @return {@code true} if rank is consistent
         */
        private boolean isRankConsistent() {
            for (int i = 0; i < size(); i++)
                if (i != rank(select(i))) return false;
            for (Key key : keys())
                if (key.compareTo(select(rank(key))) != 0) return false;
            return true;
        }
    }
}
