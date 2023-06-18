package com.practice.B_algo_ps.A_arrays;

/**
 * Created by Prathap on 17 May, 2022
 *
 * You are given two sorted arrays of distinct integers nums1 and nums2.
 *
 * A valid path is defined as follows:
 * Choose array nums1 or nums2 to traverse (from index-0).
 * Traverse the current array from left to right.
 * If you are reading any value that is present in nums1 and nums2 you are allowed to change your path to the other array. (Only one repeated value is considered in the valid path).
 * The score is defined as the sum of uniques values in a valid path.
 *
 * Return the maximum score you can obtain of all possible valid paths.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Input: nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
 * Output: 30
 * The maximum is obtained with the path [2,4,6,8,10].
 *
 * https://leetcode.com/problems/get-the-maximum-score/
 */
public class J_MaximumSumPathInTwoArrays {

    public int maxSum(int[] a, int[] b) {
        long result = 0, sum1 = 0, sum2 = 0, mod=(long) 1e9+7;
        int m = a.length, n = b.length;
        int i=0, j=0;
        while(i<m && j<n) {
            if(a[i] < b[j]) {
                sum1 += a[i++];
            } else if(a[i] > b[j]) {
                sum2 += b[j++];
            } else {
                result += Math.max(sum1, sum2) + a[i];
                sum1 = 0; sum2 = 0;
                i++; j++;
            }
        }
        while(i<m) {
            sum1 += a[i++];
        }
        while(j<n) {
            sum2 += b[j++];
        }
        result += Math.max(sum1, sum2);
        return (int)(result%mod);
    }
}
