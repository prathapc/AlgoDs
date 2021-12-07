package com.practice.C_ps;

/**
 * Created by Prathap on 09 Nov, 2019
 *
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * sol: https://www.youtube.com/watch?v=l3hda49XcDE
 *
 * a.b -> any single char in between a and b  ==> acb is valid and ab is invalid
 * a*b -> 0 or more chars of a before b       ==> b, ab, aab are valid and acb, cb are invalid
 * a.*b -> 0 or more ANY char (.) between a and b ==> ab, acb are valid and b, a are invalid
 */
public class P10_RegularExpressionMatching {

    public static void main(String args[]) {
        String s = "mississippi"; //"mississippi" is invalid and "mississppi" is valid
        String p = "mis*is*p*.";
        //String s = "b";
        //String p = "a*b";
        System.out.println(isMatch(s, p));
    }

    /*
    T[i][j] =>
    case 1: if s[i] == p[j] OR p[j] == '.' then T[i-1][j-1]
    case 2: if p[j] == '*' then
            case 1: T[i][j-2]   //0 occurances
            case 2: if s[i] == p[j-1] OR p[j-1] == '.' then T[i-1][j]  //one or more of prev char occurances
     */
    public static boolean isMatch(String s, String p) {
        if(p.length() == 0 && s.length() == 0) {
            return true;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        //if s is empty case
        //for patterns like a* or a*b* its true for any string because * tells zero or more occurrences of prev char
        for(int i = 2; i <= p.length(); i++) {
            char pc = p.charAt(i - 1);
            dp[0][i] = dp[0][i - 2] && pc == '*';
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
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
