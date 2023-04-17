package com.practice.B_algo.B_arrays;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 *
 * https://leetcode.com/problems/spiral-matrix/
 */
public class E_MatrixInSpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
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

    //another approach
    int t, b, l, r;
    int[][] matrix;
    public List<Integer> spiralOrder1(int[][] matrix) {
        this.matrix = matrix;
        final int m = matrix.length;
        final int n = matrix[0].length;
        t = 0; b = m-1;
        l = 0; r = n-1;
        List<Integer> list = new ArrayList<>();
        int i=0;
        while (t <= b && l <= r) {
            if (i == 0)
                Right(list);
            if (i == 1)
                Down(list);
            if (i == 2)
                Left(list);
            if (i == 3)
                Up(list);
            i++;
            i %= 4;
        }
        return list;
    }

    void Right(final List<Integer> list) {
        for (int j=l; j<=r; j++) {
            list.add(matrix[t][j]);
        }
        t++;
    }
    void Left(final List<Integer> list) {
        for (int j=r; j>=l; j--) {
            list.add(matrix[b][j]);
        }
        b--;
    }
    void Down(final List<Integer> list) {
        for (int i=t; i<=b; i++) {
            list.add(matrix[i][r]);
        }
        r--;
    }
    void Up(final List<Integer> list) {
        for (int i=b; i>=t; i--) {
            list.add(matrix[i][l]);
        }
        l++;
    }
}
