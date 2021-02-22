package Graphs;

import java.util.*;

public class TopologicalSortingNeverInclude {

    public static List<VertexDG> topologicalSort(DirectedGraph g, Set<Vertex> never_read) {
        List<VertexDG> result = new ArrayList<>();
        Map<VertexDG, Integer> counter = new HashMap<>();
        Queue<VertexDG> q = new LinkedList<>();

        for (VertexDG v : g.getAllVertices()) {
            int numNeighs = g.getIncomingNeighbours(v).size(); //edges
            counter.put(v, numNeighs);
            if (numNeighs == 0) q.add(v); // no preqs, add to q
        }

        while (!q.isEmpty()) {
            VertexDG cur = q.poll();
            if (never_read.contains(cur)) continue;
            result.add(cur);
            for (VertexDG neigh : g.getOutgoingNeighbours(cur)) {
                counter.put(neigh, counter.get(neigh) - 1);
                if (counter.get(neigh) == 0) q.add(neigh);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        VertexDG a = new VertexDG(1);
        VertexDG b = new VertexDG(2);
        VertexDG c = new VertexDG(3);
        VertexDG d = new VertexDG(4);
        VertexDG e = new VertexDG(5);
        VertexDG f = new VertexDG(6);
        VertexDG g = new VertexDG(8);
        VertexDG h = new VertexDG(11);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addVertex(h);
        graph.addEdge(e, f);
        graph.addEdge(f, c);
        graph.addEdge(b, d);
        graph.addEdge(a, c);
        graph.addEdge(a, b);
        graph.addEdge(c, g);
        graph.addEdge(c, d);
        graph.addEdge(g, h);
        System.out.println(topologicalSort(graph, new HashSet<>()));
    }
}
