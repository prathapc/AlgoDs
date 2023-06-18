package com.practice.B_algo_ps.E_greedy;

import java.util.*;

/**
 * Created by Prathap on 07 Nov, 2019
 *
 * https://leetcode.com/problems/task-scheduler/
 *
 */
public class TaskScheduler {

    public static void main(String args[]) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> tasksCountMap = new HashMap<>();
        for(char c: tasks) {
            tasksCountMap.put(c, tasksCountMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(tasksCountMap.values());

        int cycles = 0;
        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            for (int i: temp) {
                if (--i > 0) {
                    maxHeap.add(i);
                }
            }

            cycles += maxHeap.isEmpty() ? temp.size() : n+1;
        }

        return cycles;
    }
}
