package com.practice.B_algo.I_dp;

/**
 * Created by Prathap on 19 Oct, 2019
 *
 * https://leetcode.com/problems/jump-game/
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class G_JumpGameI {

    //accepted solution beats 100%
    public boolean canJump1(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    //other solution: beats 22%
    public static void main(String args[]) {
        int[] nums = new int[]{2,3,1,1,4};
        //other standard dfs way of solving
        Boolean[] memo = new Boolean[nums.length];
        memo[nums.length - 1] = true;

        System.out.println(dfs(0, nums, memo));
    }

    private static boolean dfs(int pos, int[] nums, Boolean[] memo) {
        if (memo[pos] != null) return memo[pos];

        int furthest = Math.min(pos + nums[pos], nums.length - 1);
        boolean canReach = false;
        for (int i = furthest; i >= pos + 1; --i) {
            if (dfs(i, nums, memo)) {
                canReach = true;
                break;
            }
        }

        memo[pos] = canReach;
        return canReach;
    }
}
