package com.practice.A_ds.G_graphs.DisjointSets;

/**
 * Created by prathapchowdary on 01/11/23.
 *
 * you have a graph of n nodes. you are given an integer 'n' and an array 'edges' where
 * edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 * return the no of connected components in the graph.
 *
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class C_ConnectedComponents {
    private int[] parent;
    private int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1]) == 1) {
                result--;
            }
        }

        return result;
    }

    private int find(int node) {
        int result = node;

        while (parent[result] != result) {
            parent[result] = parent[parent[result]];
            result = parent[result];
        }

        return result;
    }

    private int union(int n1, int n2) {
        int p1 = this.find(n1);
        int p2 = this.find(n2);

        if (p1 == p2) {
            return 0;
        }

        if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }

        return 1;
    }
}
