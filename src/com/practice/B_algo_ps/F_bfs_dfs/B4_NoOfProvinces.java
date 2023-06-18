package com.practice.B_algo_ps.F_bfs_dfs;

/**
 * Created by prathapchowdary on 19/09/21.
 *
 * https://leetcode.com/problems/number-of-provinces/
 *
 * province is a group of cities that are connected directly or in directly (similar to no of islands)
 */
public class B4_NoOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }
}
