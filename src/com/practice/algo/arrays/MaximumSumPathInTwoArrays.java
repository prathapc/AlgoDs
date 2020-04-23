package com.practice.algo.arrays;

import com.practice.ps.Utility;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class MaximumSumPathInTwoArrays {

    public static void main(String args[]) {
        int a[] = {2, 3, 7, 10, 12};
        int b[] = {1, 5, 7, 8};
        int result = 0, sum1 = 0, sum2 = 0;
        int m = a.length-1, n = b.length-1;
        int i=0, j=0;
        while(i<m && j<n) {
            if(a[i] < b[j]) {
                sum1 += a[i++];
            } else if(a[i] > b[j]) {
                sum2 += b[j++];
            } else {
                result += Utility.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                while(i<m && j<n && a[i] == b[j]) {
                    result += a[i++];
                    j++;
                }
            }
        }
        while(i<m) {
            sum1 += a[i++];
        }
        while(j<n) {
            sum2 += b[j++];
        }
        result += Utility.max(sum1, sum2);
        System.out.println(result);
    }

}
