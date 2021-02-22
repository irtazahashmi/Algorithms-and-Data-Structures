package Stack;

public class ArrayStack {
        public Object[] stack;
        public int size;

        /**
         * The constructor of the ArrayBasedStack.
         *
         * @param capacity
         *     Maximum number of items that can be stored in the stack.
         */
        public ArrayStack(int capacity) {
            if (capacity >= 1) {
                stack = new Object[capacity];
                size = 0;
            }
        }

        /**
         * Push an item to the stack.
         *
         * @param o
         *     Object that is pushed on the stack.
         * @return the object, iff the object has been pushed to stack successfully.
         * Returns null, if the object cannot be pushed to the stack.
         */
        public Object push(Object o) {
            if (size == stack.length) {
                return null;
            } else {
                size++;
                stack[size - 1] = o;
                return o;
            }
        }

        /**
         * Pops the first item from the stack.
         *
         * @return the object, iff the object has been popped from stack successfully. Null, if the stack is empty.
         */
        public Object pop() {
            if (size == 0) {
                return null;
            } else {
                Object r = stack[size - 1];
                stack[size - 1] = null;
                size--;
                return r;
            }
        }

        /**
         * Check the item on top of the stack, without removing it.
         *
         * @return the top object, iff the stack has an item. Null, if the stack is empty.
         */
        public Object peek() {
            if (size == 0) {
                return null;
            } else {
                return stack[size - 1];
            }
        }

}
