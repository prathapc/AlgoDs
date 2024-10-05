package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

/**
 * Created by prathapchowdary on 07/11/23.
 *
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
 * then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * https://leetcode.com/problems/reverse-integer/
 */
public class B_ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        long result = 0;
        while(x > 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return isNegative ? (-1*(int) result) : (int) result;
    }
}
