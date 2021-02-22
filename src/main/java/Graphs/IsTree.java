package Graphs;

public class IsTree {

    public static boolean graphIsTree(Graph g) {
        return IsConnected.isConnected(g) && !CycleDetectionDFS.hasCycle(g);
    }
}
