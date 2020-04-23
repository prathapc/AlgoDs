package com.practice.ps;
import java.util.*;

/**
 * Created by Prathap on 22 Oct, 2019
 */
public class Test {

    public static void main(String args[]) {

        int[][] trust = new int[][]{
                {1,2}, {2,3}
        };
        int N = 3;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<trust.length; i++) {
            set.add(trust[i][0]);
        }

        for (int i=1; i<=N; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
            }
        }
        System.out.println(-1);

        /*int arr[] = {7,7,7,7,7,7,7};
        int k=7;
        int threshold = 7;

        if (arr.length < k) return;
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        int tempK = 0;
        for (int i=1; i<arr.length; i++) {
            if (++tempK < k) {
                sum[i] = sum[i-1] + arr[i];
            } else {
                int temp = sum[i-1]-arr[i-k];
                sum[i] = temp + arr[i];
                tempK = k;
            }
        }

        int result = 0;
        for (int i=k-1; i<arr.length; i++) {
            if (sum[i]/k >= threshold) {
                ++result;
            }
        }

        System.out.println(result);*/

    }

}
