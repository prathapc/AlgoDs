package com.practice.B_algo_ps.A_arrays.binary_search;

/**
 * Created by prathapchowdary on 19/06/23.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 *
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class B_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = left + (right-left)/2;
            int hourSpent = 0;

            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }
}
