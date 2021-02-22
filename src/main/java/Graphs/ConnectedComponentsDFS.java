package Graphs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConnectedComponentsDFS {

    // go through vertices and use dfs.
    // if the dfs returns and not all vertices are visited -> more than one connected component!
    public static int connectedComponents(Graph g) {
        Set<Vertex> known = new HashSet<>();
        Collection<Vertex> vertices = g.getAllVertices();
        int c = 0;
        for(Vertex v : vertices) {
            // Disjoint graph
            if (!known.contains(v)) {
                c++;
                depthFirst(g, v, known);
            }
        }
        return c;
    }

    // dfs
    public static void depthFirst(Graph g, Vertex v, Set<Vertex> known) {
        known.add(v);
        for (Vertex u : g.getNeighbours(v)) {
            if (!known.contains(u)) {
                depthFirst(g, u, known);
            }
        }
    }

    public static void main(String[] args) {
        //4
        GraphImpl graph = new GraphImpl();
        VertexImpl a = new VertexImpl(1);
        VertexImpl b = new VertexImpl(2);
        VertexImpl c = new VertexImpl(3);
        VertexImpl d = new VertexImpl(4);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        System.out.println(connectedComponents(graph));
    }
}
