package com.practice.algo.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by prathap on 06/10/17.
 *
 * Given an input string and a dictionary of words,
 * find out if the input string can be segmented into
 * a space-separated sequence of dictionary words
 */
public class WordBreak {

  public static void main(String args[]) {
    String dictionary[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice",
        "cream", "icecream", "man", "go", "mango"};
    String word = "ilikesamsung";

    //System.out.print(wordBreakUtil_recursion(word, dictionary));

    //System.out.print(wordBreakUtil_dp(word, dictionary));

    System.out.print(wordBreakBottomUp(word, Arrays.asList(dictionary)));

  }

  private static boolean wordBreakUtil_recursion(String word, String[] dictionary) {

    int size = word.length();

    if (size == 0) {
      return true;
    }

    for (int i=1; i<=size; i++) {
      if (dictionaryContains(word.substring(0, i), dictionary)
          && wordBreakUtil_recursion(word.substring(i, size), dictionary)) {
        return true;
      }
    }
    return false;
  }

  private static boolean wordBreakUtil_dp(String word, String[] dictionary) {
    boolean dp[][] = new boolean[word.length()][word.length()];
    for (int i=0; i<word.length(); i++) {
      for (int j=0; j<word.length(); j++) {
        if (dictionaryContains(word.substring(i, j), dictionary)) {
          dp[i][j] = true;
        } else {
          if (i != j) {
            if (dictionaryContains(word.substring(i, j), dictionary) && dp[i][i/2] && dp[i/2][j]) {
              dp[i][j] = true;
            }
          }
        }
      }
    }
    return dp[word.length()-1][word.length()-1];
  }

  private static boolean dictionaryContains(String word, String[] dictionary) {
    for (int i = 0; i < dictionary.length; i++) {
      if (dictionary[i].equals(word)) {
        return true;
      }
    }
    return false;
  }

  private static boolean wordBreakBottomUp(String s, List<String> wordList) {
    boolean[] T = new boolean[s.length() + 1];
    Set<String> set = new HashSet<>();
    for (String word : wordList) {
      set.add(word);
    }
    T[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if(T[j] && set.contains(s.substring(j, i))) {
          T[i] = true;
          break;
        }
      }
    }
    return T[s.length()];
  }
}
