package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 19/05/22.
 *
 * https://leetcode.com/problems/maximum-subarray/
 */
public class G_LargestSumContinousSubArray {
    //Kadane's algorithm
    private static void largestSumContinousSubArray() {
        //int a[] = {100, -1, -100, 200};
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3, -21, 22};

        int sum=a[0], tempSum=a[0];
        for(int i=1; i<a.length; i++) {
            tempSum += a[i];

            if(a[i] > tempSum) {
                tempSum = a[i];
            }

            sum = Math.max(tempSum, sum);
        }
        System.out.println(sum);
    }
}
