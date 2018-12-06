package com.practice.companyQA.Intuit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BuildDependencyGraph {
    private int node;
    private List<Integer> dependencies[];

    BuildDependencyGraph(int v) {
      this.node = v;
      this.dependencies = new LinkedList[v];
      for (int i=0; i<v; i++) {
        dependencies[i] = new LinkedList<>();
      }
    }

    public void addEdge(int v, int w) {
      dependencies[v].add(w);
    }

  public Stack<Integer> findBuildOrder(BuildDependencyGraph g) {
      Stack<Integer> stack = new Stack<>();
      boolean[] visited = new boolean[node];
      for (int i = 0; i< node; i++) {
        if(!visited[i]) {
          topologySortUtil(i, stack, visited);
        }
      }
      return stack;
    }

    private void topologySortUtil(int i, Stack<Integer> stack, boolean[] visited) {
      visited[i] = true;
      Iterator<Integer> itr = dependencies[i].iterator();
      Integer node;
      while (itr.hasNext()) {
        node = itr.next();
        if(!visited[node]) {
          topologySortUtil(node, stack, visited);
        }
      }
      stack.push(i);
    }

  public int calculateBuildTime(Map<Integer, Integer> timeMap) {
      int totalTime = 0;
      Set<Integer> completedBuilds = new HashSet<>();
      for (int i = 0; i< 4; i++) {
        List<Integer> dependents = dependencies[i];
        if (dependents != null && !dependents.isEmpty()) {
          int maxTime = Integer.MIN_VALUE;
          for(Integer dependent : dependents) {
            //find max build time of dependency
            if (!completedBuilds.contains(dependent)) {
              if (maxTime < timeMap.get(dependent)) {
                maxTime = timeMap.get(dependent);
              }
              completedBuilds.add(dependent);
            }
          }
          //update time of highest time taking build
          if (maxTime != Integer.MIN_VALUE) {
            totalTime += maxTime;
          }
          //handling initial node case
          if (i == 0) {
            completedBuilds.add(i);
            totalTime += timeMap.get(i);
          }
        } else {
          //build without dependencies
          if (!completedBuilds.contains(i)) {
            totalTime += timeMap.get(i);
          }
          completedBuilds.add(i);
        }
      }
      return totalTime;
    }

  public int calculateBuildTime1(Map<Integer, Integer> timeMap) {
    int totalTime = 0;
    Set<Integer> completedBuilds = new HashSet<>();
    Set<Integer> individualBuilds = new HashSet<>();
    for (int i = 0; i< 4; i++) {
      List<Integer> dependents = dependencies[i];
      if (dependents != null && !dependents.isEmpty()) {
        int maxTime = Integer.MIN_VALUE;
        for(Integer dependent : dependents) {
          //find max build time of dependency
          if (!completedBuilds.contains(dependent)) {
            if (maxTime < timeMap.get(dependent)) {
              maxTime = timeMap.get(dependent);
            }
            completedBuilds.add(dependent);
          }
        }
        //update time of highest time taking build
        if (maxTime != Integer.MIN_VALUE) {
          totalTime += maxTime;
        }
        //handling initial node case
        if (!completedBuilds.contains(i)) {
          completedBuilds.add(i);
          totalTime += timeMap.get(i);
        }
      } else {
        //build without dependencies - add to a set
        if (!completedBuilds.contains(i)) {
          //totalTime += timeMap.get(i);
          individualBuilds.add(i);
        }
        completedBuilds.add(i);
      }
    }
    //build without dependencies max time
    if (individualBuilds.size() > 0) {
      int maxTime = Integer.MIN_VALUE;
      for(Integer individualBuild : individualBuilds) {
        //find max build time of dependency
        if (maxTime < timeMap.get(individualBuild)) {
          maxTime = timeMap.get(individualBuild);
        }
      }
      if (maxTime != Integer.MIN_VALUE) {
        totalTime += maxTime;
      }
    }
    return totalTime;
  }
}
