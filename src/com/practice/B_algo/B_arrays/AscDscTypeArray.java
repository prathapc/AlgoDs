package com.practice.B_algo.B_arrays;

import com.practice.C_ps.Utility;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class AscDscTypeArray {

    public static void AscDscTypeArray() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        if (tc < 1 || tc > 100) {
            throw new Exception("No of test cases should be >=1 or <=100");
        }
        for (int p = 0; p < tc; p++) {
            int n = scanner.nextInt();
            if (n < 4 || n > 100) {
                throw new Exception("input array size should be >=4 or <=100");
            }
            int[] arr = new int[n];
            for (int k = 0; k < n; k++) {
                arr[k] = scanner.nextInt();
            }
            if (arr.length != n) {
                throw new Exception("input array size should be " + n);
            }
            int i = 0;

            // Check if the array is in ascending order
            while (i < n-1 && arr[i] <= arr[i+1])
                i++;

            // If i reaches to last index that means
            // all elements are in increasing order
            if (i == n-1) {
                System.out.println("Ascending with maximum element = "+arr[n-1]);
                return ;
            }

            // If first element is greater than next one
            if (i == 0) {
                while (i < n-1 && arr[i] >= arr[i+1])
                    i++;

                // If i reaches to last index
                if (i == n - 1) {
                    System.out.println("Descending with maximum element = "+arr[0]);
                    return ;
                }

                // If the whole array is not in decreasing order
                // that means it is first decreasing then
                // increasing, i.e., descending rotated, so
                // its maximum element will be the point breaking
                // the order i.e. i so, max will be i+1
                if (arr[0] < arr[i+1]) {
                    System.out.println("Descending rotated with maximum element = "+ Utility.max(arr[0], arr[i+1]));
                    return ;
                }
                else {
                    System.out.println("Ascending rotated with maximum element = "+Utility.max(arr[0], arr[i+1]));
                    return ;
                }
            }

            // If whole array is not increasing that means at some
            // point it is decreasing, which makes it ascending rotated
            // with max element as the decreasing point
            if (i < n -1 && arr[0] > arr[i+1])
            {
                System.out.println("Ascending rotated with maximum element = "+ Utility.max(arr[i], arr[0]));
                return;
            }
            System.out.println("Descending rotated with maximum element = "+Utility.max(arr[i],arr[0]));
        }
        scanner.close();
    }
}
