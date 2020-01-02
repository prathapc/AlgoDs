package com.practice.algo.binary_search;

/**
 * Created by Prathap on 23 Nov, 2019
 *
 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
 *
 */
public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length - 1;
        int i=0;
        while (i < n && m >= 0) {
            if (target == matrix[i][m]) {
                return true;
            } else if (target > matrix[i][m]) {
                i++;
            } else {
                m--;
            }
        }
        return false;
    }

}
