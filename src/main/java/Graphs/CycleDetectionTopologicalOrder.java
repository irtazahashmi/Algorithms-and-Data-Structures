package Graphs;

import java.util.*;

public class CycleDetectionTopologicalOrder {

    // cycle detection in nodes using topological ordering

    public static boolean detectCycle(List<Node> nodes) {
        int[] inDegree = new int[nodes.size()];
        Arrays.fill(inDegree, 0);

        for(Node node : nodes) {
            for(Node neighbour : node.getOutgoingEdges()){
                inDegree[neighbour.getId()]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length;i++){
            if (inDegree[i] == 0) q.add(i);
        }

        int visitedVertices = 0;
        ArrayList<Integer> ordering = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            ordering.add(u);
            for(Node neighbour : nodes.get(u).getOutgoingEdges()){
                if (--inDegree[neighbour.getId()] == 0) q.add(neighbour.getId());
            }
            visitedVertices++;
        }

        if (visitedVertices != nodes.size()) return true;
        else return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        n1.outgoingEdges.add(n2);
        n2.outgoingEdges.add(n1);
        List<Node> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n2);
        System.out.println(detectCycle(nodes));
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
