package com.practice.companyQA.fb;

/**
 * Created by Prathap on 18 Jan, 2020
 *
 * Determine Peak or Valley from an integer array satisfying the following properities.
 *
 * At any given point in the array, the difference between two elements is +/- 1.
 * Ex. Arr[i] = A [i - 1] is +/- 1.
 * There should be only one peak or valley.
 * Return the index of the peak or valley from the given integer array.
 *
 * Examples:
 * Valley - [3, 2, 1, 0, 1] ==> 3
 * Peak - [4, 5, 6, 7, 8, 9, 8, 7] ==> 5
 * Invalid - [1, 2, 3] or [1, 2, 3, 2, 1, 2]
 *
 */
public class DeterminePeakOrValley {

    private int getPeakOrVally(final int[] arr) {
        if (arr.length < 3) return -1;

        boolean peak = false, valley = false;
        int index = -1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
                if (valley || peak)
                    return -1;
                valley = true;
                index = i;
            } else if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                if (valley || peak)
                    return -1;
                peak = true;
                index = i;
            }
        }
        return index;
    }

}
