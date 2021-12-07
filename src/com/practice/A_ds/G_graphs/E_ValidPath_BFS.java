package com.practice.A_ds.G_graphs;

import java.util.*;

/**
 * Created by prathapchowdary on 10/10/21.
 *
 * For finding shortest path BFS is better than DFS, because in BFS
 * as soon as we hit destination that's going to be shortest route and no
 * need to find all paths unlike DFS
 */
public class E_ValidPath_BFS {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        final boolean[] visited = new boolean[n];
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            final int currentVertex = queue.poll();
            if(currentVertex == end) {
                return true;
            }
            //final Set<Integer> neighbors = findNeighbors(edges, n, currentVertex);
            for (final int neighbor : graph.get(currentVertex)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
            /*for(final int neighbor : neighbors) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }*/
        }
        return false;
    }

    //not required as we built map for graph
    private static Set<Integer> findNeighbors(int[][] edges, int n, int v) {
        final Set<Integer> neighbors = new HashSet<>();
        for(int[] edge : edges) {
            if(edge[0] == v) {
                neighbors.add(edge[1]);
            } else if(edge[1] == v) {
                neighbors.add(edge[0]);
            }
        }
        return neighbors;
    }
}
