import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SolutionTest {

    @Test
    public void testSingleVertexForbidden() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        Set<Vertex> forbidden = new HashSet<>();
        forbidden.add(v);
        List<Vertex> result = new ArrayList<>();
        Assert.assertEquals(result, Solution.toReadList(g, forbidden));
        // Point only awarded when the implementation also works for two vertices
        testDoubleVertexNoneForbidden();
    }

    @Test
    public void testSimpleCycle() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(0);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        g.addEdge(w, v);
        Set<Vertex> forbidden = new HashSet<>();
        List<Vertex> result = new ArrayList<>();
        Assert.assertEquals(result, Solution.toReadList(g, forbidden));
    }

    @Test
    public void testDoubleVertexNoneForbidden() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(w, v);
        Set<Vertex> forbidden = new HashSet<>();
        List<Vertex> result = new ArrayList<>();
        result.add(w);
        result.add(v);
        Assert.assertEquals(result, Solution.toReadList(g, forbidden));
    }

    @Test
    public void testDoubleVertexDepForbidden() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        Set<Vertex> forbidden = new HashSet<>();
        forbidden.add(v);
        List<Vertex> result = new ArrayList<>();
        Assert.assertEquals(result, Solution.toReadList(g, forbidden));
    }

    @Test
    public void testDoubleVertexLastForbidden() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        Set<Vertex> forbidden = new HashSet<>();
        forbidden.add(w);
        List<Vertex> result = new ArrayList<>();
        result.add(v);
        Assert.assertEquals(result, Solution.toReadList(g, forbidden));
    }


    @Test
    public void hs() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        Vertex x = new VertexImpl(2);
        Vertex y = new VertexImpl(3);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addVertex(y);
        g.addEdge(v, w);
        g.addEdge(x, y);
        Set<Vertex> forbidden = new HashSet<>();
        forbidden.add(v);
        forbidden.add(y);
        List<Vertex> result = new ArrayList<>();
        result.add(x);
        Assert.assertEquals(result, Solution.toReadList(g, forbidden));
    }

}