package com.practice.algo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by prathap on 09/12/17.
 *
 * CS DOJO
 */
public class SubsetsInArray {
  public static void main(String args[]) {
    int[] a = {1,2,2};
    int[] temp = new int[a.length];
    recursiveSubset(a, temp, 0);
  }

  private static void recursiveSubset(int[] a, int[] temp, int i) {
    if(i==a.length) {
      printSubset(temp);
    } else {
      temp[i] = 0;
      recursiveSubset(a, temp, i+1);
      temp[i] = a[i];
      recursiveSubset(a, temp, i+1);
    }
  }

  private static void printSubset(int[] subset) {
    for(int i=0; i<subset.length; i++) {
      System.out.print(subset[i] + ",");
    }
    System.out.println();
  }
}
