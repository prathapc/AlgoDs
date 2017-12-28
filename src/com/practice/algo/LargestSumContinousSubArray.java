package com.practice.algo;

/**
 * Created by prathap on 02/09/17.
 */

/**
 * Kadane's algorithm
 */
public class LargestSumContinousSubArray {
  public static void main(String args[]) {
    //int a[] = {100, -1, -100, 200};
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3, -21, 22};

    int sum=a[0], tempSum=a[0];
    for(int i=1; i<a.length; i++) {
      tempSum += a[i];

      if(a[i] > tempSum) {
        tempSum = a[i];
      }

      if(tempSum > sum) {
        sum = tempSum;
      }
    }
    System.out.print(sum);
  }
}
