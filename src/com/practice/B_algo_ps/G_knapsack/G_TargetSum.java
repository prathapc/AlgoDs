package com.practice.B_algo_ps.G_knapsack;

/**
 * Created by prathapchowdary on 11/12/23.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * https://leetcode.com/problems/target-sum/
 */
public class G_TargetSum {

    //topDown - beats 17%
    int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        findTargetSumWays(nums, 0, 0, target);
        return result;
    }
    private void findTargetSumWays(int[] nums, int index, int currSum, int target) {
        if (index == nums.length && currSum == target) result++;
        if (index == nums.length) return;
        findTargetSumWays(nums, index+1, currSum+nums[index], target);
        findTargetSumWays(nums, index+1, currSum-nums[index], target);
    }

    //bottomUp - beats 100%
    public int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (S > sum || -S < -sum || (S + sum) % 2 == 1) return 0;

        int[] dp = new int[(S + sum) / 2 + 1];
        dp[0] = 1;

        for (int num: nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] += dp[i - num]; // Crux
            }
        }

        return dp[dp.length - 1];
    }
}
