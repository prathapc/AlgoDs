package com.practice.B_algo.B_arrays;

import com.practice.B_algo.A_sort_search_math.Utility;

/**
 * Created by prathapchowdary on 19/05/22.
 *
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class G_LargestProductContrinousSubArray {
    private static void largestProductContrinousSubArray() {
        int a[] = {6, -3, -10, 0, 2};
        int maxEndingHere = a[0], minEndingHere = a[0];
        int maxSoFar = a[0];
        for (int i=1; i<a.length; i++) {
            if (a[i] < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Utility.max(a[i], maxEndingHere*a[i]);
            minEndingHere = Utility.min(a[i], minEndingHere*a[i]);

            maxSoFar = Utility.max(maxSoFar, maxEndingHere);
        }
        System.out.println(maxSoFar);
    }
}
