package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

/**
 * Created by prathapchowdary on 19/02/24.
 *
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 *
 * https://leetcode.com/problems/power-of-two/
 */
public class H_IsPowOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n == 0 || n%2 == 1) return false;
        return isPowerOfTwo(n/2);
    }
}
