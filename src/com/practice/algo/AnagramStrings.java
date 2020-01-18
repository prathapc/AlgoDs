package com.practice.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prathap on 12/07/17.
 */
public class AnagramStrings {

  public static void main(String[] args) {
    //areAnagrams();
    //delteCharsToMakeStringsAnagrams();
    findAllAnagramsInString("cbaebabacd", "abc");
  }

  private static void areAnagrams() {
    String str1 = "LISTEN";
    String str2 = "SILENT";
    if(str1.length() != str2.length()) {
      System.out.println("Not anagrams");
      return;
    }
    int[] str1CharCount = new int[256];
    int[] str2CharCount = new int[256];
    for(int i=0; i<str1.length(); i++) {
      str1CharCount[str1.charAt(i)] += 1;
      str2CharCount[str2.charAt(i)] += 1;
    }

    for(int j=0; j<256; j++) {
      if(str1CharCount[j] != str2CharCount[j]) {
        System.out.println("Not anagrams");
        return;
      }
    }
    System.out.println("anagrams");
  }

  /**
   * how many min no of characters to be deleted to make two strings anagrams.
   */
  private static void delteCharsToMakeStringsAnagrams() {
    String first="abc", second="pqr";
    int[] firstCharCount = new int[26];
    int[] secondCharCount = new int[26];
    for(int i=0; i<first.length(); i++) {
      firstCharCount[first.charAt(i) - 'a'] += 1;
    }
    for(int i=0; i<second.length(); i++) {
      secondCharCount[second.charAt(i) - 'a'] += 1;
    }

    int result = 0;
    for(int i=0; i<26; i++) {
      result += Math.abs(firstCharCount[i] - secondCharCount[i]);
    }
    System.out.print(result);
  }

  private static List<Integer> findAllAnagramsInString(String s, String p) {
    Map<Character, Integer> m = new HashMap<>();
    for (char c : p.toCharArray())
      m.put(c, m.getOrDefault(c, 0) + 1);

    int fast = 0, slow = 0, diff = m.size();
    List<Integer> res = new ArrayList<>();
    while(fast < s.length()) {
      char c = s.charAt(fast++);
      if(m.containsKey(c)){
        if (m.get(c) - 1 == 0)
          diff--;
        m.put(c, m.get(c) - 1 );
      }
      if (fast >  p.length()) {
        char d = s.charAt(slow++);
        if (m.containsKey(d)){
          if (m.get(d) == 0)
            diff++;
          m.put(d, m.get(d) + 1);
        }
      }
      if (diff == 0)
        res.add(slow);
    }
    return res;
  }
}
