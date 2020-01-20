package com.practice.ps;

public class LargestNumberWithMaxKSwipes {

  public static void main(String args[]) {
    int a[] = {2,5,1,9,3,7,2,8,9,3};  //9 5 3 2 1 7 2 8 9 3
    int k = 6;

    //int a[] = {9,9,9,9};
    //int k = 4;
    largestNumberWithKSwipesUtil(a, 0, k);
    Utility.printArray(a);
  }

  private static void largestNumberWithKSwipesUtil(int[] a, int start, int k) {
    if (k > 0 && a.length > start) {
      int max = start;
      for (int i=start; i<=k; i++) {
        if (i+1 < a.length) {
          if (a[start + i] > a[max]) {
            max = start + i;
          }
        }
      }
      if (max > start) {
        swapElementToStart(a, start, max);
      }
      k = k - (max-start);
      largestNumberWithKSwipesUtil(a, ++start, k);
    }
  }

  private static void swapElementToStart(int[] a, int i, int max) {
    for (int p = max; p > i; p--) {
      Utility.swapElementsInArray(a, p, p-1);
    }
  }
}
