package Graphs;

import java.util.Comparator;

public class VertexNumPair {
    VertexUG vertex;
    int num;

    public VertexNumPair(VertexUG vertex, int num) {
        this.vertex = vertex;
        this.num = num;
    }

    public VertexUG getVertex() {
        return vertex;
    }

    public int getNum() {
        return num;
    }
}

