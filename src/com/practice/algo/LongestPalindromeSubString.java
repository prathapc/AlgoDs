package com.practice.algo;

/**
 * Created by prathap on 11/12/17.
 */
public class LongestPalindromeSubString {

  public static void main(String args[]) {
    System.out.print(longestPalindromeRecursion("aabaacd"));

    //TO-DO ;;  fill 1 then 2 then k length substring pal in matrix
    System.out.print(longestPalindromeDp("aabaacd"));
  }

  public static String longestPalindromeDp(String a) {

    return null;
  }


  public static String longestPalindromeRecursion(String a) {
    int start =0, end=a.length()-1;

    return longestPalindromeUtil(a, start, end);
  }
  private static String longestPalindromeUtil(String a, int start, int end) {
    if(start > end) {
      return "";
    }
    if(isPalindrome(a, start, end)) {
      return a.substring(start, end+1);
    } else {
      String s1 = longestPalindromeUtil(a, start+1, end);
      String s2 = longestPalindromeUtil(a, start, end-1);
      if(s1.length()>s2.length()){
        return s1;
      }
      else{
        return s2;
      }
    }
  }

  private static boolean isPalindrome(String a, int start, int end) {
    while(start < end) {
      if(a.charAt(start) != a.charAt(end)) {
        return false;
      }
      start=start+1;
      end=end-1;
    }
    return true;
  }
}
