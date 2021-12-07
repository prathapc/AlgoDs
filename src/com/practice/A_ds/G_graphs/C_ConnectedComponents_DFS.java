package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 08/10/21.
 *
 * 323. Number of Connected Components in an Undirected Graph
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 *
 */
public class C_ConnectedComponents_DFS {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        int[] visited = new int[n];

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }

    private void dfs(List<Integer>[] adjList, int[] visited, int index) {
        visited[index] = 1;

        for (int i = 0; i < adjList[index].size(); i++) {
            if (visited[adjList[index].get(i)] == 0) {
                dfs(adjList, visited, adjList[index].get(i));
            }
        }
    }
}
