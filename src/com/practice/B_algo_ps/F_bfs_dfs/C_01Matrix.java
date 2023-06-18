package com.practice.B_algo_ps.F_bfs_dfs;

import java.util.LinkedList;

/**
 * Created by prathapchowdary on 21/04/22.
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * https://leetcode.com/problems/01-matrix/
 *
 */
public class C_01Matrix {
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        LinkedList<Pair> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    queue.addLast(new Pair(i, j));
                }
                else{
                    matrix[i][j] = -matrix[i][j];
                }
            }
        }
        while (!queue.isEmpty()){
            Pair rem = queue.removeFirst();
            for (int i = 0; i < 4; i++){
                int idash = rem.x + dirs[i][0];
                int jdash = rem.y + dirs[i][1];
                if (idash < 0 || idash >= m || jdash < 0 || jdash >= n || matrix[idash][jdash] >= 0){
                    continue;
                }
                queue.addLast(new Pair(idash, jdash));
                matrix[idash][jdash] = matrix[rem.x][rem.y] + 1;
            }
        }
        return matrix;
    }
}
