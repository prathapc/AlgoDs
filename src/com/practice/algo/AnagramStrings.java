package com.practice.algo;

/**
 * Created by prathap on 12/07/17.
 */
public class AnagramStrings {

  public static void main(String[] args) {
    //areAnagrams();
    delteCharsToMakeStringsAnagrams();
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
}
