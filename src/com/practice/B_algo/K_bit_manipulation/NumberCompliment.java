package com.practice.B_algo.K_bit_manipulation;

/**
 * Created by Prathap on 04 Dec, 2019
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 *
 * https://leetcode.com/problems/number-complement/
 *
 */
public class NumberCompliment {

    public static void main(String args[]) {
        int num = 5;
        int pow = 1;
        int result = 0;
        while (num > 0) {
            result += (num%2 ^ 1) * pow;
            pow *= 2;
            num /= 2;
        }
        System.out.println(result);
    }
}
