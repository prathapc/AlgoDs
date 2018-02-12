package com.practice.ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by prathap on 11/12/17.
 *
 * TO-DO
 *
 */
public class PathInGraphWithKSteps {
  public static void main(String[] args) {
    Graph graph = constructGraph();
    char src = 'A', dest = 'B';
    int k = 4;
    findPaths(graph, src, dest, k);
  }

  private static void findPaths(com.practice.ds.graphs.Graph graph, char src, char dest, int atMostSteps) {
    ArrayList<ArrayList<Character>> listOfPaths = new ArrayList<>();


  }



  private static Graph constructGraph() {
    Graph graph = new Graph(3);
    graph.addEdge('A', 'B');
    graph.addEdge('B', 'A');
    graph.addEdge('A','C');
    graph.addEdge('C','B');
    return graph;
  }
}
