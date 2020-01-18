package com.practice.algo.backtracking;

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

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return false;
        int n = nums.length;
        int sumt = 0;
        for(int i=0; i<n; i++){
            sumt = sumt + nums[i];
        }
        int sumset = sumt/k;
        if(sumt % k != 0)
            return false;

        boolean[] visited = new boolean[n];
        // backtrack for all k sets

        return canPartition(k, nums, 0,0, sumset, visited);

    }

    public boolean canPartition(int k, int[] nums, int currsum, int curridx, int sumset, boolean[] visited){

        if(k==1)
            return true;

        if(currsum == sumset)
            return canPartition(k-1, nums, 0,0, sumset, visited);

        // already have a currsum
        // target is sumset
        for(int j=curridx; j<nums.length; j++)
        {
            if(visited[j])
                continue;
            int nowsum = currsum+nums[j];
            if(nowsum <= sumset){
                visited[j] = true;
                if(canPartition( k, nums, nowsum, j+1,sumset, visited ))
                    return true;
                visited[j] = false;
            }
        }

        return false;

    }

}
