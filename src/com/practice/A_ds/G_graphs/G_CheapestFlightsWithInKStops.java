package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by prathapchowdary on 11/12/23.
 *
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class G_CheapestFlightsWithInKStops {

    //DFS + DP => beats 5%
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Map<String, Integer> dp = new HashMap<>();
        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new ArrayList<>());
            }
            List<int[]> temp = graph.get(flight[0]);
            temp.add(new int[]{flight[1], flight[2]});
            graph.put(flight[0], temp);
        }
        int result = dfs(graph, src, dst, k, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private int dfs(Map<Integer, List<int[]>> graph, int src, int dst, int k, Map<String, Integer> dp) {
        if (src == dst) {
            return 0;
        }
        if (k < 0 || !graph.containsKey(src)) return Integer.MAX_VALUE;
        if (dp.containsKey(src + ":" + k)) return dp.get(src + ":" + k);

        int maxCost = Integer.MAX_VALUE;
        List<int[]> flights = graph.get(src);
        for (int[] flight : flights) {
            int price = dfs(graph, flight[0], dst, k-1, dp);
            if (price != Integer.MAX_VALUE) {
                maxCost = Math.min(maxCost, price+flight[1]);
            }
        }
        dp.put(src + ":" + k, maxCost);
        return maxCost;
    }
}
