package Graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphToEdgeList {

    public static List<Node> getList(Graph g){
        ArrayList<Node> graph = new ArrayList<>();
        for(int i = 0; i < g.getAllVertices().size(); i++) graph.add(new Node());

        //bfs
        for(Vertex vertex : g.getAllVertices()) {
            for(Vertex n: g.getNeighbours(vertex)) {
//                graph.get(vertex.getId()).neighbours.add(new Edge(vertex.getId(), n.getId(), n.getCost()));
            }
        }

        return graph;
    }



    static class Edge implements Comparable<MSTPrim.Edge>{
        int to;
        int cost;

        public Edge(int t, int c) {
            to = t;
            cost = c;
        }

        public int compareTo(MSTPrim.Edge e) {
            return this.cost - e.cost;
        }
    }

    static class Node {
        ArrayList<MSTPrim.Edge> neighbours;

        public Node() {
            neighbours = new ArrayList<>();
        }
    }

}
