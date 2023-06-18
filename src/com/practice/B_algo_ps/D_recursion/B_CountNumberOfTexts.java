package com.practice.B_algo_ps.D_recursion;

import java.util.*;

/**
 * Created by prathapchowdary on 08/05/22.
 *
 * Input: pressedKeys = "22233"
 * Output: 8
 * Explanation:
 * The possible text messages Alice could have sent are:
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae", and "ce".
 * Since there are 8 possible messages, we return 8.
 *
 * https://leetcode.com/problems/count-number-of-texts/
 */
public class B_CountNumberOfTexts {
    //recursion - TLE
    int mod = (1000000007);
    public int countTexts_recursion(String pressedKeys) {
        int[] key = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
        int n = pressedKeys.length();
        return solve(0,pressedKeys,key);
    }
    public int solve(int ind, String s, int[] key) {
        if (ind == s.length()) {
            return 1;
        }
        int count = 0;
        int num = s.charAt(ind) - '0';
        int rep = key[num];
        for (int i = 0; i < rep && ind + i < s.length() && s.charAt(ind) == s.charAt(ind + i); i++) {
            count += solve(ind + 1 + i, s, key);
            count %= mod;
        }
        return  count;
    }

    //top down DP
    //int mod = (1000000007);
    public int countTexts(String pressedKeys) {
        int[] key = new int[] {0,0,3,3,3,3,3,4,3,4};
        int n = pressedKeys.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,pressedKeys,key,dp);
    }
    public int solve(int ind , String s ,int[] key,int[]dp){
        if(ind==s.length()){
            return 1;
        }
        if(dp[ind]!=-1) return dp[ind];
        int count = 0;
        int num = s.charAt(ind)-'0';
        int rep = key[num];
        for(int i =0;i<rep && ind+i<s.length() && s.charAt(ind)==s.charAt(ind+i);i++){
            count += solve(ind+1+i,s,key,dp);
            count %= mod;
        }
        return dp[ind] = count;
    }
}
