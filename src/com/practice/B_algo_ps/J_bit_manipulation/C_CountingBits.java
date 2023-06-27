package com.practice.B_algo_ps.J_bit_manipulation;

/**
 * Created by prathapchowdary on 24/06/23.
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * https://leetcode.com/problems/counting-bits/
 */
public class C_CountingBits {
    public int[] countBits(int num) {
        int result[] = new int[num+1];
        result[0] = 0;
        if (num == 0) return result;
        result[1] = 1;
        if (num == 1) return result;
        result[2] = 1;
        if (num == 2) return result;
        for (int i = 3; i<=num; i++) {
            if (i%2 == 0) {
                result[i] = result[i/2];
            } else {
                result[i] = result[i-1]+1;
            }
        }
        return result;
    }
}
