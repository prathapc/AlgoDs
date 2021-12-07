package com.practice.A_ds.G_graphs.DisjointSets;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 19/09/21.
 *
 * https://leetcode.com/problems/number-of-provinces/
 *
 * province is a group of cities that are connected directly or in directly (similar to no of islands)
 */
public class E_NoOfProvinces {
    private int[] data;
    public int findCircleNum(int[][] isConnected) {
        data = new int[isConnected.length];
        Arrays.fill(data, -1);

        for (int i=0; i<isConnected.length; i++) {
            for (int j=0; j<isConnected[0].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == -1)
                count++;
        }
        return count;
    }

    private int find(int x) {
        while (data[x] == -1) {
            return x;
        }
        return find(data[x]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            data[rootY] = rootX;
        }
    }
}
