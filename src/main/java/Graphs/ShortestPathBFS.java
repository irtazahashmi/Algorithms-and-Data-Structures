package Graphs;

import java.util.*;

public class ShortestPathBFS {

    // Returns the shortest path that uses the LEAST AMOUNT OF EDGES to get to a path

    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
        Map<Vertex, Vertex> pred = new HashMap<>();
        bfsGetPreds(g, v, new HashSet<>(), pred);

        List<Vertex> path = new ArrayList<>();
        while(u != v) {
            if (!pred.containsKey(u)) return new ArrayList<>();
            path.add(0, u); //addFirst
            u = pred.get(u);//getPred
        }

        path.add(0, v);//add start vertex
        return path;
    }

    public static void bfsGetPreds(Graph g, Vertex v, Set<Vertex> known, Map<Vertex, Vertex> pred) {
        Queue<Vertex> q = new LinkedList<>();
        known.add(v);
        q.add(v);

        while (!q.isEmpty()) {
            Vertex w = q.poll();
            for (Vertex neighbour : g.getNeighbours(w)) {
                if (!pred.containsKey(neighbour)) pred.put(neighbour, w);
                if (!known.contains(neighbour)) {
                    known.add(neighbour);
                    q.add(neighbour);
                }
            }
        }
    }
}
