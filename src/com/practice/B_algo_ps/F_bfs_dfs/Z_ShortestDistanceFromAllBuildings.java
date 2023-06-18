package com.practice.B_algo_ps.F_bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathapchowdary on 24/11/21.
 *
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/ [HARD]
 *
 * Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * Output: 7
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
 * So return 7.
 */
public class Z_ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalHouses = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (grid[row][col] == 1) {
                    totalHouses++;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (grid[row][col] == 0) {
                    int distance = bfs(grid, row, col, totalHouses);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }

        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
    }

    public int bfs(int[][] grid, int row, int col, int totalHouses) {
        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = grid.length;
        int cols = grid[0].length;
        int housesReached = 0;
        int distanceSum = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        boolean[][] visited = new boolean[rows][cols];
        visited[row][col] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            if (housesReached == totalHouses) {
                break;
            }
            for (int i=q.size(); i>0; i--) {
                int[] curr = q.poll();
                row = curr[0];
                col = curr[1];
                if (grid[row][col] == 1) {
                    distanceSum += steps;
                    housesReached++;
                    continue;
                }
                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols) {
                        if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] != 2) {
                            visited[nextRow][nextCol] = true;
                            q.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
            steps++;
        }
        //[[1,2,0]] => here we can not reach house hence should return -1 instead of 0
        if (housesReached != totalHouses) {
            for (row=0; row<rows; row++) {
                for (col=0; col<cols; col++) {
                    if (grid[row][col] == 0 && visited[row][col]) {
                        grid[row][col] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        return distanceSum;
    }
}

