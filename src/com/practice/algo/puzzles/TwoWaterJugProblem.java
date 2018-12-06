package com.practice.algo.puzzles;

public class TwoWaterJugProblem {

  public static void main(String[] args) {
    int jug1 = 3, jug2 = 5;
    int d = 4;
    System.out.println(waterJugSolution(jug1, jug2, d));
  }

  private static int waterJugSolution(int jug1, int jug2, int d) {

    //make sure
    if (jug1 > jug2) {
      int temp = jug1;
      jug1 = jug2;
      jug2 = temp;
    }

    if (d > jug2) {
      return -1;
    }

    if (d % gcd(jug1, jug2) != 0) {
      return -1;
    }

    return Math.min(waterJugSolutionUtil(jug1, jug2, d), waterJugSolutionUtil(jug2, jug1, d));
  }

  private static int gcd(int i, int j) {
    if (j == 0) {
      return i;
    }
    return gcd(j, i%j);
  }

  private static int waterJugSolutionUtil(int jug1, int jug2, int d) {

    return 0;
  }
}
