package com.practice.A_ds.G_graphs;

//https://www.geeksforgeeks.org/count-possible-paths-source-destination-exactly-k-edges/
public class H_PathsInGraphWithKEdges {

  static final int V = 4; //Number of vertices

  // A naive recursive function to count walks from u to v with k edges
  static int countwalks(int graph[][], int u, int v, int k)
  {
    // Base cases
    if (k == 0 && u == v)           return 1;
    if (k == 1 && graph[u][v] == 1) return 1;
    if (k <= 0)                     return 0;

    // Initialize result
    int count = 0;

    // Go to all adjacents of u and recur
    for (int i = 0; i < V; i++)
      if (graph[u][i] == 1)  // Check if is adjacent of u
        count += countwalks(graph, i, v, k-1);

    return count;
  }

  public static void main (String[] args) throws java.lang.Exception
  {
    /* Let us create the graph shown in above diagram*/
    int graph[][] =new int[][] { {0, 1, 1, 1},
        {0, 0, 0, 1},
        {0, 0, 0, 1},
        {0, 0, 0, 0}
    };
    int u = 0, v = 3, k = 2;
    System.out.println(countwalks(graph, u, v, k));
  }
}
