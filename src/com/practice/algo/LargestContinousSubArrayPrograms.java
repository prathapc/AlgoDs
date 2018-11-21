package com.practice.algo;

/**
 * Created by prathap on 02/09/17.
 */

/**
 * Kadane's algorithm
 */
public class LargestContinousSubArrayPrograms    {
  public static void main(String args[]) {
    largestSumContinousSubArray();
    largestProductContrinousSubArray();
  }

  private static void largestProductContrinousSubArray() {
    int a[] = {6, -3, -10, 0, 2};
    int maxEndingHere = a[0], minEndingHere = a[0];
    int maxSoFar = a[0];
    for (int i=1; i<a.length; i++) {
      if (a[i] < 0) {
        int temp = maxEndingHere;
        maxEndingHere = minEndingHere;
        minEndingHere = temp;
      }

      maxEndingHere = Utility.max(a[i], maxEndingHere*a[i]);
      minEndingHere = Utility.min(a[i], minEndingHere*a[i]);

      maxSoFar = Utility.max(maxSoFar, maxEndingHere);
    }
    System.out.println(maxSoFar);
  }

  private static void largestSumContinousSubArray() {
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
    System.out.println(sum);
  }
}
