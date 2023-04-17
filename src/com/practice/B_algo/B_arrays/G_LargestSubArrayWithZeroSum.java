package com.practice.B_algo.B_arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 19/05/22.
 */
public class G_LargestSubArrayWithZeroSum {
    private static void largestSubArrayWithZeroSum() {
        int a[] = {15, -2, 2, -8, 1, 7, 10, 23};

        Map<Integer, Integer> sumSeenAndEndingIndexMap = new HashMap<>();
        sumSeenAndEndingIndexMap.put(a[0], 0);
        int maxLen = 0;
        int sumSoFar = a[0];
        for (int i=1; i<a.length; i++) {
            sumSoFar += a[i];

            if (a[i] == 0 && maxLen == 0) {
                maxLen = 1;
            }

            if (sumSoFar == 0) {
                maxLen = i+1;
            }

            if (sumSeenAndEndingIndexMap.containsKey(sumSoFar)) {
                maxLen = Math.max(maxLen, i - sumSeenAndEndingIndexMap.get(sumSoFar));
            } else {
                sumSeenAndEndingIndexMap.put(sumSoFar, i);
            }
        }
        System.out.println(maxLen);
    }
}
