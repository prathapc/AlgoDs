package com.practice.B_algo_ps.B_strings;

/**
 * Created by prathapchowdary on 24/07/23.
 *
 * Input: s = "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 *
 * https://leetcode.com/problems/count-binary-substrings/
 */
public class C_CountBinarySubstrings {

  /**
   * First, I count the number of 1 or 0 grouped consecutively.
   * For example "0110001111" will be [1, 2, 3, 4].
   *
   * Second, for any possible substrings with 1 and 0 grouped consecutively, the number of valid substring will be the minimum number of 0 and 1.
   * For example "0001111", will be min(3, 4) = 3, ("01", "0011", "000111")
   */
  public static int countBinarySubstrings(String s) {
    int cur = 1, pre = 0, res = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) cur++;
      else {
        res += Math.min(cur, pre);
        pre = cur;
        cur = 1;
      }
    }
    return res + Math.min(cur, pre);
  }

  //Approach : check if substring starting at curr location (starting from 0 to n) satisfies
  //TLE : 87/91 TC passed
  public int countBinarySubstrings1(String s) {
    if (s.length() <= 1) return 0;
    int start = 0, end = 0;
    int result = 0;
    for (int i=0; i<s.length(); i++) {
      start = i;
      char ch = s.charAt(start);
      while (start < s.length()-1 && s.charAt(++start) == ch);

      end = start;
      while (end < s.length() && s.charAt(end) != ch) {
        if (end-start+1 == start-i) {
          result++;
          break;
        }
        end++;
      }
    }
    return result;
  }

  public static void main(String args[]) {
    System.out.println(countBinarySubstrings("00110011"));
  }
}
