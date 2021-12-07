package com.practice.E_java.Async;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Prathap on 28 Apr, 2019
 */

/**
 *      * assert min_by_key("a", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 1, "b": 2}
 *      * assert min_by_key("a", [{"a": 2}, {"a": 1, "b": 2}]) == {"a": 1, "b": 2}
 *      * assert min_by_key("b", [{"a": 1, "b": 2}, {"a": 2}, {"c", 5}]) == {"a": 2}
 *      * assert min_by_key("a", [{}]) == {}
 *      * assert min_by_key("b", [{"a": -1}, {"b": -1}]) == {"b": -1}
 */
public class Test1 {

    public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {

        Map<String, Integer> result = new HashMap<>();
        int minSoFar = Integer.MAX_VALUE;

        if (records == null || records.isEmpty()) {
            return result;
        }

        for (Map<String, Integer> record : records) {
            if (!record.containsKey(key)) {
                minSoFar = 0;
                result = record;
            } else {
                for (Map.Entry<String, Integer> entry : record.entrySet()) {
                    if (entry.getKey().equals(key)) {
                        if (minSoFar > entry.getValue()) {
                            minSoFar = entry.getValue();
                            result = record;
                            break;
                        }
                    }
                }
            }
        }


        return result;
    }


    /**
     *      assert first_by_key("a", "asc", [{"a": 1}]) == {"a": 1}
     *    * assert first_by_key("a", "asc", [{"b": 1}, {"b": -2}, {"a": 10}]) in [{"b": 1}, {"b": -2}]
     *    * assert first_by_key("a", "desc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"a": 10}
     *    * assert first_by_key("b", "asc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"b": -2}
     *    * assert first_by_key("b", "desc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"b": 1}
     *    *
     *    * assert first_by_key("a", "desc", [{}, {"a": 10, "b": -10}, {}, {"a": 3, "c": 3}]) == {"a": 10, "b": -10}
     *    * ```
     */
    public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
        Map<String, Integer> result = new HashMap<>();

        if (records == null || records.isEmpty()) {
            return result;
        }

        if (direction.equals("asc")) {
            int minSoFar = Integer.MAX_VALUE;
            for (Map<String, Integer> record : records) {
                if (!record.containsKey(key)) {
                    minSoFar = 0;
                    result = record;
                } else {
                    for (Map.Entry<String, Integer> entry : record.entrySet()) {
                        if (entry.getKey().equals(key)) {
                            if (minSoFar > entry.getValue()) {
                                minSoFar = entry.getValue();
                                result = record;
                                break;
                            }
                        }
                    }
                }
            }
            return result;
        } else if (direction.equals("desc")) {
            int maxSoFar = Integer.MIN_VALUE;
            for (Map<String, Integer> record : records) {
                if (!record.containsKey(key)) {
                    if (maxSoFar < 0) {
                        maxSoFar = 0;
                        result = record;
                    }
                } else {
                    for (Map.Entry<String, Integer> entry : record.entrySet()) {
                        if (entry.getKey().equals(key)) {
                            if (maxSoFar < entry.getValue()) {
                                maxSoFar = entry.getValue();
                                result = record;
                                break;
                            }
                        }
                    }
                }
            }
            return result;
        }

        return result;
    }



}
