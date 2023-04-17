package com.practice.B_algo.A_sort_search_math.search;

/**
 * Created by prathapchowdary on 02/05/22.
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class B_SearchIn2DMatrix {
    //recursion - beats 30%
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0, col=matrix[0].length-1;
        return searchMatrixUtil(matrix, row, col, target);
    }
    private boolean searchMatrixUtil(int[][] matrix, int row, int col, int target) {
        if (row<0 || row>=matrix.length || col<0 || col>=matrix[0].length) return false;
        if (matrix[row][col] == target) return true;
        else if (matrix[row][col] < target) {
            return searchMatrixUtil(matrix, row+1, col, target);
        } else {
            return searchMatrixUtil(matrix, row, col-1, target);
        }
    }

    //stair case search - O(M+N) : beats 30%
    public boolean searchMatrix_1(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j --;
            else if(matrix[i][j] < target)
                i ++;
        }
        return false;
    }
}
