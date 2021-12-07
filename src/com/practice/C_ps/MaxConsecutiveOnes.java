package com.practice.C_ps;

/**
 * Created by Prathap on 11 Jan, 2020
 *
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 */
public class MaxConsecutiveOnes {

    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0;

        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < A.length) {
            if (A[right] == 1) {
                right++;
                maxLen = Math.max(maxLen, right - left);
            } else if(K != 0) {
                right++;
                K--;
                maxLen = Math.max(maxLen, right - left);
            } else  {
                while(K <= 0) {
                    if (A[left++] == 0)
                        K++;
                }
            }
        }
        return maxLen;
    }
}
