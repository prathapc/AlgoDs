package com.practice.ps;

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
public class RotateImageOrMatrix {

    public void rotate(int[][] matrix) {
        int progress = 0;
        while(progress < matrix.length / 2) {
            for(int i = 0; i < matrix.length - (progress * 2) - 1; i++) {
                // Store val of top right in temp
                int temp = matrix[progress + i][matrix.length - progress - 1];
                // place top left val in top right
                matrix[progress + i][matrix.length - progress - 1] = matrix[progress][progress + i];
                // store val of bottom right in temp2
                int temp2 = matrix[matrix.length - 1 - progress][matrix.length - 1 - progress - i];
                // Place temp val in bottom right
                matrix[matrix.length - 1 - progress][matrix.length - 1 - progress - i] = temp;
                // store val of bottom left in temp
                temp = matrix[matrix.length - 1 - progress - i][progress];
                // place temp2 val in bottom left
                matrix[matrix.length - 1 - progress - i][progress] = temp2;
                // place temp in top left
                matrix[progress][progress + i] = temp;
            }
            progress ++;
        }
    }
}
