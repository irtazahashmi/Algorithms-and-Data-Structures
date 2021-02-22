package Graphs;

import java.util.*;

public class DFSBFS {

    public static void depthFirst(GraphImpl g, Vertex v, Set<Vertex> known) {
        known.add(v);
        System.out.println(v.getId());
        for (Vertex u : g.getNeighbours(v)) {
            if (!known.contains(u)) {
                depthFirst(g, u, known);
            }
        }
    }

    public static void breadthFirst(Graph g, Vertex v, Set<Vertex> known) {
        Queue<Vertex> q = new LinkedList<>();
        known.add(v);
        q.add(v);
        while (!q.isEmpty()) {
            Vertex v1 = q.poll();
            System.out.println(v1.getId());
            for (Vertex u : g.getNeighbours(v1)) {
                if (!known.contains(u)) {
                    known.add(u);
                    q.add(u);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl();
        VertexImpl a = new VertexImpl(1);
        VertexImpl b = new VertexImpl(2);
        VertexImpl c = new VertexImpl(3);
        VertexImpl d = new VertexImpl(4);
        VertexImpl e = new VertexImpl(5);
        VertexImpl f = new VertexImpl(6);
        VertexImpl g = new VertexImpl(7);
        VertexImpl h = new VertexImpl(8);
        VertexImpl i = new VertexImpl(9);
        VertexImpl j = new VertexImpl(10);
        VertexImpl k = new VertexImpl(11);
        VertexImpl l = new VertexImpl(12);
        VertexImpl m = new VertexImpl(13);
        VertexImpl n = new VertexImpl(14);
        VertexImpl o = new VertexImpl(15);
        VertexImpl p = new VertexImpl(16);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addVertex(h);
        graph.addVertex(i);
        graph.addVertex(j);
        graph.addVertex(k);
        graph.addVertex(l);
        graph.addVertex(m);
        graph.addVertex(n);
        graph.addVertex(o);
        graph.addVertex(p);
        graph.addEdge(a, b);
        graph.addEdge(a, e);
        graph.addEdge(a, f);
        graph.addEdge(b, c);
        graph.addEdge(b, f);
        graph.addEdge(c, d);
        graph.addEdge(d, g);
        graph.addEdge(d, h);
        graph.addEdge(g, j);
        graph.addEdge(j, i);
        graph.addEdge(e, i);
        graph.addEdge(g, l);
        graph.addEdge(h, l);
        graph.addEdge(l, p);
        graph.addEdge(i, m);
        graph.addEdge(i, n);
        graph.addEdge(m, n);
        graph.addEdge(n, k);
        graph.addEdge(k,o);
        GraphIteratorDFS iteratorDFS = new GraphIteratorDFS(graph, a);
        while (iteratorDFS.hasNext()) {
            System.out.println(iteratorDFS.next().getId());
        }
    }
}
