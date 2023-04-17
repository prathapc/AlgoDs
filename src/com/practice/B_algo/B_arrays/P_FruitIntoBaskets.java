package com.practice.B_algo.B_arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 04/09/22.
 *
 * https://leetcode.com/problems/fruit-into-baskets/
 * https://www.youtube.com/watch?v=za2YuucS0tw
 */
public class P_FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int max=1, start=0, end=0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < tree.length) {
            if (map.size() <= 2) {
                map.put(tree[end], end++);
            }
            if (map.size() > 2) {
                //find min index in map
                int min = Integer.MAX_VALUE;
                for (int value : map.values()) {
                    min = Math.min(min, value);
                }
                //move i to right
                start = min + 1;
                map.remove(tree[min]);
            }
            max = Math.max(max, end-start);
        }
        return max;
    }
}
