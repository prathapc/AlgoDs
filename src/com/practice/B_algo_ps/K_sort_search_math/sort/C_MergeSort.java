package com.practice.B_algo_ps.K_sort_search_math.sort;

import java.util.Arrays;

/**
 * Created by prathap on 17/02/18.
 */
public class C_MergeSort {

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

  /* Cleaner & easy to understand [merge two sorted arrays concept]
  public int [] merge_sort(int [] input) {
      if (input.length <= 1) {
        return input;
      }
      int pivot = input.length / 2;
      int [] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
      int [] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
      return merge(left_list, right_list);
    }

    public int [] merge(int [] left_list, int [] right_list) {
      int [] ret = new int[left_list.length + right_list.length];
      int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

      while (left_cursor < left_list.length &&
             right_cursor < right_list.length) {
        if (left_list[left_cursor] < right_list[right_cursor]) {
          ret[ret_cursor++] = left_list[left_cursor++];
        } else {
          ret[ret_cursor++] = right_list[right_cursor++];
        }
      }
      // append what is remain the above lists
      while (left_cursor < left_list.length) {
        ret[ret_cursor++] = left_list[left_cursor++];
      }
      while (right_cursor < right_list.length) {
        ret[ret_cursor++] = right_list[right_cursor++];
      }
      return ret;
    }
   */
}
