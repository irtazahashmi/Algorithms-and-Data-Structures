package Graphs;

import java.util.*;

public class ConnectedComponentsBFS {

    public static int numberOfConnectedComponents(Graph g) {
        if (g == null) return 0;

        Set<Vertex> known = new HashSet<>();
        Collection<Vertex> vertices = g.getAllVertices();
        int connectedComponents = 0;
        for(Vertex v :vertices) {
            if (!known.contains(v)) {
                bfs(g, v, known);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }


    public static void bfs(Graph g, Vertex v, Set<Vertex> known) {
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
}
