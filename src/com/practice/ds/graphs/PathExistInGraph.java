package com.practice.ds.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by prathap on 05/08/17.
 */
public class PathExistInGraph {
  public static void main(String args[]) {
    Graph1 g = new Graph1(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println(isPathExist(g, 1,3));
  }

  private static boolean isPathExist(Graph1 graph, int src, int dest) {
    boolean visted[] = new boolean[4];
    LinkedList<Integer> listOfNodes = new LinkedList<>();
    listOfNodes.add(src);
    visted[src] = true;
    Iterator<Integer> itr;
    while(listOfNodes.size() != 0) {
      itr = graph.adj[listOfNodes.poll()].listIterator();
      while (itr.hasNext()) {
        int adjNode = itr.next();
        if(adjNode == dest) {
          return true;
        }
        if(visted[adjNode] == false) {
          visted[adjNode] = true;
          listOfNodes.add(adjNode);
        }
      }
    }
    return false;
  }
}

class Graph1 {
  int v;
  LinkedList<Integer> adj[];

  Graph1(int v) {
    this.v = v;
    adj = new LinkedList[v];

    for(int i=0; i<v; i++) {
      adj[i] = new LinkedList<Integer>();
    }
  }

  void addEdge(int c, int w) {
    adj[c].add(w);
  }
}
