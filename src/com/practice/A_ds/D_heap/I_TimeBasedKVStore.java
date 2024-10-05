package com.practice.A_ds.D_heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by prathapchowdary on 08/11/23.
 *
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 *
 * Implement the TimeMap class:-
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 *
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class I_TimeBasedKVStore {

    public static void main(String[] args) {
        I_TimeBasedKVStore demo = new I_TimeBasedKVStore();
        demo.set("foo", "bar", 1);
        demo.get("foo", 1);
        demo.get("foo", 3);
        demo.set("foo", "bar2", 4);
        demo.get("foo", 4);
        demo.get("foo", 5);
    }

    static Map<String, PriorityQueue<Data>> kvMap = null;
    public I_TimeBasedKVStore() {
        kvMap = new HashMap<>();
    }

    public static void set(String key, String value, int timestamp) {
        if (!kvMap.containsKey(key)) {
            kvMap.put(key, new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp));
        }
        PriorityQueue<Data> q = kvMap.get(key);
        q.offer(new Data(value, timestamp));
        kvMap.put(key, q);
    }

    public static String get(String key, int timestamp) {
        String result = "";
        PriorityQueue<Data> maxHeap = kvMap.get(key);
        List<Data> temp = new ArrayList<>();
        while (maxHeap != null && !maxHeap.isEmpty()) {
            Data data = maxHeap.poll();
            temp.add(data);
            if (data.timestamp <= timestamp) {
                result = data.value;
                break;
            }
        }
        if (!temp.isEmpty()) maxHeap.addAll(temp);
        return result;
    }

    static class Data {
        String value;
        int timestamp;
        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
