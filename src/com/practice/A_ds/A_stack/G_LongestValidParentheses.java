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
public class G_LongestValidParentheses {

    public static void main(String args[]) {
        System.out.println(longestValidParentheses(")()())"));
    }

    //Time complexity O(n)
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
    /** EXPLANATION:
     * Instead of finding every possible string and checking its validity, we can make use of a stack while scanning the given string to:
     *
     * Check if the string scanned so far is valid.
     * Find the length of the longest valid string.
     * In order to do so, we start by pushing -1 onto the stack. For every ‘(’ encountered, we push its index onto the stack.
     *
     * For every ')' encountered, we pop the topmost element.
     * Then, the length of the currently encountered valid string of parentheses will be the difference between the current element's index and the top element of the stack.
     *
     * If, while popping the element, the stack becomes empty, we will push the current element's index onto the stack.
     * In this way, we can continue to calculate the length of the valid substrings and return the length of the longest valid string at the end.
     */





    //another sol - O(n^2)
    public int longestValidParentheses_1(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    count++;
                } else {
                    count--;
                }
                if (count < 0) {
                    break;

                }
                if (count == 0) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                    }
                }
            }
        }
        return max;
    }
}
