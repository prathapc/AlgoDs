package com.practice.A_ds.G_graphs;

import java.util.*;

/**
 * Created by prathapchowdary on 09/10/21.
 */
public class B1_ValidPath_DFS {
    boolean found = false;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;

        boolean[] visited = new boolean[n];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
        //construct graph, add bidirectional vertex
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //start dfs from start point
        dfs(graph, visited, start, end);

        return found;
    }

    private void dfs(Map<Integer,List<Integer>> graph,boolean[] visited, int start, int end){
        if(visited[start] || found)
            return;

        visited[start] = true;
        //when we found and neighbour which is equal to destination inside the recursion, break and return the true
        for(int neighbour : graph.get(start)){
            if(neighbour == end){
                found = true;
                break;
            }
            if(!visited[neighbour]) {
                dfs(graph, visited, neighbour, end); //otherwise deep dig again!
            }
        }
    }
}
