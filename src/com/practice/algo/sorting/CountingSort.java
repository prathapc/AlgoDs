package com.practice.algo.sorting;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by prathap on 12/02/18.
 */
public class CountingSort {

  public static void main(String args[]) {
    int a[] = {9,4,10,8,2,4};
    int min = findMin(a);
    int max = findMax(a);

    //count[] = {1,0,2,0,0,0,1,1,1}
    int count[] = new int[max-min+1];
    for (int i=0; i<a.length; i++) {
      count[a[i] - min]++;
    }

    //count[] = {1,1,3,3,3,3,4,5,6}
    //here count array tells index of the element in output array
    for (int i=1; i<count.length; i++) {
      count[i] = count[i-1]+count[i];
    }

    int output[] = new int[a.length];

    //output = {2,4,4,8,9,10}
    for (int i=0; i<a.length; i++) {
      int k = count[a[i]-min];
      output[k-1] = a[i];
      count[a[i]-min] = k-1;
    }

    System.out.println(Arrays.toString(output));
  }

  private static int findMin(int[] a) {
    int min = Integer.MAX_VALUE;
    for(int i=0; i<a.length; i++) {
      if(a[i] < min) {
        min = a[i];
      }
    }
    return min;
  }

  private static int findMax(int[] a) {
    int max = Integer.MIN_VALUE;
    for(int i=0; i<a.length; i++) {
      if(a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }
}
