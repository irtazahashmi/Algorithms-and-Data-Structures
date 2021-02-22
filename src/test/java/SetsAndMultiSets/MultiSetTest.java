package SetsAndMultiSets;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class MultiSetTest {
    //INSERTION TESTS
    @Test
    public void testInsertEmpty() {
        MultiSet m = new MultiSet();
        m.insert(42);
        assertEquals(Collections.singletonList(42), m.getElements());
    }

    @Test
    public void testInsertMiddle() {
        MultiSet m = new MultiSet(Arrays.asList(1, 3));
        m.insert(2);
        assertEquals(Arrays.asList(1, 2, 3), m.getElements());
    }

    @Test
    public void testInsertEnd() {
        MultiSet m = new MultiSet(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8));
        m.insert(7);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 8, 8), m.getElements());
    }

    @Test
    public void testInsertHard() {
        MultiSet m = new MultiSet(Arrays.asList(1, 3));
        m.insert(5);
        assertEquals(Arrays.asList(1, 3, 5), m.getElements());
    }

    @Test
    public void testIntersectionEmpty() {
        assertEquals(Collections.emptyList(), new MultiSet().intersection(new MultiSet()).getElements());
    }

    @Test
    public void testIntersectionSimple() {
        assertEquals(Collections.singletonList(2), new MultiSet(Arrays.asList(1, 2)).intersection(new MultiSet(Arrays.asList(2, 3))).getElements());
    }

    @Test
    public void testIntersectionMultiple() {
        assertEquals(Arrays.asList(2, 3, 4, 4, 5), new MultiSet(Arrays.asList(2, 3, 4, 4, 5, 6)).intersection(new MultiSet(Arrays.asList(1, 2, 3, 4, 4, 5))).getElements());
    }


    //UNION TESTS

    @Test
    public void testCountEmpty() {
        assertEquals(0, new MultiSet().count(42));
    }

    @Test
    public void testCountSimple() {
        assertEquals(1, new MultiSet(Collections.singletonList(42)).count(42));
    }

    @Test
    public void testCountMultiple() {
        assertEquals(2, new MultiSet(Arrays.asList(1, 1, 2)).count(1));
    }

    @Test
    public void testUnionEmpty() {
        assertEquals(Collections.emptyList(), new MultiSet().union(new MultiSet()).getElements());
    }

    @Test
    public void testUnionSimple() {
        assertEquals(Arrays.asList(1, 2), new MultiSet(Collections.singletonList(1)).union(new MultiSet(Collections.singletonList(2))).getElements());
    }

    @Test
    public void testUnionMultiple() {
        assertEquals(Arrays.asList(1, 1, 2, 2), new MultiSet(Arrays.asList(1, 1, 2)).union(new MultiSet(Arrays.asList(1, 2, 2))).getElements());
    }

    @Test
    public void testUnionMultiple2() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 6, 7, 8), new MultiSet(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 6)).union(new MultiSet(Arrays.asList(6, 7, 8, 6))).getElements());
    }
}
//
