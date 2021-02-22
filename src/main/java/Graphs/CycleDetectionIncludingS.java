package Graphs;

import java.util.*;

public class CycleDetectionIncludingS {

    // exists a cycle reachable from node 𝑠 in the provided graph

    public static boolean detectCycle(Node s, List<Node> nodes) {
        Set<Node> visited = new HashSet<>();
        Set<Node> beingVisited = new HashSet<>();

        for (Node node : s.getOutgoingEdges()) {
            if (!visited.contains(node) && hasCycle(node, visited, beingVisited)) return true;
        }

        return false;
    }

    public static boolean hasCycle(Node sourceVertex, Set<Node> visited, Set<Node> beingVisited) {
        beingVisited.add(sourceVertex);

        for (Node neighbor : sourceVertex.getOutgoingEdges()) {
            // there is an backward edge!
            if (beingVisited.contains(neighbor)) return true;
            else if (!visited.contains(neighbor) && hasCycle(neighbor, visited, beingVisited)) return true;

        }

        beingVisited.remove(sourceVertex);
        visited.add(sourceVertex);
        return false;
    }


    static class Node {
        int id;
        List<Node> outgoingEdges;

        public Node(int id) {
            this.outgoingEdges = new ArrayList<>();
            this.id = id;
        }

        public List<Node> getOutgoingEdges() {
            return outgoingEdges;
        }
        public int getId() { return id; }
        public String toString() {
            return Integer.toString(id);
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
