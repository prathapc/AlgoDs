package com.practice.ps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Wrong output for few test cases
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/odd-even-subarrays-72ad69db/
 *
 * can we solve with largest palindrom subsequence way?
 */
public class NoOfSubArraysWithEqualOddEvenNumbers {

  public static void main(String args[] ) throws Exception {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int a[] = new int[n];
    for(int i=0; i<n; i++) {
      a[i] = s.nextInt();
    }
    System.out.print(oddEvenSubArray(a, n));
  }

  private static int oddEvenSubArray(int[] a, int n) {
    for (int i=0; i<n; i++) {
      if (a[i]%2 == 0) {
        a[i] = -1;
      } else {
        a[i] = 1;
      }
    }

    Map<Integer, Integer> mem = new HashMap<>();
    mem.put(a[0], 1);
    int result = 0;
    for (int i=1; i<n; i++) {
      a[i] += a[i-1];
      if (mem.containsKey(a[i])) {
        result += mem.get(a[i]);
        mem.put(a[i], mem.get(a[i] + 1));
      } else {
        mem.put(a[i], 1);
      }
      if (a[i] == 0) {
        result++;
      }
    }
    return result;
  }
}
