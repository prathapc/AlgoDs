package com.practice.B_algo_ps.H_backtracking;

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
public class D_GenerateParentheses {

    //bruteforce => O(2^2n) - beats 5%
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
     * Keep track of remaining open and close and use them accordingly. Implemented by me.
     * beats 95% memory 27.5%
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis("", n, n, result);
        return result;
    }
    private void generateParenthesis(String current, int open, int close, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        } else if (open == 0) { //if remaining open are zero then use remaining close parenthesis
            while (close-- > 0) {
                current += ')';
            }
            result.add(current);
            return;
        } else if (open == close){ //if remaining oopen and close are equal - use open parenthesis only as using close would be invalid
            generateParenthesis(current+'(', open-1, close, result);
        } else { // if we reached here then open must be less than close remaining - use both of them
            generateParenthesis(current+'(', open-1, close, result);
            generateParenthesis(current+')', open, close-1, result);
        }
    }

    /**
     * Same as above but elegant :
     * Instead of adding '(' or ')' every time as in Approach 1,
     * let's only add them when we know it will remain a valid sequence.
     * We can do this by keeping track of the number of opening and closing brackets we have placed so far.
     *
     * We can start an opening bracket if we still have one (of n) left to place.
     * And we can start a closing bracket if it would not exceed the number of opening brackets.
     *
     * O(4^n/sqrt(n))
     *
     * beats 95% and memory 100%
     */
    public List<String> generateParenthesis3(int n) {
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
