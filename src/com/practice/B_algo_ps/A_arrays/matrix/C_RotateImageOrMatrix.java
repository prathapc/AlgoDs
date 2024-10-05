package com.practice.B_algo_ps.A_arrays.matrix;

/**
 * Created by Prathap on 11 Jan, 2020
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * https://leetcode.com/problems/rotate-image/
 *
 */
public class C_RotateImageOrMatrix {

    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;
        while ( l < r ) {
            for(int i = 0; i < r - l; i++) {
                int top = l;
                int bottom = r;
                //save the topleft
                int topLeft = matrix[top][l + i];

                //move bottom left into top left
                matrix[top][l + i] = matrix[bottom - i][l];

                // move bottom right into bottom left
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // move top right into bottom right
                matrix[bottom][r - i] = matrix[top + i][r];

                // move top left into top right
                matrix[top + i][r] = topLeft;
            }
            l++;
            r--;
        }
    }
}
