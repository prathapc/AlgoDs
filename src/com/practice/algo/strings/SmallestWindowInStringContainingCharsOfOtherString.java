package com.practice.algo.strings;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SmallestWindowInStringContainingCharsOfOtherString {

  public static void main(String[] args) {

    String s = "ADOBECODEBANC";
    String t = "ABC";            //Output:- toprac

    Set<Character> chars = new HashSet<>();
    for (int i=0; i<t.length(); i++) {
      chars.add(t.charAt(i));
    }

    Map<Character, Integer> sortedCharOccurances = new TreeMap<>();
    String result = s;
    for (int i=0; i<s.length(); i++) {
      if (chars.contains(s.charAt(i))) {
        sortedCharOccurances.put(s.charAt(i), i);
        if (sortedCharOccurances.size() == chars.size()) {
          int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
          for (Map.Entry<Character, Integer> entry : sortedCharOccurances.entrySet()) {
            if (entry.getValue() > max) {
              max = entry.getValue();
            }
            if (entry.getValue() < min) {
              min = entry.getValue();
            }
          }
          //Map.Entry<Character, Integer> firstEntry = ((TreeMap<Character, Integer>) sortedCharOccurances).firstEntry();
          //Map.Entry<Character, Integer> lastEntry = ((TreeMap<Character, Integer>) sortedCharOccurances).lastEntry();
          String temp = s.substring(min, max+1);
          if (temp.length() < result.length()) {
            result = temp;
          }
        }
      }
    }
    System.out.println(result);
  }

  private static int subStringWithAllChars(String s, Set<Character> chars) {
    for (int i=0; i<s.length(); i++) {
      if (chars.isEmpty()) {
        return i;
      }
      if (chars.contains(s.charAt(i))) {
        chars.remove(s.charAt(i));
      }
    }
    return 0;
  }
}
