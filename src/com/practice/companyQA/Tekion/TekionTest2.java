package com.practice.companyQA.Tekion;

import java.util.Arrays;

/**
 *  Find pairs which add up to a number in an array .
 *  if input integer array is {2, 6, 3, 9, 7, 11} and given sum is 9, output should be {6,3} and {2,7} 
 */
public class TekionTest2 {
  public static void main(String[] args) {
    int a[] = {-1, 2, 6, 3, 9, 7, 11};
    int sum = 6;
    int len = a.length;
    Arrays.sort(a);
    //{2, 3, 6, 7, 9, 11}
    for (int i=0; i<len; i++) {
      if (i == len - 1) {
        break;
      }
      if (a[i] + a[len-1] == sum) {
        System.out.println("(" + a[i] + "," + a[len-1] + ")");
        len--;
        //i--;
      } else if (a[i] + a[len-1] > sum) {
        len--;
        i--;
      } else {
        //
      }
    }
  }
}
