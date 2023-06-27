package com.practice.B_algo_ps.I_dp;

/**
 * Created by prathapchowdary on 25/06/23.
 *
 * https://leetcode.com/problems/domino-and-tromino-tiling/
 */
public class Z_DominoAndTrominoTiling {
    public int numTilings(int n) {
        int dp[] = new int[n+4];

        int mod = (int)(Math.pow(10,9)+7);
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5; //if you calculate by drawing uptil 5 or 6 then you can find the formula
        // that would be 2*prev + prev-2. So for dp[4] it is 2*5 + 1 = 11

        for(int i=4;i<=n;i++){
            dp[i] = (2*dp[i-1]) % mod + dp[i-3];
            dp[i] %= mod;
        }

        return dp[n];
    }
}
