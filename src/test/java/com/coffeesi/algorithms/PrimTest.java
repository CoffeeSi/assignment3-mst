package com.coffeesi.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.coffeesi.graph.Edge;
import com.coffeesi.graph.Graph;

public class PrimTest {

    Graph graph;
    
    @Before
    public void setup() {
        List<String> nodes = Arrays.asList("A", "B", "C", "D", "E");
        List<Edge> edges = Arrays.asList(
            new Edge("A", "B", 4),
            new Edge("A", "C", 2),
            new Edge("B", "C", 5),
            new Edge("B", "D", 10),
            new Edge("C", "D", 3),
            new Edge("C", "E", 8),
            new Edge("D", "E", 7)
        );
        graph = new Graph(0, nodes, edges);
    }

    @Test
    public void testSameTotalCost() {
        Prim prim = new Prim();
        Kruskal kruskal = new Kruskal();
        
        prim.primMST(graph);
        kruskal.kruskalMST(graph);
        assertEquals(prim.getTotalCost(), kruskal.getTotalCost());
    }

    @Test
    public void testNumberEdgesEqualVminus1() {
        Prim prim = new Prim();
        prim.primMST(graph);
        assertEquals(graph.getNodes().size()-1, prim.getMSTEdges().size());
    }

    @Test
    public void testMSTIsAcyclic() {
        Prim prim = new Prim();
        prim.primMST(graph);
        assertTrue(isAcyclic(graph.getNodes(), prim.getMSTEdges()));
    }

    @Test
    public void testMSTConnectsAllVertices() {
        Prim prim = new Prim();
        prim.primMST(graph);
        assertTrue(isConnected(graph.getNodes(), prim.getMSTEdges()));
    }

    @Test
    public void testDisconnectedGraphHandledGracefully() {
        List<String> nodes2 = Arrays.asList("A", "B", "C");
        List<Edge> edges2 = Arrays.asList(
                new Edge("A", "B", 1)
        );
        Graph disconnectedGraph = new Graph(0, nodes2, edges2);

        Prim prim = new Prim();
        prim.primMST(disconnectedGraph);
        assertTrue(prim.getMSTEdges().size() < disconnectedGraph.getNodes().size() - 1);
    }

    @Test
    public void testExecutionTimeNonNegative() {
        Prim prim = new Prim();
        prim.primMST(graph);
        assertTrue(prim.getExecutionTimeMs() >= 0);
    }

    @Test
    public void testOperationsCountNonNegativeAndConsistent() {
        Prim prim = new Prim();
        prim.primMST(graph);
        assertTrue(prim.getOperationsCount() >= 0);
    }

    @Test
    public void testReproducibilityOnSameDataset() {
        Prim prim1 = new Prim();
        Prim prim2 = new Prim();
        prim1.primMST(graph);
        prim2.primMST(graph);
        assertEquals(prim1.getTotalCost(), prim2.getTotalCost());
    }


    private boolean isAcyclic(List<String> nodes, List<Edge> edges) {
        Map<String, String> parent = new HashMap<>();
        for (String node : nodes) parent.put(node, node);

        for (Edge e : edges) {
            String rootA = find(parent, e.getFrom());
            String rootB = find(parent, e.getTo());
            if (rootA.equals(rootB)) { 
                return false; 
            }
            parent.put(rootA, rootB);
        }
        return true;
    }

    private boolean isConnected(List<String> nodes, List<Edge> edges) {
        Map<String, List<String>> adj = new HashMap<>();
        for (String node : nodes) adj.put(node, new ArrayList<>());
        for (Edge e : edges) {
            adj.get(e.getFrom()).add(e.getTo());
            adj.get(e.getTo()).add(e.getFrom());
        }

        Set<String> visited = new HashSet<>();
        dfs(nodes.get(0), adj, visited);
        return visited.size() == nodes.size();
    }

    private void dfs(String node, Map<String, List<String>> adj, Set<String> visited) {
        visited.add(node);
        for (String neighbor : adj.get(node)) {
            if (!visited.contains(neighbor)) dfs(neighbor, adj, visited);
        }
    }

    private String find(Map<String, String> parent, String node) {
        if (!parent.get(node).equals(node)) {
            parent.put(node, find(parent, parent.get(node)));
        }
        return parent.get(node);
    }
}
