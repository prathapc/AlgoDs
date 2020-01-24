package com.practice.algo.arrays;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class RainWaterStorageOnBuildings {

    public static void main(String[] args) throws Exception {
        rainWaterStorageOnBuildings();
    }

    private static void rainWaterStorageOnBuildings() {
        int[] arr = { 3, 2, 4, 1, 7 };
        int n= arr.length;

        int left[] = new int[n];
        int right[] = new int[n];

        int water = 0;

        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i-1], arr[i]);

        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], arr[i]);

        for (int i = 0; i < n; i++)
            water += Math.min(left[i],right[i]) - arr[i];

        System.out.println("water stored: "+water);
    }
}
