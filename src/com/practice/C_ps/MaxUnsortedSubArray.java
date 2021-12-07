package com.practice.C_ps;

/**
 * Created by prathap on 10/12/17.
 */
public class MaxUnsortedSubArray {
  public static void main(String args[]) {
    //int[] a = new int[]{10,12,20,30,25,40,32,31,35,50};
    //int[] a = new int[]{10,12,20,30,35,50};
    //int[] a = new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50};
    int[] a = new int[]{1,3,2,2,2};
    int s=-1, e=-1;
    for(int i=0; i<a.length-1; i++) {
      if(s==-1 && a[i] > a[i+1]) {
        s=i;
      }
      if(e==-1 && a[a.length-1-i-1] > a[a.length-1-i]) {
        e=a.length-1-i;
      }
    }
    System.out.println(s+":"+e);

    //find min and max in s,e range
    if(s!=-1&&e!=-1) {
      int min = a[s], max=a[s];
      for(int i=s; i<=e; i++) {
        if(a[i] < min) {
          min = a[i];
        }
        if(a[i] > max) {
          max = a[i];
        }
      }
      System.out.println(min+":"+max);

      //extend s,e if needed
      for(int i=0; i<=s-1; i++) {
        if(a[i] > min) {
          s=i;
          break;
        }
      }
      for(int i=a.length-1; i>=e+1; i--) {
        if(a[i] < max) {
          e=i;
          break;
        }
      }
    }
    System.out.println(s+":"+e);
  }
}
