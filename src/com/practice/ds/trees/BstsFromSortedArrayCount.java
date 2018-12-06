package com.practice.ds.trees;

public class BstsFromSortedArrayCount {

  public static void main(String args[]) {
    int a[] = {2,4,5};
    System.out.println(countBstsUtil(a, 1, a.length));
  }

  private static int countBstsUtil(int[] a, int start, int end) {

    int count = 0;

    if (start >= end) {
      return 1;
    }

    for (int i=start; i<=end; i++) {
      int l = countBstsUtil(a, start, i-1);
      int r = countBstsUtil(a, i+1, end);
      count += l * r;
    }

    return count;
  }
}
