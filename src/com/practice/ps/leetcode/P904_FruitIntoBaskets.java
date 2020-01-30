package com.practice.ps.leetcode;

import java.util.*;

/**
 * Created by Prathap on 29 Jan, 2020
 *
 * https://leetcode.com/problems/fruit-into-baskets/
 *
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 *
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 */
public class P904_FruitIntoBaskets {

    //TODO
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }

        int max = 1, start=0, end=0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < tree.length) {
            if (map.size() <= 2) {
                map.put(tree[end], end++);
            }
            if (map.size() > 2) {
                //find min index tree in map and move start position till that index
                int min = Integer.MAX_VALUE;
                for (int value : map.values()) {
                    min = Math.min(min, value);
                }
                start = min + 1;
                map.remove(tree[min]);
            }
            max = Math.max(max, end-start);
        }
        return max;
    }

}
