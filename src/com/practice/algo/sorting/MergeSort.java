package com.practice.algo.sorting;

import java.util.Arrays;

/**
 * Created by prathap on 17/02/18.
 */
public class MergeSort {

  static int[] temp;
  public static void main(String args[]) {
    int a[] = {23, 12, 56, 45, 78, 15};
    temp = new int[a.length];
    System.out.println(Arrays.toString(a));
    mergeSort(a, 0, a.length-1);
    System.out.println(Arrays.toString(a));
  }

  private static void mergeSort(int[] a, int start, int end) {
    if (start < end) {
      int mid = (start+end)/2;
      mergeSort(a, start, mid);
      mergeSort(a, mid+1, end);

      merge(a, start, mid, end);
    }
  }

  private static void merge(int a[], int low, int middle, int high) {
    for (int i = low; i <= high; i++) {
      temp[i] = a[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;

    while (i <= middle && j <= high) {
      if (temp[i] <= temp[j]) {
        a[k] = temp[i];
        i++;
      } else {
        a[k] = temp[j];
        j++;
      }
      k++;
    }

    // Copy the rest of the left side of the array into the target array
    while (i <= middle) {
      a[k] = temp[i];
      k++;
      i++;
    }
  }

}
