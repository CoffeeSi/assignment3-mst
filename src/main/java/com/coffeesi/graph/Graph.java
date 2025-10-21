package com.coffeesi.graph;

import java.util.List;

public class Graph {
    private int id;
    private List<String> nodes;
    private List<Edge> edges;

    public Graph(int id, List<String> nodes, List<Edge> edges) {
        this.id = id;
        this.nodes = nodes;
        this.edges = edges;
    }

    public int getId() { return id; }
    public List<String> getNodes() { return nodes; }
    public List<Edge> getEdges() { return edges; }

    public void addEdge(String start, String end, double weight) {
        edges.add(new Edge(start, end, weight));
    }

    public String toString() {
        return "id: " +  id + "\nnodes: " + nodes + "\nedges: " + edges;
    }
}
