package com.practice.algo;

/**
 * Created by prathap on 06/01/18.
 */
public class PermutationsOfGivenString {
  public static void main(String[] args) {
    String str = "ABC";
    permute(str, 0, str.length()-1);
  }

  private static void permute(String str, int l, int r) {
    if(l == r) {
      System.out.println(str);
    } else {
      for(int i=l; i<=r; i++) {
        str = swap(str, l, i);
        permute(str, l+1, r);
        str = swap(str, l, i);
      }
    }
  }

  private static String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i] ;
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }
}
