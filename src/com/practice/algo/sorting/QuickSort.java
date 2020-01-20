package com.practice.algo.sorting;

import com.practice.ps.Utility;

import java.util.Arrays;

/**
 * Created by prathap on 17/02/18.
 */
public class QuickSort {

  public static void main(String args[]) {
    int a[] = {23, 12, 56, 45, 78, 15};
    System.out.println(Arrays.toString(a));

    quickSort(a, 0, a.length-1);

    System.out.println(Arrays.toString(a));
  }

  private static void quickSort(int[] a, int start, int end) {
    if (start < end) {
      int pIndex = partitionIndex(a, start, end);
      quickSort(a, start, pIndex-1);
      quickSort(a, pIndex+1, end);
    }

  }

  private static int partitionIndex(int[] a, int start, int end) {
    int pIndex = start-1;
    int pivot = a[end];
    for(int i=start; i<end; i++) {
      if(a[i] <= pivot) {
        pIndex++;
        Utility.swapElementsInArray(a, pIndex, i);
      }
    }
    Utility.swapElementsInArray(a, pIndex+1, end);
    return pIndex+1;
  }

}
