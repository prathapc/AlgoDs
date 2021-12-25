package com.practice.B_algo.B_arrays;

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

    public int longestOnes1(int[] A, int K) {

        int left = 0;   // start of the window
        int max = 0;        // len of max valid window
        int zeros = 0;      // number of zeros in a window

        if(A == null || A.length == 0){
            return 0;
        }

        for(int i = 0 ; i < A.length ; i++){

            // Increase count of zero whenever you see one
            if(A[i]==0){
                zeros++;
            }

            // Shrink the window until zeros are equal less than required k
            while(left <= i && zeros > K){
                if(A[left] == 0){
                    zeros--;
                }
                left++;
            }

            // At every step record the length of the window
            max = Math.max(max, i - left +1);
        }

        return max;
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}
