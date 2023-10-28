package com.practice.B_algo_ps.B_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class E_SmallestWindowInStringContainingCharsOfOtherString_ {

  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(minWindow(s, t));
  }

  public static String minWindow(String s, String t) {
    int[] tMap = new int[128];
    for (char ch : t.toCharArray()) tMap[ch]++;

    int count = t.length(), minStart = 0, minLength = Integer.MAX_VALUE, start=0, end=0;
    for (; end < s.length(); end++) {
      if (tMap[s.charAt(end)] > 0) count--;
      tMap[s.charAt(end)]--;

      while (count == 0) {
        if (minLength > end-start+1) {
          minLength = end-start+1;
          minStart = start;
        }

        tMap[s.charAt(start)]++;
        if (tMap[s.charAt(start)] > 0) {
          count++;
        }
        start++;
      }
    }
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
  }

  private static String minWindow1(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();

    for (char x : t.toCharArray()) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }

    int matched = 0;
    int start = 0;
    int minLen = s.length() + 1;
    int subStr = 0;
    for (int endWindow = 0; endWindow < s.length(); endWindow++) {
      char right = s.charAt(endWindow);
      if (map.containsKey(right)) {
        map.put(right, map.get(right) - 1);
        if (map.get(right) == 0) matched++;
      }

      while (matched == map.size()) {
        if (minLen > endWindow - start + 1) {
          minLen = endWindow - start + 1;
          subStr = start;
        }
        char deleted = s.charAt(start++);
        if (map.containsKey(deleted)) {
          if (map.get(deleted) == 0) matched--;
          map.put(deleted, map.get(deleted) + 1);
        }
      }
    }
    return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
  }
}