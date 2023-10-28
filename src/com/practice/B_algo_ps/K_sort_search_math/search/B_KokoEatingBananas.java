package com.practice.B_algo_ps.K_sort_search_math.search;

import java.util.Arrays;

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

    public static void main(String arg[]) {
        int[] a = {1,2,3,4,9};
        int k = 6;
        Arrays.sort(a);
        int left = 1, right = 1;
        for (int r : a) right = Math.max(right, r);
        while (left < right) {
            int mid = left + (right - left) / 2;

            int temp = 0;
            for (int i : a) {
                temp += Math.floor((double) i/mid);
            }

            if (temp <= k) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        System.out.println(right);
    }
}
