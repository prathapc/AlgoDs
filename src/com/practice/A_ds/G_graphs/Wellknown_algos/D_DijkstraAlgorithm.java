package com.practice.A_ds.G_graphs.Wellknown_algos;

import java.util.*;

/**
 * Created by prathapchowdary on 28/09/21.
 *
 * It's an algorithm to find shortest distance/path in weighted directed graph (with pasitive edges only)
 *
 * step 1: build table with target vertex, shortest distance (assign infinite) and via/previous vertex
 * step 2: take first vertex from above table and update all other target vertex distance having direct route
 * step 3: mark first vertex as visted and pick next vertext and repeat above step
 * step 4: once all vertexes are visited then we can lookup shortest distance to any vertex and its path from table
 */
public class D_DijkstraAlgorithm {
    /*
    https://leetcode.com/problems/cheapest-flights-within-k-stops/

    There are n cities connected by some number of flights. You are given an array flights where
    flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
    You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
    If there is no such route, return -1.

    Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
    Output: 200
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        Map<Integer, List<int[]>> map=new HashMap<>();
        for(int[] f:flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        q.offer(new int[]{0,src,K+1});
        while(!q.isEmpty())
        {
            int[] c=q.poll();
            int cost=c[0];
            int curr=c[1];
            int stop=c[2];
            if(curr==dst)
                return cost;
            if(stop>0)
            {
                if(!map.containsKey(curr))
                    continue;
                for(int[] next:map.get(curr))
                {
                    q.add(new int[]{cost+next[1],next[0],stop-1});
                }
            }
        }
        return -1;
    }
}
