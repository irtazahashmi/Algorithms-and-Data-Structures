package Graphs;

import java.util.*;

public class ShortestPathBFSIterator {

    // Returns the shortest path that uses the LEAST AMOUNT OF EDGES to get to a path
    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
        Map<Vertex, Vertex> pred = new HashMap<>();

        // add all preds into the map
        new GraphIteratorBFS(g, v).forEachRemaining(w -> {
            for(Vertex neighbour : g.getNeighbours(w)){
                if (!pred.containsKey(neighbour)) pred.put(neighbour, w);
            }
        });

        List<Vertex> path = new ArrayList<>();

        while(u != v) {
            // has no pred, no path!
            if (!pred.containsKey(u)) return new ArrayList();
            path.add(0, u); //addFirst
            u = pred.get(u);//getPred
        }

        path.add(0, v);//add start vertex
        return path;
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
        System.out.println(shortestPath(graph, a, g));
    }
}
