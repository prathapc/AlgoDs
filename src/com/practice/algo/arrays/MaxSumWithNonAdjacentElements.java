package com.practice.algo.arrays;

import com.practice.ps.Utility;

//works for non-nagative integers
public class MaxSumWithNonAdjacentElements {

  public static void main(String args[]) {
    forPasitiveIntegers();
    includingNegativeIntegers();
  }

  //Same as HouseRobber problem
  private static void forPasitiveIntegers() {
    int a[]= {5,5,10,40,50,35,25};
    int inclusive = a[0];
    int exclusive = 0;
    for (int i=1; i<a.length; i++) {
      int prevInclusive = inclusive;
      inclusive = exclusive + a[i];
      exclusive = Utility.max(prevInclusive, exclusive);
    }
    System.out.println(Utility.max(inclusive, exclusive));
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
