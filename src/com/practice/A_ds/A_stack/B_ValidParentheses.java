package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by Prathap on 20 Dec, 2019
 *
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 */
public class B_ValidParentheses {

    public static void main(String args[]) {
        System.out.println(longestValidParentheses(")()())"));
    }

    private static int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

}
