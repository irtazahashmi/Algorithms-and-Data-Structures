package Graphs;

import java.util.*;

public class MSTPrimGraph {

    // Prim algo given a graph

    public static Graph primJarnik(Graph g) {
        if (g==null) return null;
        if (g.getAllVertices().size() == 1) return g;

        ArrayList<Node> graph = new ArrayList<>();
        for(int i = 0; i < g.getAllVertices().size(); i++) graph.add(new Node());

        //bfs
        for(Vertex vertex : g.getAllVertices()) {
            for(Vertex n: g.getNeighbours(vertex)) {
//                graph.get(vertex.getId()).neighbours.add(new Edge(vertex.getId(), n.getVertex().getId(), n.getNum()));
            }
        }

        boolean visited[] = new boolean[g.getAllVertices().size()];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[0] = true;

//        Graph mst = new Graph(g.getAllVertices().size());

        //add all neighbours of start into the queue
        for(Edge e: graph.get(0).neighbours) pq.add(e);

        //dfs. keep adding the min edge without cycle
        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            if (visited[e.to]) continue;
            visited[e.to] = true;
//            mst.addEdge(e.from, e.to, e.cost);
            for (Edge neig : graph.get(e.to).neighbours) {
                pq.add(neig);
            }
        }

//        return mst;
        return null;
    }


    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int t, int c) {
            to = t;
            cost = c;
        }

        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static class Node {
        ArrayList<Edge> neighbours;

        public Node() {
            neighbours = new ArrayList<>();
        }
    }
}
