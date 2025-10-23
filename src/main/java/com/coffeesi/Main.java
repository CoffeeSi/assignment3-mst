package com.coffeesi;

import java.util.ArrayList;
import java.util.List;

import com.coffeesi.algorithms.Kruskal;
import com.coffeesi.algorithms.Prim;
import com.coffeesi.graph.Graph;
import com.coffeesi.graph.GraphsData;
import com.coffeesi.output.InputData;
import com.coffeesi.output.OutputData;
import com.coffeesi.result.ResultGraph;

public class Main {
    public static void main(String[] args) {
        // Input
        GraphsData inputData = InputData.inputDataFromJSON();

        // Algorithms
        List<ResultGraph> resultGraphs = new ArrayList<>();
        for (Graph g : inputData.getGraphs()) {
            Prim primAlg = new Prim();
            Kruskal kruskalAlg = new Kruskal();

            primAlg.primMST(g);
            kruskalAlg.kruskalMST(g);
            
            resultGraphs.add(new ResultGraph(
                g.getId(),
                g.getNodes().size(),
                g.getEdges().size(),
                primAlg, 
                kruskalAlg));
        }

        // Output
        OutputData.outputDataToJSON(resultGraphs);
    }
}
