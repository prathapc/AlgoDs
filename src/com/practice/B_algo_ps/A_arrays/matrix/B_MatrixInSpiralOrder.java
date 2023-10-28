package com.practice.B_algo_ps.A_arrays.matrix;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 *
 * https://leetcode.com/problems/spiral-matrix/
 */
public class B_MatrixInSpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return res;
        int r = matrix.length, c = matrix[0].length;
        int up = 0,  down = r - 1;
        int left = 0, right = c - 1;
        while (res.size() < r * c) {
            //left to right
            for (int j = left; j <= right && res.size() < r * c; j++)
                res.add(matrix[up][j]);

            //up to down
            //start from up + 1 as last/top-right element is already covered
            for (int i = up + 1; i <= down - 1 && res.size() < r * c; i++)
                res.add(matrix[i][right]);

            //right to left
            for (int j = right; j >= left && res.size() < r * c; j--)
                res.add(matrix[down][j]);

            //down to up
            //start from down - 1 as starting/bottom-left element is already covered
            for (int i = down - 1; i >= up + 1 && res.size() < r * c; i--)
                res.add(matrix[i][left]);

            left++; right--; up++; down--;
        }
        return res;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        return res;
    }
}
