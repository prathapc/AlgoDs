package com.practice.B_algo.B_arrays;

/**
 * Created by prathapchowdary on 11/11/21.
 * https://leetcode.com/problems/multiply-strings/submissions/
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
public class D_MultiplyStrings {
    public static void main(String args[]) {
        System.out.println(multiply("123", "456"));
    }
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;
        int[] product = new int[len];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int idx = i + j + 1;
                int p = a * b + product[idx];
                product[idx] = p % 10;
                product[idx - 1] += p / 10;
            }
        }

        int start = product[0] != 0 ? 0 : 1;
        StringBuilder result = new StringBuilder();
        for (int i = start; i < len; i++) {
            result.append(product[i]);
        }
        return result.toString();
    }
}