package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by prathapchowdary on 02/01/22.
 *
 * Input: "()))(("
 * Output: 4
 *
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class E_MinAddToMakeValidParentheses {

    //solved in 2mins, beats 100% :)
    public int minAddToMakeValid(String s) {
        int minAdd = 0, open = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') open++;
            else {
                if (open > 0) open--;
                else minAdd++;
            }
        }
        return minAdd + open;
    }

    public int minAddToMakeValid_stack(String s) {
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
