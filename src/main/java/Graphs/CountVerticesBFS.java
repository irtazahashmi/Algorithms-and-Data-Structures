package Graphs;

import java.util.*;

public class CountVerticesBFS {

    // count vertices in a graph in the SAME CONNECTED COMPONENT
    public static int countVertices(Graph g, Vertex v) {
       if (g==null || v == null) return 0;
       return count(g, v, new HashSet<>());
    }

    public static int count(Graph g, Vertex v, Set<Vertex> known) {
        Queue<Vertex> q = new LinkedList<>();
        known.add(v);
        q.add(v);
        int c = 1; //v

        while (!q.isEmpty()) {
            Vertex u = q.poll();
            for (Vertex vertex : g.getNeighbours(u)) {
                if (!known.contains(vertex)) {
                    known.add(vertex);
                    q.add(vertex);
                    c++;
                }
            }
        }
        return c;
    }
}
