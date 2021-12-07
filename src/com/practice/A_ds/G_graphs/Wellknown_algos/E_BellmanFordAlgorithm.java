package com.practice.A_ds.G_graphs.Wellknown_algos;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 28/09/21.
 *
 * It's an algorithm to find shortest distance in directed weighted graph with negative edges
 * This is a dynamic programming based solution
 *
 * step 1: build 2D table to store shortest distances from A->B using AT MOST 0,1,2,..n-1 edges
 * [x-axis for dest vertex and y-axis for atmost edges]
 * step 2: fill first row (update infinite to actual wieghts)
 * step 3: fill next row using prev row values
 */
public class E_BellmanFordAlgorithm {
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
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}
