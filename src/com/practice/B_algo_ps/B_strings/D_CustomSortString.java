package com.practice.B_algo_ps.B_strings;

/**
 * Created by prathapchowdary on 14/01/22.
 *
 * You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.
 * Permute the characters of s so that they match the order that order was sorted.
 * More specifically, if a character x occurs before character y in order, then x should occur before y in the permuted string.
 * Return any permutation of s that satisfies this property.
 *
 * Input: order = "cbafg", s = "abcd"
 * Output: "cbad" or "dcba" etc
 *
 * https://leetcode.com/problems/custom-sort-string/
 */
public class D_CustomSortString {

    public static void main(String args[]) {
        System.out.println(customSortString("cba", "abcd"));
    }

    public static String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();

        for (char c: order.toCharArray()) {
            int index = s.indexOf(c);
            // check until c exists in s
            while (index != -1) {
                result.append(c);
                // check for duplicate c from (prev index + 1)
                index = s.indexOf(c, index + 1);
            }
        }

        // add remaining chars to result either in the beginning or in the end
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (!result.toString().contains(c + "")) {
                sb.append(c);
            }
        }

        return sb.append(result).toString();
    }
}
