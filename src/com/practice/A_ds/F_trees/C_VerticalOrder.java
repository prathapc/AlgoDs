package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 17/09/21.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> data = new TreeMap<>();
        traverseTree(root, data, 0, 0);

        for (Map.Entry<Integer, List<Integer>> entry : data.entrySet()) {
            List<Integer> l = entry.getValue();
            //Collections.sort(l);
            result.add(l);
        }
        return result;
    }

    //iteration or we can also solve using bfs (queue)
    private void traverseTree(TreeNode node, Map<Integer, List<Integer>> data, int x, int y) {
        if (node != null) {
            List<Integer> groupElements = data.get(y);
            if (groupElements == null) {
                groupElements = new ArrayList<>();
            }
            groupElements.add(node.val);
            data.put(y, groupElements);

            traverseTree(node.left, data, x+1, y-1);
            traverseTree(node.right, data, x+1, y+1);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
