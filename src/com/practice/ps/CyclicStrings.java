package com.practice.ps;

/**
 * Given a list/array of names(String) sort them such that each name is followed by a name which starts with the last character of the previous name.
 # input
 [
 Luis
 Hector
 Selena
 Emmanuel
 Amish
 ]

 # output:
 [
 Emmanuel
 Luis
 Selena
 Amish
 Hector
 ]
 * Created by prathap on 13/07/17.
 */
public class CyclicStrings {

  public static void main(String[] args) {
    String input[] = {"Luis","Hector","Selena","Emmanuel","Amish"};
    int endIndex = findEndingString(input);
    if(endIndex != -1) {
      findCyclicOrderOfStrings(input, endIndex);
    }
  }

  private static void findCyclicOrderOfStrings(String input[], int endIndex) {
    System.out.println(input[endIndex]);
    int i = 0;
    while(i < input.length) {
      if(i == endIndex || input[i] == null) continue;
      if(Character.toLowerCase(input[endIndex].charAt(0)) == Character.toLowerCase(input[i].charAt(input[i].length()-1))) {
        System.out.println(input[endIndex]);
        input[endIndex] = null;
        endIndex = i;
        i=0;
      }
      i++;
    }
  }

  private static int findEndingString(String input[]) {
    for(int i=0; i<input.length; i++) {
      for(int j=0; j<input.length; j++) {
        if(i==j) continue;
        if(Character.toLowerCase(input[i].charAt(input[i].length()-1)) == Character.toLowerCase(input[j].charAt(0))) {
          break;
        }
        if(j == input.length-1) {
          return i;
        }
      }

    }
    return -1;
  }
}
