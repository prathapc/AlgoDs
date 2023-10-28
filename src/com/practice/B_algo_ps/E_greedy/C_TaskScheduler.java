package com.practice.B_algo_ps.E_greedy;

import java.util.*;

/**
 * Created by Prathap on 07 Nov, 2019
 *
 * there is a non-negative integer n that represents the cooldown period between two same tasks
 * (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 *
 * https://leetcode.com/problems/task-scheduler/
 */
public class C_TaskScheduler {

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
            //take 'n' elements from queue and add to temp list
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            //add back elements in temp list to heap if thier count is greater than zero
            for (int i: temp) {
                if (--i > 0) {
                    maxHeap.add(i);
                }
            }

            //if heap is empty append temp list size to result and restart the process
            //if heap not empty, that means add n+1 (min idle time) to result by ignoring temp element and restart the process
            cycles += maxHeap.isEmpty() ? temp.size() : n+1;
        }

        return cycles;
    }
}
