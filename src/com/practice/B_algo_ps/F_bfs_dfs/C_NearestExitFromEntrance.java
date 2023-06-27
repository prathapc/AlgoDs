package com.practice.B_algo_ps.F_bfs_dfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathapchowdary on 24/06/23.
 *
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 *
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 *
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 *
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 */
public class C_NearestExitFromEntrance {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> bfs = new LinkedList <>();
        bfs.offer(entrance);

        int rows = maze.length, cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        visited[entrance[0]][entrance[1]] = true;

        int steps = 1;

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 1; i <= size; i++) {
                int[] cell = bfs.poll();
                int row = cell[0], col = cell[1];

                int[][] adjacentCells = new int[][]{{row+1, col}, {row, col+1}, {row-1, col}, {row, col-1}};
                for (int[] adjacentCell : adjacentCells) {
                    int adjacentRow = adjacentCell[0], adjacentCol = adjacentCell[1];

                    if (adjacentRow < 0 || adjacentRow >= rows
                            || adjacentCol < 0 || adjacentCol >= cols
                            || maze[adjacentRow][adjacentCol] == '+')
                        continue;

                    if (!visited[adjacentRow][adjacentCol]) {
                        if (adjacentRow == 0 || adjacentRow == rows - 1
                                || adjacentCol == 0 || adjacentCol == cols - 1)
                            return steps;

                        visited[adjacentRow][adjacentCol] = true;
                        bfs.offer(new int[]{adjacentRow, adjacentCol});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
