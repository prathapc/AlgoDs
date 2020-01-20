package com.practice.algo.dp;

import com.practice.ps.Utility;

//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class RodCutProblem {

  public static void main(String args[]) {
    /*int l = 8;
    int value[] = {1,5,8,9,10,17,17,20};*/
    int l = 8;
    int value[] = {3,5,8,9,10,17,17,20};
    System.out.print(rodCutUtil(value, l));
  }

  private static int rodCutUtil(int[] value, int l) {
    int temp[][] = new int[value.length+1][value.length+1];
    for (int i=1; i<=value.length; i++) {
      for (int j=1; j<=value.length; j++) {
        if (i == 1) {
          temp[i][j] = value[i-1] * j;
          continue;
        }
        if (j < i) {
          temp[i][j] = temp[i-1][j];
          continue;
        }
        temp[i][j] = Utility.max(temp[i-1][j], j%i == 0 ? (j/i) * value[i-1] : ((j/i) * value[i-1] + temp[i][j%i]));
      }
    }
    return temp[value.length][value.length];
  }
}
