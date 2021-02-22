package Graphs;

import java.util.Collection;

public class ConnectedComponentsIterator {

    public static int numberOfConnectedComponents(Graph g) {
        if (g == null) return 0;

        int c = 0;
        Collection<Vertex> unexplored =  g.getAllVertices();//get all vertices

        while(!unexplored.isEmpty()) {
            Vertex v = unexplored.iterator().next(); // get the next

            // Stops when all vertices explored in one part of graph
            new GraphIteratorDFS(g, v).forEachRemaining(unexplored::remove); // remove all that is connected to it!
            c++;
        }

        return c;

    }
}
