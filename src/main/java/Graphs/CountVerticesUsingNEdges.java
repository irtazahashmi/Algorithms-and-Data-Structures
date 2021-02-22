package Graphs;
import java.util.*;

public class CountVerticesUsingNEdges {

    //The number of vertices that are reachable from v (including v), using at MOST n edges.
    static int countVertices(Graph g, Vertex v, int n) {
        if (g == null || v == null) return 0;

        Set<Vertex> colored = new HashSet<>();
        Queue<Vertex> q = new LinkedList<>();
        colored.add(v);
        q.add(v);

        int c = 1;
        int edgesUsed = 0;

        while(edgesUsed < n) {

            Queue<Vertex> temp = new LinkedList<>();

            while(!q.isEmpty()) {
                Vertex u = q.remove();
                for (Vertex w : g.getNeighbours(u)) {
                    if (!colored.contains(w)) {
                        colored.add(w);
                        temp.add(w);
                        c++;
                    }
                }
            }

            q = temp; //wanna go as far as possible. Continue from the vertex that was explored.
            edgesUsed++;
        }

        return c;
    }
}
