package com.practice.A_ds.D_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 17/12/23.
 *
 * https://leetcode.com/problems/minimum-interval-to-include-each-query/
 *
 * Input: intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
 * Output: [3,3,1,4]
 * Explanation: The queries are processed as follows:
 * - Query = 2: The interval [2,4] is the smallest interval containing 2. The answer is 4 - 2 + 1 = 3.
 * - Query = 3: The interval [2,4] is the smallest interval containing 3. The answer is 4 - 2 + 1 = 3.
 * - Query = 4: The interval [4,4] is the smallest interval containing 4. The answer is 4 - 4 + 1 = 1.
 * - Query = 5: The interval [3,6] is the smallest interval containing 5. The answer is 6 - 3 + 1 = 4.
 */
public class J_MinIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int numQuery = queries.length;

        //append index in query
        int[][] queriesWithIndex = new int[numQuery][2];
        for(int i = 0; i < numQuery; i++){
            queriesWithIndex[i] = new int[]{queries[i], i};
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Arrays.sort(queriesWithIndex, (a, b) -> (a[0] - b[0]));

        //sort interval in increasing order of size
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> ((a[1] - a[0]) - (b[1] - b[0])));

        int[] result = new int[numQuery];

        int j = 0;
        for(int i = 0; i < queries.length; i++){
            int queryVal = queriesWithIndex[i][0];
            int queryIndex = queriesWithIndex[i][1];

            //add all the interval which start is less or equal than current query value
            while(j < intervals.length && intervals[j][0] <= queryVal){
                minHeap.add(intervals[j]);
                j++;
            }

            //remove all the smallest size interval which end val is less than current query value
            while(!minHeap.isEmpty() && minHeap.peek()[1] < queryVal){
                minHeap.remove();
            }
            //now if heap is empty it means there is no interval which satisfy query val
            result[queryIndex] = minHeap.isEmpty() ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] + 1);
        }
        return result;
    }
}
