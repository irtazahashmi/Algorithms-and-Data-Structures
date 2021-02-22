package Graphs;

import java.util.*;

public class CountVerticesDFS {

    // count vertices in a graph in the SAME CONNECTED COMPONENT
    public static int countVertices(Graph g, Vertex v) {
        if (g == null || v == null) return 0;
        return countVertices(g, v, new HashSet<>());
    }

    private static int countVertices(Graph g, Vertex v, Set<Vertex> known) {
        if (g == null || v == null) return 0;
        known.add(v);

        int count = 1;
        for (Vertex u : g.getNeighbours(v)) {
            if (!known.contains(u)) {
                count += countVertices(g, u, known);
            }
        }
        return count;
    }
}






