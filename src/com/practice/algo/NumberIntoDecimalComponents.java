package com.practice.algo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prathap on 07/11/17.
 */
public class NumberIntoDecimalComponents {

  public static void main(String args[]) {
    int n = 025;
    getDecimalComponentsFromInteger(n);
    //System.out.print(Arrays.toString(getDecimalComponentsFromInteger(n).toArray()));
  }

  private static List<Integer> getDecimalComponentsFromInteger(int n) {
    String str = String.valueOf(n);
    int length = str.length()-1;
    List<Integer> resultList = new ArrayList<>();
    for(int i=0; i<str.length(); i++) {
      Double decimalComponent = Character.getNumericValue(str.charAt(i)) * Math.pow(10, length-i);
      if(decimalComponent > 0)
        resultList.add(decimalComponent.intValue());
    }

    int size = resultList.size();
    int[] result = new int[size];
    int i=0;
    for(Integer d : resultList) {
      result[i++] = d;
    }
    System.out.print(Arrays.toString(result));



    return resultList;
  }

  @Test
  private void testValidCase() {

  }
}
