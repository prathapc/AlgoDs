package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 16/10/22.
 *
 * You are given an integer array nums and two integers minK and maxK.
 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.
 *
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
 * sol:-
 * https://www.youtube.com/watch?v=TITMwkdtvFs&ab_channel=EasyCode
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds/discuss/2708099/JavaC%2B%2BPython-Sliding-Window-with-Explanation
 *
 */
public class D_B_CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] A, int minK, int maxK) {
        long res = 0, j = 0, jmin = -1, jmax = -1, n = A.length;
        for (int i = 0; i < n; ++i) {
            if  (A[i] < minK || A[i] > maxK) {
                jmin = jmax = -1;
                j = i + 1;
            }
            if (A[i] == minK) jmin = i;
            if (A[i] == maxK) jmax = i;
            res += Math.max(0L, Math.min(jmin, jmax) - j + 1);
        }
        return res;
    }
}
