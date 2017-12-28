package com.practice.codility;

import com.practice.util.Utility;

/**
 * Created by prathap on 07/10/17.
 */
public class PartitionArray {

  public static void main(String args[]) {
    //int a[] = {5, -2, 3, 8, 6};
    //int a[] = {5, 1, 4, 3, 6, 8,10, 7, 9};
    int a[] = {-5, -5,-5, -42, 6, 12};
    System.out.print(solution1(a));
  }

  private static int solution1(int[] a) {
    int n = a.length;
    boolean b = false;
    int max = a[0], index = 0;
    for(int i=0; i<n; i++) {
      if(a[i] < max) {
        b = true;
      }
      if(a[i] > max && b) {
        max = a[i];
        index = i;
        b = false;
      }
      if(a[i] == max && i == n-1) {
        index = n;
      }
    }
    return index;
  }

  private static int solution(int[] a) {
    int result = -1;
    int max = a[0], pIndex = 0;

    int n = a.length;
    int leftMax[] = new int[n];
    leftMax[0] = Integer.MIN_VALUE;
    for(int i=1; i<n; i++) {
      leftMax[i] = Utility.max(leftMax[i-1], a[i-1]);
    }

    int rightMin = Integer.MAX_VALUE;
    for(int i=n-1; i>=0; i--) {
      if(leftMax[i] < a[i] && rightMin > a[i]) {
        return i;
      }
      rightMin = Utility.min(rightMin, a[i]);
    }
    return -1;
  }
}
