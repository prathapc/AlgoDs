package com.practice.A_ds.G_graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by prathapchowdary on 25/06/23.
 *
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 *
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 *
 * It's guaranteed that each city can reach city 0 after reorder.
 *
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
public class C_ReorderRoutesToAllPathsLeadToCapital {

    public int minReorder(int n, int[][] connections) {
        Set<String> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(i, new HashSet<>());
        }
        for(int i=0;i<connections.length;i++) {
            int src = connections[i][0];
            int dest = connections[i][1];
            set.add(src + "," + dest);
            map.get(src).add(dest);
            map.get(dest).add(src);
        }
        return dfs(map, set, new boolean[n], 0);
    }

    public int dfs(Map<Integer, Set<Integer>> map, Set<String> set, boolean visited[], int src) {
        int count = 0;
        if(visited[src]) return 0;
        visited[src] = true;
        for(int s : map.getOrDefault(src, new HashSet<>())) {
            if(visited[s]) continue;
            if(!set.contains(s + "," + src)) count++;
            count+=dfs(map, set, visited,s);
        }
        return count;
    }
}
