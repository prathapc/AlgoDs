package com.practice.algo;

/**
 * Created by prathap on 28/12/17.
 *
 * SLIDING WINDOW TECHNIQUE
 *
 */
public class LongestSubArrayWithSumK {
  public static void main(String args[]) {
    //int a[] = {10, 5, 2, 7, 1, 9};
    int a[] = {10, 5, 2, 7, 1, 9};
    int k = 15;
    int sum = 0;
    int c = 0;
    int start = 0;
    int result = -1;
    int i=0;
    while(i<a.length && start<a.length) {
      sum += a[i];
      c++;
      if(sum == k) {
        if(result < c) {
          result = c;
        }
      } else if(sum > k) {
        sum = sum-a[start];
        start++;
        c--;
        if(sum == k) {
          if(result < c) {
            result = c;
          }
        }
      }
      i++;
    }
    System.out.print(result);
  }
}
