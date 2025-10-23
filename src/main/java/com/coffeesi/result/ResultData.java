package com.coffeesi.result;

import java.util.List;

public class ResultData {
    private List<ResultGraph> results;

    public ResultData(List<ResultGraph> results) {
        this.results = results;
    }

    public List<ResultGraph> getResults() { return results; }
    public void setResults(List<ResultGraph> results) { this.results = results; }
    public void addResult(ResultGraph graph) { results.add(graph); }
}
