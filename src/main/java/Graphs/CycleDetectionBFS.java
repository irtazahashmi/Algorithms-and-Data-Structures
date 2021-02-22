package Graphs;

import java.util.*;

public class CycleDetectionBFS {


    public static boolean detectCycle(Node s, List<Node> nodes) {
        if (s == null) return false;
        if (nodes.size() == 0 || nodes == null) return false;

        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited.contains(n)) return true;
            visited.add(n);
            for (Node neighbor : n.getOutgoingEdges()) {
                if (!visited.contains(neighbor)) q.add(neighbor);
            }
        }

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
