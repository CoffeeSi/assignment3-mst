package com.coffeesi.result;

import java.util.Map;

import com.coffeesi.algorithms.Kruskal;
import com.coffeesi.algorithms.Prim;

public class ResultGraph {
    private int graph_id;
    private Map<String,Integer> input_stats;
    private Prim prim;
    private Kruskal kruskal;

    public ResultGraph(int id, int vertices, int edges, Prim prim, Kruskal kruskal) {
        this.graph_id = id;
        this.input_stats = Map.of("vertices", vertices, "edges", edges);
        this.prim = prim;
        this.kruskal = kruskal;
    }

    public int getGraphId() { return graph_id; }
    public Map<String,Integer> inputStats() { return input_stats; }
    public Prim getPrim() { return prim; }
    public Kruskal getKruskal() { return kruskal; }
}
