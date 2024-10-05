package com.practice.B_algo_ps.I_dp;

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
public class B1_ClimbStairs {

    //bottom-up beats 100%
    private static void countWaysToReachNthStair_maxTwoSteps(int n) {
        if (n == 1) System.out.println(1);
        if (n == 2) System.out.println(2);
        int f[] = new int[n];
        f[0] = 1; f[1] = 2;
        for (int i=2; i<n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        System.out.println(f[n-1]);
    }

    //top-down beats 100%
    public int climbStairs(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        dp.put(2, 2);
        return climbStairs(n, dp);
    }
    private int climbStairs(int n, Map<Integer, Integer> dp) {
        if (dp.containsKey(n)) return dp.get(n);

        int res = climbStairs(n-1, dp) + climbStairs(n-2, dp);
        dp.put(n, res);

        return dp.get(n);
    }
}
