package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 24/03/22.
 *
 * https://leetcode.com/problems/plus-one/
 *
 * Input: digits = [9]
 * Output: [1,0]
 *
 * Input: digits = [8,9,9]
 * Output: [9,0,0]
 */
public class A_PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--) {
            int temp = digits[i] + carry;
            if (temp == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = temp;
                carry = 0;
            }
        }

        if (carry == 1) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i=0; i<digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
        return digits;
    }

    //elegant solution
    public int[] plusOne_(int[] digits) {
        for (int i=digits.length-1; i>=0; i--){
            if (digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }

        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;

    }
}
