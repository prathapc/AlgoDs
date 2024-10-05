package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by prathapchowdary on 01/07/23.
 *
 * https://leetcode.com/problems/course-schedule/
 */
public class S1_CourseSchedule {
    //dfs - O(m+n) time and space
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite: prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] instack = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (dfs(i, adj, visited, instack)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] instack) {
        if (instack[node]) return true; // If the node is already in the stack, we have a cycle.
        if (visited[node]) return false; //these two if conditions order is important

        // Mark the current node as visited and part of current recursion stack.
        visited[node] = true;
        instack[node] = true;
        for (int neighbour : adj.get(node)) {
            if (dfs(neighbour, adj, visited, instack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        instack[node] = false;
        return false;
    }


    //bfs - O(m+n) time and space
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // no prerequisites for i, push to queue
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for (int neighbor : adj.get(node)) {
                // Delete the edge "node -> neighbor".
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return nodesVisited == numCourses;
    }
}
