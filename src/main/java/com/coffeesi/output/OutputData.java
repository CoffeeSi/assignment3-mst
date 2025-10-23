package com.coffeesi.output;

import java.io.FileWriter;
import java.util.List;

import com.coffeesi.result.ResultData;
import com.coffeesi.result.ResultGraph;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OutputData {
    public static void outputDataToJSON(List<ResultGraph> resultGraphs) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ResultData data2 = new ResultData(resultGraphs);
        try (FileWriter writer = new FileWriter("assign3_output.json")) {
            gson.toJson(data2, writer);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
