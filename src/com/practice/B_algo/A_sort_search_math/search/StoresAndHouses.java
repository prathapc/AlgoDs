package com.practice.B_algo.A_sort_search_math.search;

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

    public static int[] findStores(int[] houses, int[] stores) {
        int n = houses.length, m = stores.length;
        int[] result = new int[n];
        Arrays.sort(stores);
        for (int i = 0; i < n; i++) {
            int house = houses[i], dist = Integer.MAX_VALUE, store = 0;
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (stores[mid] == house) {
                    store = house;
                    break;
                } else {
                    int d = Math.abs(house - stores[mid]);
                    if (d == dist) {
                        store = Math.min(store, stores[mid]);
                    } else if (d < dist) {
                        dist = d;
                        store = stores[mid];
                    }
                    if (stores[mid] < house) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            result[i] = store;
        }
        return result;
    }

    public static void main(String[] args) {
        findStores(new int[]{4, 8, 1, 1}, new int[]{5, 3, 1, 2, 6});
    }

}
