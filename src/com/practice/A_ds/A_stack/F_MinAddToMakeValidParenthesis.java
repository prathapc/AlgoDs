package com.practice.A_ds.A_stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

/**
 * Created by prathapchowdary on 02/01/22.
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * Input: "()))(("
 * Output: 4
 */
public class F_MinAddToMakeValidParenthesis {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    //stack.push()
                    res++;
                } else {
                    stack.pop();
                }
            }
        }
        res += stack.size();
        return res;
    }

    public int minAddToMakeValid1(String s) {
        Stack<Character> stack = new Stack();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.size();
    }

    //another easy way
    public int minAddToMakeValid2(String S) {
        while(S.contains("()")) {
            S= S.replace("()","");
        }
        return S.length();
    }
}
