package com.practice.B_algo_ps.B_strings;

public class G_PalindromePrograms {

  public static void main(String args[]) {
    /**
     * https://leetcode.com/problems/valid-palindrome/
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     */
    isPalindrome("aa,d,,,daa,,"); //true;

    /**
     * https://leetcode.com/problems/valid-palindrome-ii/
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     * Input: s = "aba"
     * Output: true
     */
    deleteAtmostNtoMakePalindrom("abc", 1);

    /**
     * https://leetcode.com/problems/palindromic-substrings/
     * Input: s = "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     */
    countPalindromeSubstrings("abaaa");
  }

  public static boolean isPalindrome1(String s) {
    s = s.toLowerCase();
    int start = 0, end = s.length()-1;
    while (start < end) {
      if (!Character.isLetterOrDigit(s.charAt(start)) || !Character.isLetterOrDigit(s.charAt(end))) {
        if (!Character.isLetterOrDigit(s.charAt(start))) {
          start++;
        }
        if (!Character.isLetterOrDigit(s.charAt(end))) {
          end--;
        }
        continue;
      }

      if (s.charAt(start++) != s.charAt(end--)) {
        return false;
      }
    }
    return true;
  }
  //another elegant solution is java8 streams
  public static boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    s.chars()
            .filter(c -> Character.isLetterOrDigit(c))
            .mapToObj(c -> Character.toLowerCase((char) c))
            .forEach(sb::append);
    return sb.toString().equals(sb.reverse().toString());
  }



  public static boolean deleteAtmostNtoMakePalindrom(String s, int delCount) {
    return deleteAtmostNtoMakePalindromUtil(s, 0, s.length()-1, delCount);
  }
  private static boolean deleteAtmostNtoMakePalindromUtil(String s, int start, int end, int delCount) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        if (delCount == 0) {
          return false;
        } else {
          return deleteAtmostNtoMakePalindromUtil(s, start, end-1, delCount-1) || deleteAtmostNtoMakePalindromUtil(s, start+1, end, delCount-1);
        }
      }
      start++;
      end--;
    }
    return true;
  }


  public static int countPalindromeSubstrings(String s) {
    int ans = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i=0; i<s.length(); i++) {
      dp[i][i] = true;
      ans++;
    }
    for (int i=0; i<s.length()-1; i++) {
      dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
      ans += (dp[i][i+1] ? 1 : 0);
    }
    for (int len=3; len<=s.length(); len++) {
      for (int i=0,j=i+len-1; j<s.length(); i++, j++) {
        dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
        ans += (dp[i][j] ? 1 : 0);
      }
    }

    return ans;
  }
}
