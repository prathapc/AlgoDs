package com.practice.B_algo_ps.K_sort_search_math.sort;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

import java.util.Arrays;

/**
 * Created by prathap on 17/02/18.
 */
public class A_BubbleSort {

  public static void main(String args[]) {
    int a[] = {23,12,56,45,78};
    System.out.println(Arrays.toString(a));
    int n = a.length;
    for (int i=0; i<n; i++) {
      for (int j=i+1; j<n; j++) {
        if (a[i] > a[j]) {
          Utility.swapElementsInArray(a, i, j);
        }
      }
    }
    System.out.println(Arrays.toString(a));
  }
}
