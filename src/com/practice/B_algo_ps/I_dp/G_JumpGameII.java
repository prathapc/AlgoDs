package com.practice.B_algo_ps.I_dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Prathap on 04 Jan, 2020
 *
 * https://leetcode.com/problems/jump-game-ii/
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps. You can assume that you can always reach the last index.
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class G_JumpGameII {

    public static void main(String args[]) {
        int nums[] = {2,3,1,1,4};
        jump(nums);
    }

    //beats 99.5%
    //https://www.youtube.com/watch?v=dJ7sWiOoK7g
    public static int jump(int[] nums) {
        //build a window
        //from curr window, build next window start and end (find furthest we can reach in next window)
        //repeat this process and count steps
        int l=0, r=0, furthest = 0;
        int steps = 0;
        while (r < nums.length-1) {
            for (int i=l; i<=r; i++) {
                furthest = Math.max(furthest, i+nums[i]);
            }
            l = r+1;
            r = furthest;
            steps++;
        }
        return steps;
    }

    //similar to jump-game-i solution using stack but failing for few test cases
    public int jump2(int[] nums) {
        int minJumps = Integer.MAX_VALUE;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        //Set<Integer> seenIndexes = new HashSet<>();
        Map<Integer, Integer> dp = new HashMap<>();
        while (!stack.isEmpty()) {
            int curr[] = stack.pop();
            if (dp.containsKey(curr[0])) {
                if (dp.get(curr[0]) < curr[1]) {
                    continue;
                }
                dp.put(curr[0], curr[1]);
            }

            if (curr[0] >= nums.length-1) {
                minJumps = Math.min(curr[1], minJumps);
                continue;
            }

            for (int i=1; i<=nums[curr[0]]; i++) {
                stack.push(new int[]{curr[0] + i, curr[1]+1});
            }
            dp.put(curr[0], curr[1]);
        }
        return minJumps;
    }


    //top down DP
    public int jump1(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return dp(nums, 0, memo);
    }
    public Integer dp(int[] nums, int current, Integer[] memo) {
        if (current == nums.length - 1) {
            // Valid endpoint
            return 0;
        } else if (current >= nums.length) {
            // you have gone too far
            return null;
        }

        if (memo[current] != null) {
            return memo[current];
        }

        Integer min = null;
        int jumps = nums[current];

        for (int i = 1; i < jumps + 1; i++) {
            // take the result of the recursion
            Integer res = dp(nums, current + i, memo);
            if (res != null && res >= 0) {
                if (min == null) {
                    min = res + 1;
                } else {
                    // ensure the minimum recurse result is populated and returned
                    min = Math.min(min, res + 1);
                }
            }
        }

        memo[current] = min;
        return memo[current];
    }
}
