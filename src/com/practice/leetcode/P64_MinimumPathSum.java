package com.practice.leetcode;

import java.util.*;

/**
 * Created by Prathap on 18 Jan, 2020
 *
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class P64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (i == 0 && j == 0) continue;
                if (i-1 < 0) {
                    grid[i][j] += grid[i][j-1];
                } else if (j-1 < 0) {
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[r-1][c-1];
    }

}
