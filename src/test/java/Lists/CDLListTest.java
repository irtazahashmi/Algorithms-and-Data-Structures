package Lists;

import Lists.CDLList;
import org.junit.Test;

import static org.junit.Assert.*;

public class CDLListTest {

    @Test(timeout = 100)
    public void testConstructor() {
        CDLList<String> list = new CDLList<>();
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }


    @Test(timeout = 100)
    public void testAddOneElement() {
        CDLList<String> list = new CDLList<>();
        list.addFirst("Hello World");
        assertEquals("Hello World", list.getFirst());
        assertEquals("Hello World", list.getLast());
        assertEquals("Hello World", list.removeLast());
        assertNull(list.removeFirst());
    }

    @Test(timeout = 100)
    public void testAddTwoElement() {
        CDLList<String> list = new CDLList<>();
        list.addFirst("World");
        list.addFirst("Hello");
        assertEquals("Hello", list.getFirst());
        assertEquals("World", list.getLast());
    }

    @Test(timeout = 100)
    public void removeElement() {
        CDLList<String> list = new CDLList<>();
        list.addFirst("World");
        list.addFirst("Hello");
        assertEquals("Hello", list.removeFirst());
        assertEquals("World", list.removeFirst());
        assertNull(list.removeFirst());
    }

    @Test(timeout = 100)
    public void addLastElement() {
        CDLList<String> list = new CDLList<>();
        list.addFirst("Hello");
        list.addLast("World");
        list.addLast("Hehe");
        assertEquals("Hello", list.removeFirst());
        assertEquals("World", list.removeFirst());
        assertEquals("Hehe", list.removeFirst());
        assertNull(list.removeFirst());
    }

    @Test(timeout = 100)
    public void removeLastElement() {
        CDLList<String> list = new CDLList<>();
        list.addFirst("Hello");
        list.addLast("World");
        list.addLast("Hehe");
        assertEquals("Hehe", list.removeLast());
        assertEquals("World", list.removeLast());
        assertEquals("Hello", list.removeLast());
        assertNull(list.removeFirst());
    }


    @Test(timeout = 100)
    public void testRotateForward() {
        CDLList<String> list = new CDLList<>();
        list.addLast("Duck");
        list.addLast("Duck");
        list.addLast("Duck");
        list.addLast("Goose");
        assertEquals("Duck", list.getFirst());
        list.rotateForward();
        assertEquals("Duck", list.getFirst());
        list.rotateForward();
        assertEquals("Duck", list.getFirst());
        list.rotateForward();
        assertEquals("Goose", list.getFirst());
        list.rotateForward();
        assertEquals("Duck", list.getFirst());
    }
}