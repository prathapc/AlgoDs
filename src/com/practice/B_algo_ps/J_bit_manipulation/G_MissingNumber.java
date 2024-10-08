package com.practice.B_algo_ps.J_bit_manipulation;

/**
 * Created by prathapchowdary on 01/12/23.
 *
 * https://leetcode.com/problems/missing-number/
 */
public class G_MissingNumber {

    /**
     * The basic idea is to use XOR operation. We all know that a^b^b =a,
     * which means two xor operations with the same number will eliminate the number and
     * reveal the original number. In this solution, I apply XOR operation to both the index and
     * value of the array. In a complete array with no missing numbers,
     * the index and value should be perfectly corresponding( nums[index] = index),
     * so in a missing array, what left finally is the missing number.
     */
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}
