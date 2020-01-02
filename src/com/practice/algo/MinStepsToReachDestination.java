package com.practice.algo;

/**
 * Created by prathap on 05/10/17.
 *
 * http://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/) -> O(2^n)
 *
 * solve it with DP as well with n^2 complexity...
 */
public class MinStepsToReachDestination {
  public static void main(String args[]) {
    int dest = 11;
    System.out.println("No. of steps required"+
        " to reach " + dest +
        " is " + minStepsToReachN_Recursion(0, 0, dest) + " with i steps at i'th time");
  }

  private static int minStepsToReachN_Recursion(int source, int step, int dest) {
    // base cases
    if (Math.abs(source) > (dest))
      return Integer.MAX_VALUE;

    if (source == dest)
      return step;

    // at each point we can go either way

    // if we go on positive side
    int pos = minStepsToReachN_Recursion(source + step + 1,
        step + 1, dest);

    // if we go on negative side
    int neg = minStepsToReachN_Recursion(source - step - 1,
        step + 1, dest);

    // minimum of both cases
    return Math.min(pos, neg);
  }
}
