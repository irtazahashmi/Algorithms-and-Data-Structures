package Stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackDynamicTest {
    @Test
    public void testConstructor() {
        ArrayStackDynamic tmp = new ArrayStackDynamic();
        assertArrayEquals(tmp.getElements(), new Object[1]);
    }

    @Test
    public void testToStringTwo() {
        ArrayStackDynamic s = new ArrayStackDynamic();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
    }

    @Test
    public void testGrowShrink() {
        ArrayStackDynamic s = new ArrayStackDynamic();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
        s.push(3);
        assertEquals(4, s.getElements().length);
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s.toString());
        assertEquals(2, s.getElements().length);
    }
}