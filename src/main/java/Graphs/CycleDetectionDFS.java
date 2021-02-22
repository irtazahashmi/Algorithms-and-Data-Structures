package Graphs;

import java.util.HashSet;
import java.util.Set;

import java.util.*;

public class CycleDetectionDFS {

    //cycle detection in DIRECTED GRAPHS using DFS.
    // PAY ATTENTION TO ADDEDGE! (Should be one way)

    public static boolean hasCycle(Graph g) {
        Set<Vertex> visited = new HashSet<>();
        Set<Vertex> beingVisited = new HashSet<>();

        for (Vertex vertex : g.getAllVertices()) {
            if (!visited.contains(vertex) && hasCycle(g, vertex, visited, beingVisited)) {
                return true;
            }
        }
        return false;
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
        //Test1: true
        GraphImpl graph = new GraphImpl();
        VertexImpl a = new VertexImpl(1);
        VertexImpl b = new VertexImpl(2);
        VertexImpl c = new VertexImpl(3);
        VertexImpl d = new VertexImpl(4);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);

        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(c, a);
        graph.addEdge(d, c);
        System.out.println(hasCycle(graph));

        //test 2: false
//        GraphImpl graph = new GraphImpl();
//        VertexImpl a = new VertexImpl(1);
//        VertexImpl b = new VertexImpl(2);
//        VertexImpl c = new VertexImpl(3);
//        VertexImpl d = new VertexImpl(4);
//        graph.addVertex(a);
//        graph.addVertex(b);
//        graph.addVertex(c);
//        graph.addVertex(d);
//
//        graph.addEdge(a, b);
//        graph.addEdge(b, c);
//        graph.addEdge(a, c);
//        graph.addEdge(d, c);
//        System.out.println(hasCycle(graph));
    }
}
