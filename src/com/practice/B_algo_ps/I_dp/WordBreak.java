package com.practice.B_algo_ps.I_dp;

import java.util.*;

/**
 * Created by prathap on 06/10/17.
 *
 * Given an input string and a dictionary of words,
 * find out if the input string can be segmented into
 * a space-separated sequence of dictionary words
 */
public class WordBreak {

  public static void main(String args[]) {
    String dictionary[] = { "i", "like", "sam", "samsung", "mobile", "ice",
        "cream", "icecream", "man", "go", "mango"};
    String word = "ilikesamsung";

    System.out.print(wordBreak_recursion(word, Arrays.asList(dictionary)));
    System.out.print(wordBreak_dp(word, Arrays.asList(dictionary)));
  }

  private static boolean wordBreak_recursion(String s, List<String> wordDict) {
    return wordBreakUtil_recursion(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
  }

  private static boolean wordBreakUtil_recursion(String s, int start, Set<String> wordDict, Boolean[] memo) {
    if (start == s.length()) {
      return true;
    }
    if (memo[start] != null) {
      return memo[start];
    }
    for (int end=start+1; end<=s.length(); end++) {
      if (wordDict.contains(s.substring(start, end)) && wordBreakUtil_recursion(s, end, wordDict, memo)) {
        return memo[start] = true;
      }
    }
    return memo[start] = false;
  }

  private static boolean wordBreak_dp(String s, List<String> wordDict) {
    return wordBreakUtil_dp(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
  }

  private static boolean wordBreakUtil_dp(String s, int start, Set<String> wordDict, Boolean[] memo) {
    if (start == s.length()) {
      return true;
    }
    if (memo[start] != null) {
      return memo[start];
    }
    for (int end=start+1; end<=s.length(); end++) {
      if (wordDict.contains(s.substring(start, end)) && wordBreakUtil_dp(s, end, wordDict, memo)) {
        return memo[start] = true;
      }
    }
    return memo[start] = false;
  }
}
