package com.practice.B_algo_ps.I_dp;

import java.util.*;

/**
 * Created by prathap on 06/10/17.
 * <p>
 * Given an input string and a dictionary of words, find out if the input string can be segmented
 * into a space-separated sequence of dictionary words
 *
 * https://leetcode.com/problems/word-break/
 */
public class H_WordBreak {

  public static void main(String args[]) {

    System.out.print(wordBreak_bfs_dp("aaaaaa", Arrays.asList(new String[]{"aa", "a"})));

    //other ways
    String dictionary[] = {"i", "like", "sam", "samsung", "mobile", "ice",
        "cream", "icecream", "man", "go", "mango"};
    String word = "ilikesamsung";

    System.out.print(wordBreak(word, Arrays.asList(dictionary)));
    System.out.print(wordBreak(word, Arrays.asList(dictionary)));

  }

  public static boolean wordBreak(String s, List<String> wordDict) {
    Set<String> words = new HashSet<>(wordDict);
    Map<Integer, Boolean> dp = new HashMap<>();
    return wordBreakUtil(s, 0, words, dp);
  }

  //DP
  public static boolean wordBreakUtil(String s, int index, Set<String> words, Map<Integer, Boolean> dp) {
    if (s.length() == index) return true;
    if (dp.containsKey(index)) return dp.get(index);
    for (int i=index+1; i<=s.length(); i++) {
      if (words.contains(s.substring(index, i)) && wordBreakUtil(s, i, words, dp)) {
        dp.put(index, true);
        return true;
      }
    }
    dp.put(index, false);
    return false;
  }

  //recursion
  private static boolean wordBreakUtil(String s, int index, Set<String> words) {
    if (s.length() == index) return true;
    for (int i=index+1; i<=s.length(); i++) {
      if (words.contains(s.substring(index, i)) && wordBreakUtil(s.substring(i), index, words)) {
        return true;
      }
    }
    return false;
  }

  public static boolean wordBreak_bfs_dp(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet<>(wordDict);
    Queue<String> bfs = new LinkedList<>();
    Set<String> seen = new HashSet<>();
    bfs.add(s);
    while (!bfs.isEmpty()) {
      String curr = bfs.poll();
      if (wordDictSet.contains(curr)) return true;
      if (seen.contains(curr)) continue;
      seen.add(curr);

      String temp = "";
      for (int i=0; i<curr.length(); i++) {
        temp += curr.charAt(i);
        if (wordDictSet.contains(temp)) {
          if (i == curr.length()-1) return true;
          bfs.add(curr.substring(i+1));
        }
      }
    }
    return false;
  }
}
