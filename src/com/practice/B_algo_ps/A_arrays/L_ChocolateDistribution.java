package com.practice.B_algo_ps.A_arrays;

import java.util.Arrays;

/**
 * Given an array of n integers where each value represents number of chocolates in a packet.
 * Each packet can have variable number of chocolates. There are m students,
 * the task is to distribute chocolate packets such that:
 *
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates in packet with maximum chocolates
 *    and packet with minimum chocolates given to the students is minimum.
 *
 * i/p: {7,3,2,4,9,12,56}
 * We have seven packets of chocolates and
 * we need to pick three packets for 3 students
 * If we pick 2, 3 and 4, we get the minimum
 * difference between maximum and minimum packet
 * sizes.
 */
public class L_ChocolateDistribution {

  public static void main(String args[]) {
    int a[] = {7,3,2,4,9,12,56};
    int students = 3;

    Arrays.sort(a);

    int first = 0, last = 0;
    int minDiff = Integer.MAX_VALUE;
    for (int i=0; i+students-1 < a.length; i++) {
      int diff = a[i+students-1] - a[i];
      if (diff < minDiff) {
        minDiff = diff;
        first = i;
        last = i+students-1;
      }
    }
    System.out.println(a[last] - a[first]);
  }
}
