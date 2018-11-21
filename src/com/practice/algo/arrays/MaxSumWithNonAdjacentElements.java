package com.practice.algo.arrays;

import com.practice.algo.Utility;

public class MaxSumWithNonAdjacentElements {

  public static void main(String args[]) {
    int a[]= {5,5,10,40,50,35};
    int sum1 = a[0];
    int sum2 = 0;
    for (int i=1; i<a.length; i++) {
      int prev = sum1;
      sum1 = sum2 + a[i];
      sum2 = Utility.max(prev, sum2);
    }
    System.out.println(Utility.max(sum1, sum2));
  }
}
