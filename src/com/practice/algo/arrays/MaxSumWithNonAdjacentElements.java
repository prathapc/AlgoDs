package com.practice.algo.arrays;

import com.practice.algo.Utility;

//works for non-nagative integers
public class MaxSumWithNonAdjacentElements {

  public static void main(String args[]) {
    //forPasitiveIntegers();
    includingNegativeIntegers();
  }

  private static void forPasitiveIntegers() {
    int a[]= {5,5,10,40,50,35,25};
    int sum1 = a[0];
    int sum2 = 0;
    for (int i=1; i<a.length; i++) {
      int prev = sum1;
      sum1 = sum2 + a[i];
      sum2 = Utility.max(prev, sum2);
    }
    System.out.println(Utility.max(sum1, sum2));
  }

  public static void includingNegativeIntegers(){
    int[] nums = {-1, 2, 3, -7, 3, 1};
    int[] dp = new int[nums.length];
    dp[0] = Math.max(0, nums[0]); // for dp[0], select the greater value (0,num[0])
    dp[1] = Math.max(nums[1], Math.max(0, dp[0]));
    int maxSum = Math.max(dp[0], dp[1]);
    for(int i = 2; i < nums.length; i++){
      int ifSelectCurrent = Math.max(nums[i] + dp[i-2], dp[i-2]);// if select, there are two possible
      int ifNotSelectCurrent = Math.max(dp[i-1], dp[i-2]);        // if not select, there are two posible
      dp[i] = Math.max(ifSelectCurrent, ifNotSelectCurrent);      // choose the greater one
      maxSum = Math.max(dp[i], maxSum);   // update the result
    }
    System.out.println(maxSum);
  }

}
