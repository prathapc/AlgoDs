package com.practice.A_ds.G_graphs;

import java.util.*;

/**
 * Created by prathapchowdary on 21/09/21.
 * P: If given tree is valid graph
 * S: build adj list and maintain parent of each node (as its undirected graph and we don't want to
 * end up traversing b/w node and its parent)
 */
class D_GraphTreeValid_DFS {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour : adjacencyList.get(node)) {
                if (parent.get(node) == neighbour) {
                    continue;
                }
                if (parent.containsKey(neighbour)) {
                    return false;
                }
                stack.push(neighbour);
                parent.put(neighbour, node);
            }
        }
        return parent.size() == n;
    }
}
