package com.coffeesi.graph;

import java.util.List;

public class GraphsData {
    private List<Graph> graphs;

    public GraphsData(List<Graph> graphs) {
        this.graphs = graphs;
    }

    public List<Graph> getGraphs() {
        return graphs;
    }

    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }

    public String toString() {
        return "Graphs: " + graphs;
    }
}
