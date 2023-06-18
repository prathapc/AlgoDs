package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 21/01/22.
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * https://leetcode.com/problems/diagonal-traverse/
 */
public class E_DiagonalTraverse {

    // concise solution
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m * n];
        String dir = "RU";
        int r = 0, c = 0;
        for(int i = 0; i < m * n; i++){
            res[i] = matrix[r][c];
            if(dir.equals("RU")){
                r--;
                c++;
            } else {
                r++;
                c--;
            }

            if(r >= m) {
                r = m - 1;
                c += 2;
                dir = "RU";
            }
            if(c >= n) {
                c = n - 1;
                r += 2;
                dir = "LD";
            }
            if(r < 0){
                r = 0;
                dir = "LD";
            }
            if(c < 0){
                c = 0;
                dir = "RU";
            }
        }
        return res;
    }

    // elegant solution
    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 1;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row -= d;
            col += d;

            if (row >= m) { row = m - 1; col += 2; d = -d;}
            if (col >= n) { col = n - 1; row += 2; d = -d;}
            if (row < 0)  { row = 0; d = -d;}
            if (col < 0)  { col = 0; d = -d;}

            //here -d means changing walk direction
        }

        return result;
    }
}
