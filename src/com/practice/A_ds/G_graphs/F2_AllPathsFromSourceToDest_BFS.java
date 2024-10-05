package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by prathapchowdary on 10/10/21.
 *
 * Time Complexity: O(2^V * V)
 */
public class F2_AllPathsFromSourceToDest_BFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> paths = new LinkedList<>();
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        paths.add(currPath);
        int destination = graph.length-1;
        while(!paths.isEmpty()) {
            currPath = paths.poll();
            int currNode = currPath.get(currPath.size()-1);
            if (currNode == destination) {
                result.add(currPath);
            }
            int[] neighbours = graph[currNode];
            for (int i=0; i<neighbours.length; i++) {
                List<Integer> newPath = new ArrayList<>(currPath);
                newPath.add(neighbours[i]);
                paths.add(newPath);
            }
        }
        return result;
    }
}
