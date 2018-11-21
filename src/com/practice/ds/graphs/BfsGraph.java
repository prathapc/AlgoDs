package com.practice.ds.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsGraph {
  public static void main(String args[]) {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(0, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    bfs(graph, 4);
  }

  private static void bfs(Graph graph, int v) {
    boolean[] visited = new boolean[v];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(2);
    bfsUtil(graph, queue, visited);
  }

  private static void bfsUtil(Graph graph, Queue<Integer> queue, boolean[] visited) {
    while (!queue.isEmpty()) {
      int n = queue.poll();
      if (!visited[n]) {
        visited[n] = true;
        System.out.print(n + " ");
        List<Integer> dependents = graph.adj[n];
        for (int i : dependents) {
          queue.add(i);
        }
      }
    }
  }

  static class Graph {
    int v;
    List[] adj;

    Graph(int v) {
      this.v = v;
      adj = new LinkedList[v];
      for (int i=0; i<v; i++) {
        adj[i] = new LinkedList();
      }
    }

    public void addEdge(int v, int w) {
      adj[v].add(w);
    }
  }
}
