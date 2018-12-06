package com.practice.algo;

import java.util.Map;
import java.util.TreeMap;

public class PalindromePromgrams {

  public static void main(String args[]) {
    distinctPalindromicStubStrings("abaaa");

    String str = "abaab";
    countPalindromicSubStrings(str.toCharArray(), str.length());

    System.out.print(longestPalindromeRecursion("aabaacd"));
    System.out.print(longestPalindromeDp("ccc"));

    distinctPalindromicStubStringsDp("abaaa");
  }

  private static void distinctPalindromicStubStringsDp(String abaaa) {


  }

  //https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
  // This function prints the longest palindrome substring
  // of str[].
  // It also returns the length of the longest palindrome
  static int longestPalindromeDp(String str) {
    int n = str.length();   // get length of input string

    // table[i][j] will be false if substring str[i..j]
    // is not palindrome.
    // Else table[i][j] will be true
    boolean table[][] = new boolean[n][n];

    // All substrings of length 1 are palindromes
    int maxLength = 1;
    for (int i = 0; i < n; i++)
      table[i][i] = true;

    // check for sub-string of length 2.
    int start = 0;
    for (int i = 0; i < n - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        table[i][i + 1] = true;
        start = i;
        maxLength = 2;
      }
    }

    // Check for lengths greater than 2. k is length
    // of substring
    for (int k = 3; k <= n; k++) {

      // Fix the starting index
      for (int i = 0; i < n - k + 1; i++)
      {
        // Get the ending index of substring from
        // starting index i and length k
        int j = i + k - 1;

        // checking for sub-string from ith index to
        // jth index iff str.charAt(i+1) to
        // str.charAt(j-1) is a palindrome
        if (table[i + 1][j - 1] && str.charAt(i) ==
            str.charAt(j)) {
          table[i][j] = true;

          if (k > maxLength) {
            start = i;
            maxLength = k;
          }
        }
      }
    }
    System.out.print("Longest palindrome substring is; ");
    printSubStr(str, start, start + maxLength - 1);

    return maxLength; // return length of LPS
  }

  static void printSubStr(String str, int low, int high) {
    System.out.println(str.substring(low, high + 1));
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

  private static void countPalindromicSubStrings(char str[], int n) {
    // creat empty 2-D matrix that counts all palindrome
    // substring. dp[i][j] stores counts of palindromic
    // substrings in st[i..j]
    int dp[][] = new int[n][n];

    // P[i][j] = true if substring str[i..j] is palindrome,
    // else false
    boolean P[][] = new boolean[n][n];

    // palindrome of single lenght
    for (int i= 0; i< n; i++)
      P[i][i] = true;

    // palindrome of length 2
    for (int i=0; i<n-1; i++)
    {
      if (str[i] == str[i+1])
      {
        P[i][i+1] = true;
        dp[i][i+1] = 1 ;
      }
    }

    // Palindromes of length more then 2. This loop is similar
    // to Matrix Chain Multiplication. We start with a gap of
    // length 2 and fill DP table in a way that gap between
    // starting and ending indexes increases one by one by
    // outer loop.
    for (int gap=2 ; gap<n; gap++)
    {
      // Pick starting point for current gap
      for (int i=0; i<n-gap; i++)
      {
        // Set ending point
        int j = gap + i;

        // If current string is palindrome
        if (str[i] == str[j] && P[i+1][j-1] )
          P[i][j] = true;

        // Add current palindrome substring ( + 1)
        // and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
        // remove common palinrome substrings (- dp[i+1][j-1])
        if (P[i][j] == true)
          dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
        else
          dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
      }
    }

    // return total palindromic substrings
    System.out.println(dp[0][n-1]);
  }

  private static void distinctPalindromicStubStrings(String s) {
    //map<string, int> m;
    TreeMap<String , Integer> m = new TreeMap<>();
    int n = s.length();

    // table for storing results (2 rows for odd-
    // and even-length palindromes
    int[][] R = new int[2][n+1];

    // Find all sub-string palindromes from the
    // given input string insert 'guards' to
    // iterate easily over s
    s = "@" + s + "#";

    for (int j = 0; j <= 1; j++)
    {
      int rp = 0;   // length of 'palindrome radius'
      R[j][0] = 0;

      int i = 1;
      while (i <= n)
      {
        //  Attempt to expand palindrome centered
        // at i
        while (s.charAt(i - rp - 1) == s.charAt(i +
            j + rp))
          rp++;  // Incrementing the length of
        // palindromic radius as and
        // when we find vaid palindrome

        // Assigning the found palindromic length
        // to odd/even length array
        R[j][i] = rp;
        int k = 1;
        while ((R[j][i - k] != rp - k) && (k < rp))
        {
          R[j][i + k] = Math.min(R[j][i - k],
              rp - k);
          k++;
        }
        rp = Math.max(rp - k,0);
        i += k;
      }
    }

    // remove 'guards'
    s = s.substring(1, s.length()-1);

    // Put all obtained palindromes in a hash map to
    // find only distinct palindromess
    m.put(s.substring(0,1), 1);
    for (int i = 1; i < n; i++)
    {
      for (int j = 0; j <= 1; j++)
        for (int rp = R[j][i]; rp > 0; rp--)
          m.put(s.substring(i - rp - 1,  i - rp - 1
              + 2 * rp + j), 1);
      m.put(s.substring(i, i + 1), 1);
    }

    // printing all distinct palindromes from
    // hash map
    System.out.println("Below are " + (m.size())
        + " palindrome sub-strings");

    for (Map.Entry<String, Integer> ii:m.entrySet())
      System.out.println(ii.getKey());
  }

}
