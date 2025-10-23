package com.coffeesi.output;

import java.io.FileReader;

import com.coffeesi.graph.GraphsData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class InputData {
    public static GraphsData inputDataFromJSON() {
        try (JsonReader reader = new JsonReader(new FileReader("assign3_input.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            GraphsData data = gson.fromJson(reader, GraphsData.class);
            reader.close();
            return data;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return null;
        // for (Graph g : data.getGraphs()) {
        //     Prim primAlg = new Prim();
        //     primAlg.primMST(g);
        //     Kruskal kruskalAlg = new Kruskal();
        //     kruskalAlg.kruskalMST(g);
        //     System.out.println(g);
        //     resultGraphs.add(new ResultGraph(
        //             g.getId(),
        //             g.getNodes().size(),
        //             g.getEdges().size(),
        //             primAlg, 
        //             kruskalAlg));
        // }
    }
}
