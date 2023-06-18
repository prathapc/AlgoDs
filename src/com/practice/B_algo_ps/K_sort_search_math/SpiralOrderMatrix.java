package com.practice.B_algo_ps.K_sort_search_math;

/**
 * Created by prathap on 04/08/17.
 */
public class SpiralOrderMatrix {
  // Function print matrix in spiral form
  static void spiralPrint(int rowEnd, int colEnd, int a[][])
  {
    int i, rowStart = 0, colStart = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

    while (rowStart < rowEnd && colStart < colEnd)
    {
      // Print the first row from the remaining rows
      for (i = colStart; i < colEnd; ++i)
      {
        System.out.print(a[rowStart][i]+" ");
      }
      rowStart++;

      // Print the last column from the remaining columns
      for (i = rowStart; i < rowEnd; ++i)
      {
        System.out.print(a[i][colEnd-1]+" ");
      }
      colEnd--;

      // Print the last row from the remaining rows */
      if ( rowStart < rowEnd)
      {
        for (i = colEnd-1; i >= colStart; --i)
        {
          System.out.print(a[rowEnd-1][i]+" ");
        }
        rowEnd--;
      }

      // Print the first column from the remaining columns */
      if (colStart < colEnd)
      {
        for (i = rowEnd-1; i >= rowStart; --i)
        {
          System.out.print(a[i][colStart]+" ");
        }
        colStart++;
      }
    }
  }

  // driver program
  public static void main (String[] args)
  {
    int R = 3;
    int C = 6;
    int a[][] = { {1,  2,  3,  4,  5,  6},
        {7,  8,  9,  10, 11, 12},
        {13, 14, 15, 16, 17, 18}
    };
    spiralPrint(R,C,a);
  }
}