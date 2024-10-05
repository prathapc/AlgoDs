package com.practice.B_algo_ps.H_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("", n, 0, 0);
        return result;
    }
    private void generate(String parenthesis, int n, int open, int close) {
        if (open == n && close == n) {
            if (isValid(parenthesis))
                result.add(parenthesis);
            return;
        }
        if (open < n)
            generate(parenthesis+"(", n, open+1, close);
        if (close < open)
            generate(parenthesis+")", n, open, close+1);
    }
    private boolean isValid(String p) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '(')
                stack.push('(');
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * Same as above with slight modifucation to improve to beats 90% from 5% :
     * O(4^n/sqrt(n))
     */
    public List<String> generateParenthesis1(int n) {
        generate("", n, 0, 0);
        return result;
    }
    private void generateParentheses(String parenthesis, int n, int open, int close) {
        if (open == n && close == n) {
            result.add(parenthesis);
            //if (isValid(parenthesis)) //NO NEED TO CHECK ISVALID
            //result.add(parenthesis);
            return;
        }
        if (open < n)
            generateParentheses(parenthesis+"(", n, open+1, close);
        if (close < open) //INSTEAD OF CHECKING WITH N, CHECK WITH OPEN SO THAT ALL VALID WILL BE GENERATED
            generateParentheses(parenthesis+")", n, open, close+1);
    }
}
