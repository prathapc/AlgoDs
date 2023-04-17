package com.practice.B_algo.B_arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 19/05/22.
 */
public class D_SubArraySumDividedByK {
    private static int subarraysDivByK() {
        int A[] = {4,5,0,-2,-3,1};
        int K = 5;
        Map<Integer, Integer> preSum = new HashMap();
        int sum = 0;
        int result = 0;
        preSum.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int remainder = sum % K;

            //handling -ve numbers
            if (remainder < 0) {
                remainder += K;
            }

            result += preSum.getOrDefault(remainder, 0);

            preSum.put(remainder, preSum.getOrDefault(remainder, 0) + 1);
        }
        return result;
    }
}
