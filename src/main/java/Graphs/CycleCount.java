package Graphs;

import java.util.*;

public class CycleCount {

    public static int countCyles(Graph g) {
        Set<Vertex> visited = new HashSet<>();
        Set<Vertex> beingVisited = new HashSet<>();
        int count = 0;

        for (Vertex vertex : g.getAllVertices()) {
            if (!visited.contains(vertex) && hasCycle(g, vertex, visited, beingVisited))
                count++;
        }

        return count;
    }


    public static boolean hasCycle(Graph g, Vertex sourceVertex, Set<Vertex> visited, Set<Vertex> beingVisited) {
        beingVisited.add(sourceVertex);

        for (Vertex neighbor : g.getNeighbours(sourceVertex)) {
            // there is an backward edge!
            if (beingVisited.contains(neighbor)) return true;
            else if (!visited.contains(neighbor) && hasCycle(g, neighbor, visited, beingVisited)) return true;
        }

        beingVisited.remove(sourceVertex);
        visited.add(sourceVertex);
        return false;
    }

    public static void main(String[] args) {
        //4 cycles -> Directed graph
        GraphImpl graph = new GraphImpl();
        VertexImpl one = new VertexImpl(0);
        VertexImpl two = new VertexImpl(1);
        VertexImpl three = new VertexImpl(2);
        VertexImpl four = new VertexImpl(3);
        VertexImpl five = new VertexImpl(4);

        graph.addVertex(one);
        graph.addVertex(two);
        graph.addVertex(three);
        graph.addVertex(four);
        graph.addVertex(five);

        graph.addEdge(one, two);
        graph.addEdge(two, three);
        graph.addEdge(three, four);
        graph.addEdge(four, one);
        graph.addEdge(two, five);

        System.out.println(countCyles(graph));
    }
}
