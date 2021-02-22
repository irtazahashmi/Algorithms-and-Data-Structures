package Graphs;

import java.util.*;

interface Vertex extends Comparable<Vertex> {
    int getId();
}

/**
 * Interface for a generic graph. You may assume that our implementation is an
 * UNDIRECTED GRAPH.
 */
interface Graph {
    /**
     * Returns the neighbours in a sorted collection by id
     *
     * @param v
     *     node to get the neighbours of.
     * @return sorted collection of neighbours.
     */
    List<Vertex> getNeighbours(Vertex v);

    /**
     * @return an unsorted collection of all vertices in the graph.
     */
    Collection<Vertex> getAllVertices();
}


class GraphImpl implements Graph {
    // <ID, Vertex>
    private Map<Integer, Vertex> vertices;

    public GraphImpl() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.put(v.getId(), v);
    }

    @Override
    public Collection<Vertex> getAllVertices() {
        return this.vertices.values();
    }

    @Override
    public List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> neigh = new ArrayList<>(((VertexImpl) v).getNeighbours());
        Collections.sort(neigh);
        return neigh;
    }

    public void addEdge(Vertex v, Vertex w) {
        VertexImpl realV = (VertexImpl) v;
        VertexImpl realW = (VertexImpl) w;
        realV.addNeighbour(w);
        realW.addNeighbour(v);
    }
}

class VertexImpl implements Vertex {
    private int id;
    private Set<Vertex> neighbours;

    public VertexImpl(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<Node: " + id + ">";
    }

    @Override
    public int getId() {
        return id;
    }

    public Collection<Vertex> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public int compareTo(Vertex o) {
        return this.getId() - o.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex && ((Vertex) o).getId() == this.getId();
    }
}




