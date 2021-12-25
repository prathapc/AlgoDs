package com.practice.B_algo.E_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prathap on 07 Jan, 2020
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * https://leetcode.com/problems/generate-parentheses/
 *
 */
public class Z_GenerateParentheses {

    //bruteforce => O(2^2n)
    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    /**
     * Backtracking
     * Instead of adding '(' or ')' every time as in Approach 1,
     * let's only add them when we know it will remain a valid sequence.
     * We can do this by keeping track of the number of opening and closing brackets we have placed so far.
     *
     * We can start an opening bracket if we still have one (of n) left to place.
     * And we can start a closing bracket if it would not exceed the number of opening brackets.
     *
     * O(4^n/sqrt(n))
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis("", result, 0, 0, n);
        return result;
    }
    private void generateParenthesis(String str, List<String> result, int open, int close, int max) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }

        if (open < max) {
            generateParenthesis(str + "(", result, open + 1, close, max);
        }
        if (close < open) {
            generateParenthesis(str + ")", result, open, close + 1, max);
        }
    }
}
