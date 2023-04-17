package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by prathapchowdary on 17/01/22.
 *
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * Note: "two adjacent"
 *
 * Input: s = "abbaca"
 * Output: "ca"
 *
 * Input: s = "abbbaca"
 * Output: "aba"
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class C_RemoveAdjDuplicatesInString {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        System.out.println(removeDuplicates("abbba"));
    }
}
