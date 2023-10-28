package com.practice.A_ds.A_stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
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
public class G_LongestValidParentheses_ {

    public static void main(String args[]) {
        System.out.println(longestValidParentheses(")()())"));
    }

    //O(n^2) - beats 5%
    public int longestValidParentheses2(String s) {
        int open;
        int max = 0;
        for (int start = 0; start < s.length(); start++) {
            open = 0;
            for (int end = start; end < s.length(); end++) {
                if (s.charAt(end) == '(') {
                    open++;
                } else {
                    open--;
                }
                if (open < 0) {
                    break;

                }
                if (open == 0) {
                    max = Math.max(max, end-start+1);
                }
            }
        }
        return max;
    }

    // explanation
    // https://leetcode.com/problems/longest-valid-parentheses/solutions/1938107/java-stack-and-dp-solution-with-explanation/
    public static int longestValidParentheses(String s) {
        int r = 0;
        int currentLength = 0;
        int lastCloseBracket = -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()){
                    lastCloseBracket = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        currentLength = i - lastCloseBracket;
                    }else{
                        currentLength = i - stack.peek();
                    }
                    r = Math.max(currentLength,r);
                }
            }
        }
        return r;
    }

    // explanation
    //https://leetcode.com/problems/longest-valid-parentheses/solutions/1938107/java-stack-and-dp-solution-with-explanation/
    public int longestValidParentheses_1(String s) {
        int[] dp = new int[s.length()];
        int r = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }else{
                if(s.charAt(i-1) == '('){
                    dp[i] = i >= 2 ? 2 + dp[i - 2] : 2;
                }else if(i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = 2 + dp[i-1] + (i - dp[i-1] - 1 > 0 ? dp[i - dp[i-1] - 2] : 0);
                }
            }
            r = Math.max(r, dp[i]);
        }
        return r;
    }



    //bfs and dp - similar to longest valid palindrome
    //Not fully correct : 218 / 231 testcases passed
    public int longestValidParentheses_bfs(String s) {
        if (s.length() <= 1) return 0;
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{0, s.length()-1});
        Set<String> seenParentheses = new HashSet<>();
        String maxParentheses = "";
        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            if (!seenParentheses.contains(s.substring(curr[0], curr[1]+1))) {
                if(isValid(s, curr[0], curr[1])) {
                    if (maxParentheses.length() < (curr[1]-curr[0]+1)) {
                        maxParentheses = s.substring(curr[0], curr[1]+1);
                    }
                } else {
                    seenParentheses.add(s.substring(curr[0], curr[1]+1));
                    bfs.add(new int[]{curr[0], curr[1]-1});
                    bfs.add(new int[]{curr[0]+1, curr[1]});
                }
            }
        }
        return maxParentheses.length();
    }
    private boolean isValid(String s, int start, int end) {
        Stack<Character> stack = new Stack<>();
        for (int i=start; i<=end; i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
