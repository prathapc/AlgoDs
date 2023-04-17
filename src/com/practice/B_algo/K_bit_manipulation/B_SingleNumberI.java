package com.practice.B_algo.K_bit_manipulation;

/**
 * Created by prathapchowdary on 14/06/22.
 *
 * https://leetcode.com/problems/single-number/
 */
public class B_SingleNumberI {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }
}
