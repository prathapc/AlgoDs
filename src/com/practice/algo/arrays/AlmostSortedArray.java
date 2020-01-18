package com.practice.algo.arrays;

import java.util.*;

/**
 * Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.
 *
 * Swap two elements.
 * Reverse one sub-segment.
 * Determine whether one, both or neither of the operations will complete the task. If both work, choose swap.
 * For instance, given an array  either swap the  and , or reverse them to sort the array. Choose swap
 *
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 *
 */
public class AlmostSortedArray {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    almostSorted(new int[]{1, 5, 4, 3, 2, 6});
  }

  static void almostSorted(int[] arr) {
    int n = arr.length;
    if (isArrayInIncOrder(arr)) {
      System.out.println("yes");
      return;
    }

    int i = 0;
    while (i < n-1 && arr[i] < arr[i+1]) {
      i++;
    }
    int j=n-1;
    while (j>0 && arr[j-1] < arr[j]) {
      j--;
    }

    swap(arr, i, j);
    if (isArrayInIncOrder(arr)) {
      System.out.println("yes\nswap "+ (i+1) + " " + (j+1));
      return;
    }

    int k = i+1, l = j-1;
    while (k < l)
      swap(arr, k++, l--);
    if (isArrayInIncOrder(arr)) {
      System.out.println("yes\nreverse " + (i+1) + " " + (j+1));
      return;
    }

    System.out.println("no");

  }

  public static void swap(int[] d, int i, int j) {
    int tmp = d[i];
    d[i] = d[j];
    d[j] = tmp;
  }

  public static boolean isArrayInIncOrder(int[] d) {
    for (int i = 0; i < d.length-1; ++i) {
      if (d[i] > d[i+1]) return false;
    }
    return true;
  }
}
