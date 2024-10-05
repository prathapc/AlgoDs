package com.practice.A_ds.F_trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by prathapchowdary on 10/01/24.
 *
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 *
 * Each minute, a node becomes infected if:
 *
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 *
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 */
public class P_TimeForBinaryTreeToBeInfected {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        convert(root, 0, map);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int minute = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int current = queue.poll();
                for (int num : map.get(current)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                levelSize--;
            }
            minute++;
        }
        return minute - 1;
    }

    public void convert(TreeNode current, int parent, Map<Integer, Set<Integer>> map) {
        if (current == null) {
            return;
        }
        if (!map.containsKey(current.val)) {
            map.put(current.val, new HashSet<>());
        }
        Set<Integer> adjacentList = map.get(current.val);
        if (parent != 0) {
            adjacentList.add(parent);
        }
        if (current.left != null) {
            adjacentList.add(current.left.val);
        }
        if (current.right != null) {
            adjacentList.add(current.right.val);
        }
        convert(current.left, current.val, map);
        convert(current.right, current.val, map);
    }
}