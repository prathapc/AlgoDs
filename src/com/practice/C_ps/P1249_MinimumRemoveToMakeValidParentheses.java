package com.practice.C_ps;

/**
 * Created by Prathap on 26 Jan, 2020
 *
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 *
 */
public class P1249_MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder result = new StringBuilder(s.length());
        for(char c : s.toCharArray()){
            if (c == ')' && open == 0)
                continue;
            if ( c == '(' )
                open++;
            else if (c == ')')
                open--;
            result.append(c);
        }
        while(open -- > 0)
            result.deleteCharAt(result.lastIndexOf( "(" ) );
        return result.toString();
    }
}
