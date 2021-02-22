package Graphs;

import java.util.*;

//USED WITH WEIGHTS
public class UndirectedGraph {
    //ID, Vertex
    private Map<Integer, VertexUG> vertices = new HashMap<>();

    /**
     * Creates a new graph with n vertices.
     *
     * @param n Amount of vertices in the graph.
     */
    public UndirectedGraph(int n) {
        for (int i = 0; i < n; i++) vertices.put(i, new VertexUG(i));
    }

    /**
     * Returns the vertex with the given ID.
     *
     * @param id The ID for the vertex to get.
     * @return The vertex with the given ID.
     * @throws IllegalArgumentException if no vertex with the given ID is in the graph.
     */
    public VertexUG getVertex(int id) throws IllegalArgumentException {
        if (!vertices.containsKey(id)) throw new IllegalArgumentException("Vertex not in graph");
        return vertices.get(id);
    }

    public Collection<VertexUG> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    /**
     * Returns all neighbours of the given vertex sorted by their ID.
     *
     * @param v The vertex to get the neighbours from.
     * @return A sorted list of all neighbouring vertices.
     */
    public List<VertexNumPair> getNeighbours(VertexUG v) {
        List<VertexNumPair> neighbours = new ArrayList<>(v.getNeighbours());
        neighbours.sort(Comparator.comparingInt(a -> a.getVertex().getId()));
        return neighbours;
    }

    /**
     * Adds an edge between vertex u and v with the given weight.
     *
     * @param u First vertex.
     * @param v Second vertex.
     * @param weight Weight of the edge between a and b.
     */
    public void addEdge(VertexUG u, VertexUG v, int weight) {
        u.addNeighbour(v, weight);
        v.addNeighbour(u, weight);
    }
}


class VertexUG implements Comparable<Vertex> {

    private int id;
    private Set<VertexNumPair> neighbours;

    public VertexUG(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void addNeighbour(VertexUG v, int weight) {
        neighbours.add(new VertexNumPair(v, weight));
    }

    @Override
    public String toString() {
        return "<vertex: " + id + ">";
    }

    public Collection<VertexNumPair> getNeighbours() {
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



