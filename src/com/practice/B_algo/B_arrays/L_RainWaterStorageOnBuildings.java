package com.practice.B_algo.B_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class L_RainWaterStorageOnBuildings {

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

    //similar problem: buildings with ocean view at right side
    //https://leetcode.com/problems/buildings-with-an-ocean-view/
    public int[] findBuildings(int[] heights) {
        List<Integer> buildingsWithView = new ArrayList<>();
        int max = 0;
        for (int i = heights.length -1; i >= 0 ; i--) {
            if(heights[i] > max) {
                buildingsWithView.add(i);
            }
            max = Math.max(heights[i], max);
        }

        int[] result = new int[buildingsWithView.size()];
        int j = 0;
        for (int i = buildingsWithView.size() - 1; i >= 0 ; i--) {
            result[j] = buildingsWithView.get(i);
            j++;
        }
        return result;
    }
}
