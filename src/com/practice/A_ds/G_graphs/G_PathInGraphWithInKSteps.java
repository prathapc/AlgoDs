package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by prathap on 05/08/17.
 */
public class G_PathInGraphWithInKSteps {
  public static void main(String[] args) {
    Graph graph = constructGraph();
    char src = 'A', dest = 'B';
    int atMostSteps = 4;
    findPaths(graph, src, dest, atMostSteps);
  }

  private static void findPaths(Graph graph, char src, char dest, int atMostSteps) {
    ArrayList<ArrayList<Character>> listOfPaths = new ArrayList<>();
    ArrayList<Character> path = new ArrayList<>();
    int offset = (int) 'A';
    for(int i=0; i<3; i++) {
      if(offset-i == (int)src) {
        path.add(src);
        findPathsUtil(i, graph, src, dest, atMostSteps, 1, path, listOfPaths);
      }
    }
    System.out.print(listOfPaths.size());
  }

  private static void findPathsUtil(
      int i, Graph graph, char src, char dest, int atMostSteps, int movei, ArrayList<Character> path, ArrayList<ArrayList<Character>> listOfPaths) {
    int offset = (int) 'A';
    Iterator<Character> itr = graph.adj[i].iterator();
    while (itr.hasNext()) {
      char ch = itr.next();
      path.add(ch);
      if(++movei <= atMostSteps) {
        if(ch == dest) {
          listOfPaths.add(path);
        }
      } else {
        path = new ArrayList<>();
        movei = 1;
      }
      findPathsUtil(ch-offset, graph, src, dest, atMostSteps, movei, path, listOfPaths);
    }
  }

  private static Graph constructGraph() {
    Graph graph = new Graph(3);
    graph.addEdge('A', 'B');
    graph.addEdge('B', 'A');
    graph.addEdge('A','C');
    graph.addEdge('C','B');
    return graph;
  }

  //use map instead
  static class Graph {
    int v;
    LinkedList<Character> adj[];

    Graph(int v) {
      this.v = v;
      adj = new LinkedList[v];

      for(int i=0; i<v; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    void addEdge(char c, char w) {
      int offset = (int) 'A';
      adj[c-offset].add(w);
    }
  }
}
