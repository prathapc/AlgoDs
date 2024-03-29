package com.practice.A_ds.A_stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Prathap on 26 Jan, 2020
 * <p>
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 */
public class E_MinRemoveToMakeValidParentheses {

    //solved in 15mins; similar to minAddParantheses solution
    //find invalid close parantheses from beginning to end in first iteration
    //find invalid open parantheses from end to beginnning in next iteration
    //build solution excluding invlaid ones from above steps in next iteration
    public String minRemoveToMakeValid_(String s) {
        int open = 0;
        Set<Integer> toRemoveIndex = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') open++;
            else if (ch == ')') {
                if (open > 0) open--;
                else toRemoveIndex.add(i);
            }
        }
        int close = 0;
        if (open > 0) {
            for (int i=s.length()-1; i>=0; i--) {
                char ch = s.charAt(i);
                if  (ch == ')') close++;
                else if (ch == '(') {
                    if (close > 0) close--;
                    else toRemoveIndex.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (!toRemoveIndex.contains(i)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //build toRemoveIndex with indexes of invalid chars in string
    //two cases: stack is empty and close parenthesis came in and second is left over open parenthesis in stack
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> toRemoveIndex = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    toRemoveIndex.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            toRemoveIndex.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemoveIndex.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    // elegant solution with out stack
    public String minRemoveToMakeValid1(String s) {
        int open = 0;
        StringBuilder result = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (c == ')' && open == 0)
                continue;
            if (c == '(')
                open++;
            else if (c == ')')
                open--;
            result.append(c);
        }
        while (open-- > 0)
            result.deleteCharAt(result.lastIndexOf("("));
        return result.toString();
    }
}
