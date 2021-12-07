package com.practice.B_algo.H_backtracking;

import com.practice.C_ps.Utility;

/**
 * Created by prathap on 04/08/17.
 */
public class KnightsTour_BackTracking {

  public static void main(String[] args) {
    solveKT();
  }

  static int n=24;
  public static void solveKT() {
    int sol[][] = new int[n][n];
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        sol[x][y] = -1;
      }
    }
    int moveX[] = {2, 1, -1, -2, -2, -1, 1, 2};
    int moveY[] = {1, 2, 2, 1, -1, -2, -2, -1};
    int x=0, y=0;
    int movei=1;
    sol[0][0] = 0;
    if(solutionUtil(x, y, sol, movei, moveX, moveY)) {
      Utility.printArray(sol, n, n);
    } System.out.println("Sol does not exist");

  }

  public static boolean solutionUtil(int x, int y, int[][] sol, int movei, int[] moveX, int[] moveY) {
    if(movei == n*n) {
      return true;
    }
    int nextX, nextY;
    for(int k=0; k<8; k++) {
      nextX = x + moveX[k];
      nextY = y + moveY[k];

      if(isSafe(nextX, nextY, sol)) {
        sol[nextX][nextY] = movei;  //make decision
        if(solutionUtil(nextX, nextY, sol, movei+1, moveX, moveY))
          return true;
        sol[nextX][nextY] = -1; //backtracking
      }
    }
    return false;
  }

  private static boolean isSafe(int x, int y, int sol[][]) {
    return (x >=0 && y >= 0 && x < n && y < n && sol[x][y] == -1);
  }
}
