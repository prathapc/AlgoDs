package com.practice.algo.strings;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
//TODO
public class SmallestWindowInStringContainingCharsOfOtherString {

  public static void main(String[] args) {

    String s = "ADOBECODEBANC";
    String t = "ABC";            //Output:- toprac
    int[] map = new int[128];

    // Init the map with the frequency of character in t;
    // For those characters in s not in t, its frequency is 0;
    for (char c : t.toCharArray()) {
      map[c]++;
    }

    // "count“ means the total number we need to reach.
    int count = t.length();

    // right pointer and left pointer
    int r = 0, l = 0;

    int length = s.length();

    // Init minLen as larger than the max length of s
    int minLen = length + 1;

    // The start index of our result
    int start = 0;

    while (r < length) {
      char c = s.charAt(r);

      // If the frequency is greater than 0, meaning we reach a character in t
      if (map[c] > 0) {
        count--; // Reduce the number of characters that we need to reach
      }

      // Even if the character is not greater than 0, the frequency still need to be reduce.
      // Meaning we are just borrowing it, and we will give it back.
      map[c]--;

      // When count equals to 0, meaning we have met all the characters in t
      while (count == 0) {
        c = s.charAt(l);

        // If the frequency of character at left pointer is greater or equals to 0, meaning our left pointer is at a character in t,
        // as the two ends of the shortest substring are always characters in t.
        if (map[c] >= 0) {
          // update minLen
          if (r - l + 1 < minLen) {
            minLen = r - l + 1;
            start = l;
          }
          // Add 1 to count, as left pointer is leaving the character in t; Let it could be reached by right pointer.
          count++;
        }

        // Add 1 to the frequency of character pointed by left pointer;
        // For characters not in t, this means we are giving back the frequency that we "borrowed" previously.
        // For characters in t, this means allow the right pointer to reach the character and reduce "count" again.
        map[c]++;

        // Move left pointer
        l++;
      }
      // Move right pointer
      r++;
    }
    System.out.println(minLen == length + 1 ? "" : s.substring(start, start + minLen));
  }
}