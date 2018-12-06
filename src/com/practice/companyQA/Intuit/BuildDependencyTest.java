package com.practice.companyQA.Intuit;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BuildDependencyTest {

  public static void main(String[] args) {
    BuildDependencyGraph graph = new BuildDependencyGraph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);
    //graph.addEdge(0, 3);

    //graph.addEdge(0, 1);
    //graph.addEdge(0, 2);
    /*graph.addEdge(1, 3);
    graph.addEdge(2, 3);*/

    Map<Integer, Integer> mapOfNodeAndBuildTime = new HashMap<>();
    mapOfNodeAndBuildTime.put(0, 10);
    mapOfNodeAndBuildTime.put(1, 2);
    mapOfNodeAndBuildTime.put(2, 5);
    mapOfNodeAndBuildTime.put(3, 10);

    Stack<Integer> dependencyOrder = graph.findBuildOrder(graph);
    System.out.println("Build dependency order is -> ");
    dependencyOrder.forEach(e -> {
      char node = (char) (65 + e);
      System.out.println(node);
    });

    int totalTime = graph.calculateBuildTime1(mapOfNodeAndBuildTime);
    System.out.println("Total time for the build is -> " + totalTime);
  }
}
