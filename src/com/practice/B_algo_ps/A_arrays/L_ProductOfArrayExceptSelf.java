package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 19/06/22.
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class L_ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];

        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }

    public static void main(String args[]) {
        productExceptSelf(new int[]{1,2,3,4});
    }

    //with out extra space
    public int[] productExceptSelf_1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
