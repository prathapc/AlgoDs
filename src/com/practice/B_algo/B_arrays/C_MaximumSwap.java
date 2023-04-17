package com.practice.B_algo.B_arrays;

/**
 * Created by prathapchowdary on 10/01/22.
 * https://leetcode.com/problems/maximum-swap/
 * swap at most two digits to form larger num
 * Input: 5648
 * Output: 8645
 */
public class C_MaximumSwap {
    public int maximumSwap(int num) {
        char[] input = String.valueOf(num).toCharArray();
        if (input.length < 2) {
            return num;
        }
        int[] max = new int[input.length];
        max[input.length-1] = input[input.length-1];
        for (int i=input.length-2; i>=0; i--) {
            max[i] = Math.max(max[i+1], input[i]);
        }

        for (int i=0; i<input.length-1; i++) {
            if (input[i] < max[i+1]) {
                return swap(input, i, String.valueOf(num).lastIndexOf(max[i+1]));
            }
        }
        return num;
    }

    private int swap(char[] num, int index, int maxIndex) {
        char temp = num[index];
        num[index] = num[maxIndex];
        num[maxIndex] = temp;

        return Integer.parseInt(String.valueOf(num));
    }
}
