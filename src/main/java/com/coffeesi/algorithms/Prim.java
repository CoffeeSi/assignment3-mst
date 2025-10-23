package com.coffeesi.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.coffeesi.graph.Graph;
import com.coffeesi.graph.Edge;

public class Prim {
    // Instance fields for JSON output file
    private List<Edge> mst_edges;
    private int total_cost;
    private int operations_count;
    private double execution_time_ms;

    // Getters
    public List<Edge> getMSTEdges() { return mst_edges; }
    public int getTotalCost() { return total_cost; }
    public int getOperationsCount() { return operations_count; }
    public double getExecutionTimeMs() { return execution_time_ms; }
    
    // Prim's algorithm method
    public void primMST(Graph graph) {
        // Reset instance fields for each operation
        mst_edges = new ArrayList<>();
        total_cost = 0;
        operations_count = 0;
        execution_time_ms = 0;

        // Set timer to measure duration of algorithm
        long startTime = System.nanoTime();

        // Initializing input values
        List<String> nodes = graph.getNodes();
        List<Edge> edges = graph.getEdges();

        // Create visited set of nodes
        Set<String> visited = new HashSet<>();

        // Assign start vertex
        String start = nodes.get(0);
        visited.add(start);

        // Do algorithm while visited nodes not equals
        while (nodes.size() > visited.size()) {
            Edge minEdge = null;
            int  minWeight = Integer.MAX_VALUE;

            for (Edge e: edges) {
                operations_count++;
                boolean fromVisited = visited.contains(e.getFrom());
                boolean toVisited = visited.contains(e.getTo());
                // Check XOR of from and to vertices
                if (fromVisited ^ toVisited ) {
                    if (e.getWeight() < minWeight) {
                        minEdge = e;
                        minWeight = e.getWeight();
                    }
                }
            }

            // If there is no connected edges then stop algorithm
            if (minEdge == null) {
                break;
            }

            mst_edges.add(minEdge);

            // Add vertex to visited set
            visited.add(minEdge.getFrom());
            visited.add(minEdge.getTo());
            total_cost += minEdge.getWeight();
        }

        long endTime = System.nanoTime();
        execution_time_ms = (endTime-startTime)/1000000.0;
    }
}
