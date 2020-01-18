package com.practice.leetcode;

import java.util.*;

/**
 * Created by Prathap on 18 Jan, 2020
 *
 * https://github.com/openset/leetcode/tree/master/problems/campus-bikes
 *
 * https://www.acwing.com/solution/LeetCode/content/4848/
 *
 */
public class P1057_CampusBikes {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int N = workers.length, M = bikes.length;
        boolean[] used = new boolean[M];
        List<Pair>[] graph = new List[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<N; i++) for(int j=0; j<M; j++) {
            int[] w = workers[i], b = bikes[j];
            int dist = Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]);
            graph[i].add(new Pair(dist, i, j, -1));
        }

        for(int i=0; i<N; i++) {
            Collections.sort(graph[i]);
            List<Pair> list = graph[i];
            for(int j=0; j<list.size(); j++) list.get(j).idx = j;
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            heap.add(graph[i].get(0));
        }

        int[] ret = new int[N];
        Arrays.fill(ret, -1);
        int count = N;
        while(count > 0) {
            Pair p = heap.poll();
            if (used[p.bike]) {
                int idx = p.idx+1;
                while(used[graph[p.worker].get(idx).bike]) idx++;
                p = graph[p.worker].get(idx);
                heap.add(p);
                continue;
            }
            ret[p.worker] = p.bike;
            used[p.bike] = true;
            count--;
        }
        return ret;
    }

    public class Pair implements Comparable<Pair> {
        int dist, worker, bike, idx;
        public Pair(int a, int b, int c, int d) {
            dist = a;
            worker = b;
            bike = c;
            idx = d;
        }
        @Override
        public int compareTo(Pair p) {
            if (this.dist != p.dist) return this.dist - p.dist;
            if (this.worker != p.worker) return this.worker - p.worker;
            return this.bike - p.bike;
        }
    }
}
