package com.practice.algo.recursion;

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
public class GenerateParentheses {

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
