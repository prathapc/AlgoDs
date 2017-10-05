package com.practice.algo;

/**
 * Created by prathap on 19/07/17.
 */

/**
 * Majority element in an array repeats for >n/2 times.
 */
public class BoyersMooreMajorityElement {

  public static void main(String[] args) {
    int a[] = {2,2,3,5,2,2,4};
    findMajorityElement(a);
  }

  private static void findMajorityElement(int[] a) {
    int majorityElement = a[0], count = 1;
    for(int i=1; i<a.length; i++) {
      if(a[i] == majorityElement) {
        count++;
      } else {
        count--;
      }
      if(count == 0) {
        count = 1;
        majorityElement = a[i];
      }
    }

    int majorityElementCount = 0;
    for(int i=0; i<a.length; i++) {
      if(a[i] == majorityElement) {
        majorityElementCount++;
      }
    }
    if(majorityElementCount > a.length/2) {
      System.out.print(majorityElement);
    }

  }
}
