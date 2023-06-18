package com.practice.B_algo_ps.H_backtracking;

import java.util.Arrays;

/**
 * Created by Prathap on 16 Jan, 2020
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 *
 */
public class PartitiontoKEqualSumSubsets {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return false;
        int n = nums.length;
        int totSum = Arrays.stream(nums).sum();
        int subsetSum = totSum/k;
        if(totSum % k != 0)
            return false;

        return canPartition(nums, k, 0,0, subsetSum, new boolean[n]);
    }

    public static boolean canPartition(int[] nums, int k, int currSum, int currIndex, int subsetSum, boolean[] visited){
        if(k==1)
            return true;

        if(currSum == subsetSum)
            return canPartition(nums, k-1, 0,0, subsetSum, visited);

        for(int i=currIndex; i<nums.length; i++) {
            if(visited[i])
                continue;
            if(currSum+nums[i] <= subsetSum) {
                visited[i] = true;
                if(canPartition(nums, k, currSum+nums[i], i+1, subsetSum, visited))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4));
    }

}
