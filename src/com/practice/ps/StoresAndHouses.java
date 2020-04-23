package com.practice.ps;

import java.util.*;

/**
 * Created by Prathap on 09 Feb, 2020
 *
 * Input: houses = [5, 10, 17], stores = [1, 5, 20, 11, 16]
 * Output: [5, 11, 16]
 * Explanation:
 * The closest store to the house at location 5 is the store at the same location.
 * The closest store to the house at location 10 is the store at the location 11.
 * The closest store to the house at location 17 is the store at the location 16.
 */
public class StoresAndHouses {

    private static int[] shortestDistance(int[] houses, int[] stores) {
        int[] result = new int[houses.length];
        TreeSet<Integer> set = new TreeSet<>();

        for(int store: stores) {
            set.add(store);
        }

        for(int i = 0; i < houses.length; i++) {
            if (set.floor(houses[i]) != null && set.ceiling(houses[i]) != null) {
                result[i] = houses[i] - set.floor(houses[i]) <= set.ceiling(houses[i]) - houses[i] ? set.floor(houses[i]) : set.ceiling(houses[i]);
            } else if (set.floor(houses[i]) != null) {
                result[i] = set.floor(houses[i]);
            } else {
                result[i] = set.ceiling(houses[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        shortestDistance(new int[]{4, 8, 1, 1}, new int[]{5, 3, 1, 2, 6});
    }

}
