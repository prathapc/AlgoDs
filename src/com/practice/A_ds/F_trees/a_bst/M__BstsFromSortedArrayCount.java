package com.practice.A_ds.F_trees.a_bst;

public class M__BstsFromSortedArrayCount {

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

  //dp -> https://www.youtube.com/watch?v=YDf982Lb84o
  //f(5) = f(4) + f(3)f(1) + f(2)f(2) + f(1)f(3) + f(4)
  //f(6) = ....
  private static int countBstsDp(int[] a, int start, int end) {
    int result[] = new int[a.length];
    result[0] = 1;
    result[1] = 2;


    for (int i=2; i<=a.length; i++) {

    }

    return result[a.length-1];

  }

}
