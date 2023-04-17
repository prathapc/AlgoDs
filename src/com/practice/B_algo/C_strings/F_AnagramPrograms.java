package com.practice.B_algo.C_strings;

import java.util.*;

/**
 * Created by prathap on 12/07/17.
 */
public class F_AnagramPrograms {

  public static void main(String[] args) {
    areAnagrams();
    deleteCharsToMakeStringsAnagrams();
    groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    findAllAnagramsInString("cbaebabacd", "abc"); //output:- [0, 6]
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
      str1CharCount[str1.charAt(i)]++;
      str2CharCount[str2.charAt(i)]++;
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
  private static void deleteCharsToMakeStringsAnagrams() {
    String first="abc", second="pqr";
    int[] firstCharCount = new int[26];
    int[] secondCharCount = new int[26];
    for(int i=0; i<first.length(); i++) {
      firstCharCount[first.charAt(i) - 'a']++;
    }
    for(int i=0; i<second.length(); i++) {
      secondCharCount[second.charAt(i) - 'a']++;
    }

    int result = 0;
    for(int i=0; i<26; i++) {
      result += Math.abs(firstCharCount[i] - secondCharCount[i]);
    }
    System.out.print(result);
  }

  //Time O(NKlogK)
  //Space O(NK)
  private static List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) return new ArrayList();
    Map<String, List> ans = new HashMap<String, List>();
    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String key = String.valueOf(ca);
      if (!ans.containsKey(key)) ans.put(key, new ArrayList());
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

  //https://leetcode.com/problems/find-all-anagrams-in-a-string/
  public static List<Integer> findAllAnagramsInString(String s, String p) {
    int ns = s.length(), np = p.length();
    if (ns < np) return new ArrayList<>();
    int[] pCount = new int[26];
    int[] sCount = new int[26];
    for (char ch : p.toCharArray()) {
      pCount[(int) (ch-'a')]++;
    }

    List<Integer> output = new ArrayList<>();
    for (int i=0; i<ns; i++) {
      sCount[(int) (s.charAt(i)-'a')]++;
      if (i>=np) {
        sCount[(int) (s.charAt(i-np)-'a')]--;
      }

      if (Arrays.equals(pCount, sCount)) {
        output.add(i-np+1);
      }
    }
    return output;
  }
}
