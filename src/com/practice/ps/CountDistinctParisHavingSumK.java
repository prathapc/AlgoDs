package com.practice.ps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Prathap on 21 Dec, 2019
 */
public class CountDistinctParisHavingSumK {

    public static int countPairs(List<Integer> arr, long k) {
        HashSet<Long> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer number : arr) {
            long difference = k - number;
            if (set.contains(difference)) {
                if ((map.containsKey(number) && map.containsValue((int) difference))
                        || !(map.containsKey((int) (difference)) && map.containsValue(number))) {
                    map.put(number, (int) difference);
                }
            }
            set.add(Long.valueOf(number));
        }
        return map.size();
    }
}
