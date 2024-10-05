package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by prathapchowdary on 31/10/23.
 *
 * Given N nodes labeled from 0 to n-1 and a list of undirected edges, write a functiion to check
 * whether these edges makeup a valid tree.
 *
 * i/p: n=5, edges=[[0,1],[0,2],[0,3],[1,4]]
 * o/p: true
 *
 * https://leetcode.com/problems/graph-valid-tree/
 *
 * hint: a graph would not have a loop to be a tree and all the nodes would be connected
 */
public class A_IsGraphValidTree {

    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    public boolean isValidGraphTree(int n, int[][] edges) {
        if (n == 0 || n == 1) return true;
        if (edges.length == 0) return false;
        for (var edge : edges) {
            adjList.putIfAbsent(edge[0], new ArrayList<>());
            adjList.putIfAbsent(edge[1], new ArrayList<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        //check no loop by using dfs with visited set AND all nodes visited by checking visited size
        return dfs(edges[0][0], -1, visited) && visited.size()==n;
    }

    private static boolean dfs(int currNode, int parentNode, Set<Integer> visited) {
        if (visited.contains(currNode)) return false;
        visited.add(currNode);
        for (var neighbour : adjList.get(currNode)) {
            if (neighbour == parentNode) continue; //skip traversing parent node again
            if (!dfs(neighbour, currNode, visited)) return false;
        }
        return true;
    }

}
