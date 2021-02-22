package Lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class DLListTest {
    @Test
    public void testDLListConstructor() {
        DLList list = new DLList();
        assertEquals(0, list.size());
    }

    //add firsst
    @Test
    public void testOneElement() {
        DLList list = new DLList();
        list.addFirst(42);
        assertEquals(42, list.getHead());
        assertEquals(42, list.getTail());
    }

    @Test
    public void testTwoElement() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24);
        list.addFirst(10);
        assertEquals(10, list.getHead());
        assertEquals(42, list.getTail());
    }
    // // //
// //   // //REMOVEFIRST
// //
    @Test
    public void testZeroElement() {
        DLList list = new DLList();
        assertNull(list.removeFirst());
    }

    @Test
    public void testOneRemoveElement() {
        DLList list = new DLList();
        list.addFirst(24);
        assertEquals(24, list.removeFirst());
    }

    @Test
    public void testTwoREmoveElement() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24);
        assertEquals(24, list.removeFirst());
        assertEquals(42, list.removeFirst());
        assertNull(list.removeFirst());
    }

    // // // // // // //   //ADDLAST
// // // // // //
    @Test
    public void testOneADDElement() {
        DLList list = new DLList();
        list.addLast(24);
        assertEquals(24, list.getHead());
        assertEquals(24, list.getTail());
        assertEquals(24, list.removeFirst());
    }

    @Test
    public void testTwoADDElement() {
        DLList list = new DLList();
        list.addLast(24);
        list.addLast(42);
        assertEquals(24, list.removeFirst());
        assertEquals(42, list.removeFirst());
    }
    // // // // // // // //
// // // // // // // //     //REMOVELAST
// // // // // //
    @Test
    public void testZeroREMOVEElement() {
        DLList list = new DLList();
        assertNull(list.removeLast());
    }

    @Test
    public void testOneREMOVEElement() {
        DLList list = new DLList();
        list.addFirst(24);
        assertEquals(24, list.removeLast());
        assertNull(list.removeLast());
    }

    @Test
    public void testTwoRWOMCEElement() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24);
        assertEquals(42, list.removeLast());
        assertEquals(24, list.removeLast());
        assertNull(list.removeLast());
    }
    // // // // // // // //
// // // // //   //SIZE TEST
    @Test
    public void zero() {
        DLList list = new DLList();
        assertEquals(0, list.size());
    }

    @Test
    public void one() {
        DLList list = new DLList();
        list.addFirst(24);
        assertEquals(1, list.size());
    }

    @Test
    public void two() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24);
        assertEquals(2, list.size());
    }

    @Test
    public void three() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24);
        list.addLast(53);
        assertEquals(3, list.size());
    }

    // // // //
    @Test
    public void testAddAtPosition0() {
        DLList list = new DLList();
        list.addAtPosition(0, 5);
        assertEquals(5, list.removeFirst());
        assertNull(list.removeFirst());
    }

    @Test
    public void testAddAtPositionLast() {
        DLList list = new DLList();
        list.addAtPosition(4, 5);
        assertEquals(5, list.removeFirst());
        assertNull(list.removeFirst());
    }

    @Test
    public void testAddAtPosition() {
        DLList list = new DLList();
        list.addFirst(3); //3, 2
        list.addLast(2);
        list.addAtPosition(1, 5);
        assertEquals(3, list.size()); // 3, 5, 2
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(2, list.removeFirst());
    }

    // // // // //   //Remove from pos
// // // //
    @Test
    public void r31() {
        DLList list = new DLList();
        list.addFirst(23);
        assertEquals(23, list.removeFromPosition(0));
    }

    @Test
    public void r2() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24);
        assertEquals(24, list.removeFromPosition(0));
        assertEquals(42, list.removeFromPosition(0));
    }

    @Test
    public void r3() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24);
        assertEquals(42, list.removeFromPosition(1));
    }

    @Test
    public void r42() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24);
        list.addFirst(13);
        assertEquals(24, list.removeFromPosition(1));
    }

    @Test
    public void reverse() {
        DLList list = new DLList();
        list.addFirst(42);
        list.addFirst(24); //13, 24. 42
        list.addFirst(13);
        DLList res = list.reverse();
        assertEquals(res.removeFirst(), 42);
        assertEquals(res.removeFirst(), 24);
        assertEquals(res.removeFirst(), 13);
        assertNull(res.removeFirst());
    }


}