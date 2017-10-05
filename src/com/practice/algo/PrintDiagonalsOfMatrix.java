package com.practice.algo;

import com.practive.util.Utility;

/**
 * Created by prathap on 06/08/17.
 */
public class PrintDiagonalsOfMatrix {
  public static void main(String args[]) {
    int r=2, c=3;
    int[][] a = Utility.readArray(r, c);
    int i=0, j=0;
    while(true) {
      if(i==r-1 && j==c-1) {
        System.out.println(a[i][j]);
        break;
      }

      int p=i, q=j;

      while(true) {
        if(isValidCell(p,q,r,c)) {
          System.out.print(a[p][q] + " ");
          --p;
          ++q;
        } else{
          System.out.println();
          break;
        }
      }

      if(i == r-1) {
        j++;
      } else {
        i++;
      }
    }
  }

  private static boolean isValidCell(int a, int b, int r, int c) {
    return (a>=0 && b>=0 && a<r  && b<c);
  }
}
