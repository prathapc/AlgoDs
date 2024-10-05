package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by prathapchowdary on 13/11/23.
 *
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class S2_CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<numCourses; i++) adjList.add(new ArrayList<>());
        for (int[] prerequisite : prerequisites) adjList.get(prerequisite[1]).add(prerequisite[0]);
        boolean[] visited = new boolean[numCourses];
        boolean[] instack = new boolean[numCourses];

        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<numCourses; i++) {
            if (!toplogySort(i, adjList, visited, instack, stack)) {
                return new int[]{};
            }
        }
        int i = 0;
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()) result[i++] = stack.pop();
        return result;
    }
    private static boolean toplogySort(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] instack, Stack<Integer> stack) {
        if (instack[node]) return false; //instack is to detect cycle and this has to be first condition
        if (visited[node]) return true;

        visited[node] = true;
        instack[node] = true;
        for (int prereq : adjList.get(node)) {
            if (!toplogySort(prereq, adjList, visited, instack, stack)) {
                return false;
            }
        }
        instack[node] = false;

        stack.push(node);
        return true;
    }

    public static void main(String[] args) {
        findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
    }
}
