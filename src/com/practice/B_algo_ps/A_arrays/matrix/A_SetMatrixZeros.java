package com.practice.B_algo_ps.A_arrays.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by prathapchowdary on 03/07/23.
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class A_SetMatrixZeros {
  public void setZeroes(int[][] matrix) {
    boolean fr = false, fc = false;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0)
            fr = true;
          if (j == 0)
            fc = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (fr) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if (fc) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }

  //They are using the first row and column as a memory to keep track of all the 0's in the entire matrix.

  //we used two Boolean variables named fr and fc which implies first row and first column
  //which will be true if any element in first row or column would be 0 indicating that
  //entire row or column is going to be set as 0 so if we take it as Boolean
  //we don't have to worry about it for the rest of the time as later we will check in
  //last two sections of program for that condition to set it as 0.

}
