package com.coffeesi.algorithms;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import com.coffeesi.graph.Edge;
import com.coffeesi.graph.Graph;

public class Kruskal {
    // Instance fields for JSON output file
    private List<Edge> mst_edges;
    private int total_cost;
    private int operations_count;
    private double execution_time_ms;
    private Map<String, String> parent;

    // Getters
    public List<Edge> getMSTEdges() { return mst_edges; }
    public int getTotalCost() { return total_cost; }
    public int getOperationsCount() { return operations_count; }
    public double getExecutionTimeMs() { return execution_time_ms; }

    // Kruskal's algorithm method
    public void kruskalMST(Graph graph) {
        // Reset instance fields for each operation
        mst_edges = new ArrayList<>();
        total_cost = 0;
        operations_count = 0;
        execution_time_ms = 0;
        parent = new HashMap<>();

        // Set timer to measure duration of algorithm
        long startTime = System.nanoTime();

        // Initializing input values
        List<String> nodes = graph.getNodes();
        List<Edge> edges = graph.getEdges();

        // Sorting edges list by weight
        edges.sort(Comparator.comparingInt(Edge::getWeight));

        for (String node : nodes) {
            parent.put(node, node);
            operations_count++;
        }

        for (Edge e : edges) {
            operations_count++;

            String rootFrom = find(e.getFrom());
            String rootTo = find(e.getTo());

            if (!rootFrom.equals(rootTo)) {
                mst_edges.add(e);
                total_cost += e.getWeight();
                union(rootFrom, rootTo);
                operations_count++;
            }

            if (mst_edges.size() == nodes.size() - 1) {
                break;
            }
        }

        // Set parent to null to not record in JSON
        parent = null;
        
        // Record the duration of algorithm
        long endTime = System.nanoTime();
        execution_time_ms = (endTime - startTime) / 1000000.0;

    }

    private String find(String node) {
        operations_count++;
        if (!parent.get(node).equals(node)) {
            parent.put(node, find(parent.get(node)));
            operations_count++; 
        }
        return parent.get(node);
    }

    private void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }
}
