package com.practice.ps;

//https://www.geeksforgeeks.org/count-subarrays-with-same-even-and-odd-elements/

public class OddEvenSubArrays {

  public static void main(String args[]) {

  }
}

/**
 * Another approach:-
 * replace all the even elements with -1 and all the odd elements with +1.
 * Now count all the subarrays with 0 sum which can be solved in O(n) using the following approach:
 *
 * https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 */
