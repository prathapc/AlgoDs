package com.practice.B_algo_ps.A_arrays.matrix;

/**
 * Created by prathapchowdary on 04/07/23.
 *
 * TODO
 *
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of
 * matrix inside the rectangle defined by its upper left corner (row1, col1) and
 * lower right corner (row2, col2).
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable
 *
 * similar:
 * https://leetcode.com/problems/matrix-block-sum/solutions/477041/java-prefix-sum-with-picture-explain-clean-code-o-m-n/
 */
public class D_RangeSumQuery2D {

  private int[][] dp;

  public void NumMatrix(int[][] matrix) {
    if (   matrix           == null
        || matrix.length    == 0
        || matrix[0].length == 0   ){
      return;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    dp = new int[m + 1][n + 1];
    for(int i = 1; i <= m; i++){
      for(int j = 1; j <= n; j++){
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] -dp[i - 1][j - 1] + matrix[i - 1][j - 1] ;
      }
    }
  }
  public int sumRegion(int row1, int col1, int row2, int col2) {
    int iMin = Math.min(row1, row2);
    int iMax = Math.max(row1, row2);

    int jMin = Math.min(col1, col2);
    int jMax = Math.max(col1, col2);

    return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
  }


  //another sol
  int[][] sum;
  public void NumMatrix1(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements inside the rectangle [0,0,i,j]
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }
  }
  public int sumRegion1(int r1, int c1, int r2, int c2) {
    r1++; c1++; r2++; c2++; // Since our `sum` starts by 1 so we need to increase r1, c1, r2, c2 by 1
    return sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
  }
}
