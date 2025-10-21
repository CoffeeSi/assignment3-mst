package com.coffeesi.graph;

public class Edge {
    private String start;
    private String end;
    private double weight;
    
    public Edge(String start, String end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public String getStart() { return start; }
    public String getEnd() { return end; }
    public double getWeight() { return weight; }

    public String toString() {
        return start + " -> " + end + " : " + weight; 
    }
}
