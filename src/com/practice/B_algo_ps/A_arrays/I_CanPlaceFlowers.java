package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 30/05/23.
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * https://leetcode.com/problems/can-place-flowers
 * #leetcode75 #considerCases
 */
public class I_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1 && flowerbed[0] == 1) return false;
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) return true;
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n > 1) return false;

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
            return canPlaceFlowers(flowerbed, n);
        }

        for (int i=1; i<flowerbed.length; i++) {
            if (flowerbed[i] == 0 && flowerbed[i-1] != 1 && ((i == flowerbed.length-1 && flowerbed[i] == 0) || flowerbed[i+1] != 1)) {
                flowerbed[i] = 1;
                n--;
            }
            if (n == 0) return true;
        }
        return false;
    }
}
