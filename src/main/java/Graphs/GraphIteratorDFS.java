package Graphs;

import java.util.*;

/**
 * Implements a DEPTH FIRST SEARCH of the Graph, STARTING at contructor vertex v. It
 * should return nodes at most once. If there is a choice between MULTIPLE next nodes,
 * always pick the LOWERST id node.
 */
class GraphIteratorDFS implements Iterator<Vertex> {
    private Graph g;
    private Stack<Vertex> stack = new Stack<>();
    private Set<Vertex> colored = new TreeSet<>();
    private int graphSize;

    public GraphIteratorDFS(Graph g, Vertex v) {
        this.g = g;
        this.graphSize = g.getAllVertices().size();
        stack.add(v);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() && colored.size() != graphSize;
    }

    @Override
    public Vertex next() {
        if (!hasNext()) return null;

        Vertex next = stack.pop();
        colored.add(next);

        // highest id first because adding to stack! 3->4->5
        List<Vertex> n = g.getNeighbours(next);
        Collections.sort(n);
        Collections.reverse(n);

        for (Vertex vert : n) {
            if (!colored.contains(vert)) stack.add(vert);
        }

        return next;

    }
}