package com.practice.algo;

import com.practive.util.Utility;

import java.util.Scanner;

/**
 * Created by prathap on 05/10/17.
 *
 * http://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/
 */
public class MinStepsToReachDestination {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.print(minStepsToReachN_Recursion(n, 0, 0));
  }

  private static int minStepsToReachN_Recursion(int n, int i, int move) {
    if(n == i)
      return move;
    else if(Math.abs(i) > n)
      return Integer.MAX_VALUE;
    else {
      return Utility.min(
          minStepsToReachN_Recursion(n, i-(move+1), move+1) ,
          minStepsToReachN_Recursion(n, i+(move+1), move+1));
    }
  }
}
