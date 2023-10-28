package com.practice.B_algo_ps.I_dp;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 10/05/22.
 * There is a robot on an m x n grid.
 * The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * https://leetcode.com/problems/unique-paths/
 */
public class A_UniquePaths {
    //recursion with memorization beats 100%
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return uniquePathsUtil(0, 0, m-1, n-1, memo);
    }

    private int uniquePathsUtil(int currX, int currY, int destX, int destY, int[][] memo) {
        if (currX == destX && currY == destY) {
            return 1;
        }
        if (currX > destX || currY > destY) {
            return 0;
        }

        if (memo[currX][currY] != 0) return memo[currX][currY];

        return memo[currX][currY] = uniquePathsUtil(currX+1, currY, destX, destY, memo) + uniquePathsUtil(currX, currY+1, destX, destY, memo);
    }
}
