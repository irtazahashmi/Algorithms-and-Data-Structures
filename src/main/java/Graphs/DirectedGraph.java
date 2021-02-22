package Graphs;

import java.util.*;

// Has outgoingEdges and incomingEdges
public class DirectedGraph implements DirectedGraphInterface {

    //ID, Vertex
    private Map<Integer, VertexDG> vertices;
    public DirectedGraph() {
        this.vertices = new HashMap<>();
    }
    public void addVertex(VertexDG v) {
        this.vertices.put(v.getId(), v);
    }

    @Override
    public Collection<VertexDG> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    @Override
    public List<VertexDG> getOutgoingNeighbours(VertexDG v) {
        List<VertexDG> neigh = new ArrayList<>(((VertexDG) v).getOutgoingNeighbours());
        return neigh;
    }

    @Override
    public List<VertexDG> getIncomingNeighbours(VertexDG v) {
        List<VertexDG> neigh = new ArrayList<>(((VertexDG) v).getIncomingNeighbours());
        return neigh;
    }

    public void addEdge(VertexDG v, VertexDG w) {
        v.addOutgoingNeighbour(w);
        w.addIncomingNeighbour(v);
    }
}

class VertexDG implements Vertex {

    private int id;

    private Set<VertexDG> incoming_neighbours;
    private Set<VertexDG> outgoing_neighbours;

    public VertexDG(int id) {
        this.id = id;
        outgoing_neighbours = new HashSet<>();
        incoming_neighbours = new HashSet<>();
    }

    public void addOutgoingNeighbour(VertexDG v) {
        outgoing_neighbours.add(v);
    }
    public void addIncomingNeighbour(VertexDG v) {
        incoming_neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<Vertex: " + getId() + ">";
    }

    @Override
    public int getId() {
        return id;
    }

    public Collection<VertexDG> getOutgoingNeighbours() {
        return new ArrayList<>(this.outgoing_neighbours);
    }

    public Collection<VertexDG> getIncomingNeighbours() {
        return new ArrayList<>(this.incoming_neighbours);
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
        return (o instanceof Vertex) && (((Vertex) o).getId() == this.getId());
    }
}


/**
 * Interface for a generic graph. You may assume that our implementation is an
 * undirected graph.
 */
interface DirectedGraphInterface {

    /**
     * Returns the "outgoing neighbours" in a collection by id
     *
     * @param v
     *     vertex to get the neighbours from reachable from this vertex.
     * @return collection of neighbours.
     */
    List<VertexDG> getOutgoingNeighbours(VertexDG v);

    /**
     * Returns the "incoming neighbours" in a collection by id
     *
     * @param v
     *     vertex to get the neighbours from that can reach this vertex.
     * @return collection of neighbours.
     */
    List<VertexDG> getIncomingNeighbours(VertexDG v);

    /**
     * @return a collection of all vertices in the graph.
     */
    Collection<VertexDG> getAllVertices();
}

