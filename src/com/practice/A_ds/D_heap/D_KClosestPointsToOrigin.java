package com.practice.A_ds.D_heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Prathap on 07 Jan, 2020
 * https://leetcode.com/problems/k-closest-points-to-origin
 */
public class D_KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            int d1 = a[0]*a[0] + a[1]*a[1]; //ignore sqrt
            int d2 = b[0]*b[0] + b[1]*b[1];
            return d1-d2;
        });
        for (int[] p : points) {
            pq.offer(p);
        }
        int[][] result = new int[K][2];
        for (int i=0; i<K; i++) {
            int[] closePoint = pq.poll();
            result[i][0] = closePoint[0];
            result[i][1] = closePoint[1];
        }
        return result;
    }

}

