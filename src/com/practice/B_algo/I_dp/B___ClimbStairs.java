package com.practice.B_algo.I_dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 28/04/22.
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * https://leetcode.com/problems/climbing-stairs/
 */
public class B___ClimbStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> data = new HashMap<>();
        return climbStairsUtil(0, n, data);
    }

    //beats 10%
    private int climbStairsUtil(int currentStair, int finalStair, Map<Integer, Integer> data) {
        if (currentStair > finalStair) {
            return 0;
        }
        if (currentStair == finalStair) {
            return 1;
        }

        if (data.containsKey(currentStair)) {
            return data.get(currentStair);
        }

        int oneStep = climbStairsUtil(currentStair+1, finalStair, data);
        int twoStep = climbStairsUtil(currentStair+2, finalStair, data);
        int noOfWays = oneStep+twoStep;

        data.put(currentStair, noOfWays);
        return noOfWays;
    }

    //beats 100%
    private static void countWaysToReachNthStair_maxTwoSteps(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; //1 way (with no steps)
        dp[1] = 1; //1 way (with one step)
        for (int i=2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
