package com.practice.ps.leetcode;

/**
 * Created by Prathap on 09 Nov, 2019
 *
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * sol: https://www.youtube.com/watch?v=l3hda49XcDE
 */
public class P10_RegularExpressionMatching {

    public static void main(String args[]) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        //String s = "b";
        //String p = "a*b";
        System.out.println(isMatch(s, p));
    }

    //#copied #todo
    public static boolean isMatch(String s, String p) {
        if(p.length() == 0 && s.length() == 0) {
            return true;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        //if s is empty case
        //for patterns like a* or a*b* its true for any string bcz * tells zero or more occurrences of prev char
        for(int i = 2; i <= p.length(); i++) {
            char pc = p.charAt(i - 1);
            dp[0][i] = dp[0][i - 2] && pc == '*';
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                /*if(pc == '*') {
                    //never use * or use it at least once
                    dp[i][j] = dp[i][j - 2]|| (dp[i - 1][j] && (p.charAt(j - 2) == sc || p.charAt(j - 2) == '.'));
                } else if (sc == pc || pc == '.'){
                    //characters match
                    dp[i][j] = dp[i - 1][j - 1];
                }*/
                if (sc == pc || pc == '.'){
                    //characters match
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pc == '*') {
                    //never use * or use it at least once
                    dp[i][j] = dp[i][j - 2]|| (dp[i - 1][j] && (p.charAt(j - 2) == sc || p.charAt(j - 2) == '.'));
                }

            }
        }

        return dp[s.length()][p.length()];
    }

}
