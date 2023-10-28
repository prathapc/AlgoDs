package com.practice.B_algo_ps.I_dp;

import java.util.*;

/**
 * Created by prathapchowdary on 08/05/22.
 *
 * Alice is texting Bob using her phone. The mapping of digits to letters is as an old nokia phone with keypad
 * For example, to add the letter 's', Alice has to press '7' four times. Similarly, to add the letter 'k', Alice has to press '5' twice.
 * Note that the digits '0' and '1' do not map to any letters, so Alice does not use them.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 *
 * Input: pressedKeys = "22233"
 * Output: 8
 *
 * Explanation:
 * The possible text messages Alice could have sent are:
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae", and "ce".
 * Since there are 8 possible messages, we return 8.
 *
 * https://leetcode.com/problems/count-number-of-texts/
 */
public class I_CountNumberOfTexts {
    //recursion - TLE
    int mod = (1000000007);
    public int countTexts_recursion(String pressedKeys) {
        int[] key = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
        int n = pressedKeys.length();
        return solve(0,pressedKeys,key);
    }
    public int solve(int index, String s, int[] key) {
        if (index == s.length()) {
            return 1;
        }
        int count = 0;
        int num = s.charAt(index) - '0';
        int rep = key[num];
        for (int i = 0; i < rep && index + i < s.length() && s.charAt(index) == s.charAt(index + i); i++) {
            count += solve(index + 1 + i, s, key);
            count %= mod;
        }
        return  count;
    }

    //top down DP
    //int mod = 1000000000+7;
    public int countTexts(String pressedKeys) {
        int data[] = {0,0,3,3,3,3,3,4,3,4};
        //Map<Integer, Integer> dp = new HashMap<>(); LESS EFFICIENT THAN 1D ARRAY
        int[] dp = new int[pressedKeys.length()];
        Arrays.fill(dp, -1);
        return countTextsUtil(pressedKeys, 0, data, dp);
    }

    private int countTextsUtil(String pressedKeys, int index, int[] data, int[] dp) {
        if (index == pressedKeys.length()) return 1;
        if (dp[index] != -1) return dp[index];
        int count = 0;
        int pressedDigit = pressedKeys.charAt(index) - '0';
        int digits = data[pressedDigit];
        for (int i=0; i<digits && index+i<pressedKeys.length() && pressedKeys.charAt(index) == pressedKeys.charAt(index+i); i++) {
            count += countTextsUtil(pressedKeys, index+1+i, data, dp); //if neighbour char is same there is another way to recurse through
            count %= mod;
        }
        dp[index] = count;
        return count;
    }
}
