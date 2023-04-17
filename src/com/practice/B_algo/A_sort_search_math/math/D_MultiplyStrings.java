package com.practice.B_algo.A_sort_search_math.math;

/**
 * Created by prathapchowdary on 11/11/21.
 * https://leetcode.com/problems/multiply-strings/
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
        int[] pos = new int[len];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        int start = pos[0] != 0 ? 0 : 1;
        StringBuilder result = new StringBuilder();
        for (int i = start; i < len; i++) {
            result.append(pos[i]);
        }
        return result.toString();
    }

    //another simpler version
    public String multiply1(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int[] ans = new int[num1.length() + num2.length() - 1];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }
}