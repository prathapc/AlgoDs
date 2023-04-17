package com.practice.B_algo.B_arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by prathapchowdary on 31/05/22.
 *
 * Input: arr = [10,13,12,14,15]
 * Output: 2
 * Explanation:
 * From starting index i = 0, we can make our 1st jump to i = 2 (since arr[2] is the smallest among arr[1], arr[2], arr[3], arr[4] that is greater or equal to arr[0]), then we cannot jump any more.
 * From starting index i = 1 and i = 2, we can make our 1st jump to i = 3, then we cannot jump any more.
 * From starting index i = 3, we can make our 1st jump to i = 4, so we have reached the end.
 * From starting index i = 4, we have reached the end already.
 * In total, there are 2 different starting indices i = 3 and i = 4, where we can reach the end with some number of
 * jumps.
 *
 * https://leetcode.com/problems/odd-even-jump/
 */
public class O_OddEvenJump {
    //top down approach
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] greaterThan = new int[arr.length];
        int[] lesserThan = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            greaterThan[i] = map.ceilingKey(val) != null ? map.get(map.ceilingKey(val)) : 0;
            lesserThan[i] = map.floorKey(val) != null ? map.get(map.floorKey(val)) : 0;
            map.put(val, i);
        }

        int ans = 0;
        Boolean memo[][] = new Boolean[arr.length][2];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (recur(arr, greaterThan, lesserThan, i, 1, memo)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean recur(int[] arr, int[] greaterThan, int[] lesserThan, int i,
                          int jump, Boolean[][] memo) {

        if (i == arr.length - 1) {
            return true;
        }

        if (memo[i][jump] != null) {
            return memo[i][jump];
        }
        //odd Jump
        if (jump == 1) {

            if (arr[i] <= arr[greaterThan[i]] && i < greaterThan[i]) {
                return memo[i][jump] =
                        recur(arr, greaterThan, lesserThan, greaterThan[i], jump ^ 1, memo);
            }
        } else {

            if (arr[i] >= arr[lesserThan[i]] && i < lesserThan[i]) {
                return memo[i][jump] =
                        recur(arr, greaterThan, lesserThan, lesserThan[i], jump ^ 1, memo);
            }
        }
        return memo[i][jump] = false;
    }
}
