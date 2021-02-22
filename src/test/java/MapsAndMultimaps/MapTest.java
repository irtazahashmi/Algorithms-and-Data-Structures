//package Maps;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class MapTest {
//    public Map tinySet() {
//        Map m = new Map();
//        m.arr.add(new Entry("peach", 100));
//        return m;
//    }
//
//    @Test
//    public void testSimpleGet() {
//        Map m = new Map();
//        Entry e = new Entry("magic", 42);
//        m.arr.add(e);
//        assertEquals(42, m.get("magic"));
//    }
//
//    @Test
//    public void testUnionSimple() {
//        Map m1 = new Map();
//        Map m2 = new Map();
//        m1.arr.add(new Entry("apple", 42));
//        m2.arr.add(new Entry("orange", 24));
//        Map result = new Map();
//        result.arr.add(new Entry("apple", 42));
//        result.arr.add(new Entry("orange", 24));
//        assertEquals(result.arr, m1.union(m2).arr);
//    }
//
//    @Test
//    public void testUnionNull() {
//        Map m = tinySet();
//        assertEquals(tinySet().arr, m.union(null).arr);
//    }
//
//    @Test
//    public void testLeftBiasedUnion() {
//        Map m1 = new Map();
//        Map m2 = new Map();
//        m1.arr.add(new Entry("a", 1));
//        m1.arr.add(new Entry("b", 3));
//        m2.arr.add(new Entry("a", 42));
//        m2.arr.add(new Entry("c", 1337));
//        Map result = new Map();
//        result.arr.add(new Entry("a", 1));
//        result.arr.add(new Entry("b", 3));
//        result.arr.add(new Entry("c", 1337));
//        assertEquals(result.arr, m1.union(m2).arr);
//    }
//}