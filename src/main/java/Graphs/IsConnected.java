package Graphs;

public class IsConnected {

    public static boolean isConnected(Graph g) {
        return ConnectedComponentsDFS.connectedComponents(g) == 1;
    }

    public static void main(String[] args) {
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
        graph.addEdge(c, d);
        graph.addEdge(d, a);
        System.out.println(isConnected(graph));
    }
}
