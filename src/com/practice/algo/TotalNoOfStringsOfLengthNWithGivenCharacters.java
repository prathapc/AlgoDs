package com.practice.algo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by prathap on 05/08/17.
 */
public class TotalNoOfStringsOfLengthNWithGivenCharacters {
  public static void main(String[] args) {
    int n = 3;
    char[] chars = {'a', 'a', 'a', 'b', 'c', 'c'};
    System.out.println(count(chars, n));
  }

  private static int count(char[] charRepeat, int n) {
    Set<String> result = new LinkedHashSet<>();

    for(int i=0; i<charRepeat.length; i++) {
      for(int j=0; j<charRepeat.length; j++) {
        for(int k=0; k<charRepeat.length; k++) {
          if(i!=j && j!= k && k!=i)
            result.add(charRepeat[i]+""+charRepeat[j]+""+charRepeat[k]+"");
        }
      }
    }

    for(String str : result) {
      System.out.println(str);
    }

    return result.size();
  }
}
