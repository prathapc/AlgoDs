package com.practice.B_algo_ps.D_recursion;

/**
 * Created by Prathap on 09 Nov, 2019
 *
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class E_RegularExpressionMatching_ {

    /**
     * Consider following example
     *
     * s='aab', p='c*a*b'
     *
     *       c * a * b
     *     0 1 2 3 4 5
     *   0 y
     * a 1
     * a 2
     * b 3
     * dp[i][j] denotes if s.substring(0,i) is valid for pattern p.substring(0,j). For example dp[0][0] == true (denoted by y in the matrix) because when s and p are both empty they match. So if we somehow base dp[i+1][j+1] on previos dp[i][j]'s then the result will be dp[s.length()][p.length()]
     *
     * So what about the first column? for and empty pattern p="" only thing that is valid is an empty string s="" and that is already our dp[0][0] which is true. That means rest of `dp[i][0]' is false.
     *
     * s='aab', p='c*a*b'
     *
     *       c * a * b
     *     0 1 2 3 4 5
     *   0 y
     * a 1 n
     * a 2 n
     * b 3 n
     * What about the first row? In other words which pattern p matches empty string s=""? The answer is either an empty pattern p="" or a pattern that can represent an empty string such as p="a*", p="z*" or more interestingly a combiation of them as in p="a*b*c*". Below for loop is used to populate dp[0][j]. Note how it uses previous states by checking dp[0][j-2]
     *
     *         for (int j=2; j<=p.length(); j++) {
     *             dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];
     *         }
     * At this stage our matrix has become as follows: Notice dp[0][2] and dp[0][4] are both true because p="c*" and p="c*a*" can both match an empty string.
     *
     * s='aab', p='c*a*b'
     *
     *       c * a * b
     *     0 1 2 3 4 5
     *   0 y n y n y n
     * a 1 n
     * a 2 n
     * b 3 n
     * So now we can start our main iteration. It is basically the same, we will iterate all possible s lengths (i) for all possible p lengths (j) and we will try to find a relation based on previous results. Turns out there are two cases.
     *
     * (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') if the current characters match or pattern has . then the result is determined by the previous state dp[i][j] = dp[i-1][j-1]. Don't be confused by the charAt(j-1) charAt(i-1) indexes using a -1 offset that is because our dp array is actually one index bigger than our string and pattern lenghts to hold the initial state dp[0][0]
     *
     * if p.charAt(j-1) == '*' then either it acts as an empty set and the result is dp[i][j] = dp[i][j-2] or (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') current char of string equals the char preceding * in pattern so the result is dp[i-1][j]
     *
     * So here is the final state of matrix after we evaluate all elements:
     *
     * s='aab', p='c*a*b'
     *
     *       c * a * b
     *     0 1 2 3 4 5
     *   0 y n y n y n
     * a 1 n n n y y n
     * a 2 n n n n y n
     * b 3 n n n n n y
     */
    public boolean isMatch_1(String t, String p) {
        if(p.isEmpty()) return t.isEmpty();
        boolean firstMatch = !t.isEmpty() &&
            (t.charAt(0) == p.charAt(0) || p.charAt(0)=='.');
        if(p.length()>=2 && p.charAt(1)=='*') {
            return isMatch_1(t, p.substring(2)) ||
                (firstMatch && isMatch_1(t.substring(1), p));
        } else {
            return firstMatch && isMatch_1(t.substring(1), p.substring(1));
        }
    }

    //other solution
    private boolean isMatch_2(int sIndex, int pIndex, String s, String p) {
        //boundary checking
        if (sIndex == s.length() || pIndex == p.length()) {
            if (sIndex == s.length() && pIndex == p.length())
                return true;
            //The following is used to check "aaaa", "aaaaa*a*"
            if (sIndex == s.length() && pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*')
                return isMatch_2(sIndex, pIndex + 2, s, p);
            //match failed
            return false;
        }
        //not match at current position, if no *, then match failed
        //Otherwise we can skip the current * in the regex and continue
        //to next match.
        if (s.charAt(sIndex) != p.charAt(pIndex) && p.charAt(pIndex) != '.') {
            //no *, match failed
            if (pIndex == p.length() - 1 || p.charAt(pIndex + 1) != '*')
                return false;
            //skip the *
            return isMatch_2(sIndex, pIndex + 2, s, p);
        }
        //match at current position, if no *, then continue to match the next
        //position both in text and regex.
        //Otherwise try to match one more chars and provide states for backtrack
        if (pIndex == p.length() - 1 || p.charAt(pIndex + 1) != '*')
            return isMatch_2(sIndex + 1, pIndex + 1, s, p);

        return isMatch_2(sIndex + 1, pIndex, s, p) || isMatch_2(sIndex, pIndex + 2, s, p);
    }

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
