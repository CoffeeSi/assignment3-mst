# Assignment 3 - Minimum Spanning Tree

## Usage
### 1. Build the project

`` mvn clean package ``

### 2. Run CLI

`` java -jar target/assignment3-1.0.jar ``

### 3. Results

Performance metrics are saved in ``assign3_output.json`` file.

## Summary of Input Data and Algorithm Results

Three datasets of varying graph sizes and densities were tested to evaluate the performance of Prim’s and Kruskal’s algorithms. Each graph was processed using the same implementation, and results were recorded in output.json.

![Table 1](/docs/images/image.png)

Observations:

- Both algorithms produced identical MST total costs for all datasets.

- Execution time and operation count vary depending on the graph size and structure.

- Kruskal tends to be faster for sparse to moderately dense graphs due to its efficient edge sorting and union-find structure.

## Theoretical vs Practical Comparison

- Theoretical Complexity:
Prim’s algorithm works in O(V²) in the basic version or O(E log V) with a priority queue.
Kruskal’s algorithm works in O(E log E) because it needs to sort edges and use union–find.

- Approach:
Prim’s starts from one vertex and keeps adding the smallest edge that connects to the tree.
Kruskal’s sorts all edges and keeps adding the smallest ones without making cycles.

- Data Structures Used:
Prim’s uses an adjacency list or matrix and a visited set.
Kruskal’s uses an edge list and a union–find (disjoint set) structure.

- Efficiency (Theory):
Prim’s works better on dense graphs with many edges.
Kruskal’s works better on sparse graphs with fewer edges.

- Performance (Practice):
Prim’s does more operations on big graphs when there are many edges.
Kruskal’s usually runs faster and makes fewer operations on medium or large graphs.

- Implementation Complexity:
Prim’s is easier to write for adjacency matrix graphs.
Kruskal’s needs a union–find structure but is still simple for edge-based graphs.

- Memory Usage:
Prim’s memory use depends on how the graph is stored (matrix or list).
Kruskal’s memory use depends on the number of edges in the graph.

## Conclusion

Both Prim’s and Kruskal’s algorithms give the same total cost for connected graphs, which proves they work correctly. For small graphs, they perform almost the same. For larger graphs, Kruskal’s algorithm is usually faster and needs fewer operations because it sorts edges and uses a simple union-find system. Prim’s algorithm works better for dense graphs with many edges since it doesn’t need to sort all edges. Prim’s is easier to understand, while Kruskal’s is easier to use with real data like JSON files. In practice, Kruskal’s is best for sparse networks such as roads or communication links, and Prim’s is better for dense networks or complete graphs.


## References

1. GeeksforGeeks. "Kruskal’s Minimum Spanning Tree (MST) Algorithm"<br> https://www.geeksforgeeks.org/dsa/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/ 
2. GeeksforGeeks. Prim’s Algorithm for Minimum Spanning Tree (MST)<br> https://www.geeksforgeeks.org/dsa/prims-minimum-spanning-tree-mst-greedy-algo-5/
3. Habr. "Gson или «Туда и Обратно»"<br>https://habr.com/ru/companies/naumen/articles/228279/

## Author
Yevgeniy Averyanov SE-2436