package com.practice.A_ds.G_graphs.DisjointSets;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 17/11/23.
 *
 * https://leetcode.com/problems/redundant-connection/
 */
public class D_RedundantConnection {
    Map<Integer, Integer> parentMap = null;
    Map<Integer, Integer> rank = null;
    public int[] findRedundantConnection(int[][] edges) {
        parentMap = new HashMap<>();
        rank = new HashMap<>();
        for (int i=0; i<edges.length; i++) {
            parentMap.put(i, i);
            rank.put(i, 1);
        }
        for (int[] edge : edges) {
            if (!union(edge[0]-1, edge[1]-1)) return edge;
        }
        return new int[2];
    }

    private boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) return false;

        //leverage rank to avoid skew
        if (rank.get(parentX) > rank.get(parentY)) {
            parentMap.put(parentY, parentX);
        } else if (rank.get(parentY) > rank.get(parentX)) {
            parentMap.put(parentX, parentY);
        } else {
            parentMap.put(parentX, parentY);
            rank.put(parentY, rank.get(parentY)+1);
        }
        return true;
    }
    private int find(int x) {
        if (parentMap.get(x) == x) return x;
        int p = find(parentMap.get(x));
        //for path compression
        parentMap.put(x, p);
        return parentMap.get(x);
    }
}
