package com.coffeesi.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<String> nodes;
    private List<Edge> edges;

    public Graph(List<String> nodes) {
        this.nodes = nodes;
        this.edges = new ArrayList<Edge>();
    }

    public List<String> getNodes() { return nodes; }
    public List<Edge> getEdges() { return edges; }

    public void addEdge(String start, String end, double weight) {
        edges.add(new Edge(start, end, weight));
    }
}
