package com.practice.B_algo_ps.I_dp;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
    // traverse from end assuming last element is goal post
    // keep shifting goal post from last to beginning as and when we find we can reach from its predecessor
    // how do we know we can reach from predecessor? just do index + value at index to know if we reach next
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;
        for (int i=nums.length-2; i>=0; i--) {
            if (i+nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }

    //beats 5%
    public boolean canJump_dfs_stack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Set<Integer> seenIndexes = new HashSet<>();
        while (!stack.isEmpty()) {
            int currIndex = stack.pop();
            if (seenIndexes.contains(currIndex)) continue;
            if (currIndex >= nums.length-1) return true;
            for (int i=1; i<=nums[currIndex]; i++) {
                stack.push(currIndex + i);
            }
            seenIndexes.add(currIndex);
        }
        return false;
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
