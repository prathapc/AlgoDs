package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 17/09/21.
 */

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/ #facebook
 */
class C_VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        LinkedList<Step> temp = new LinkedList<>();
        temp.add(new Step(root, 0));
        while (!temp.isEmpty()) {
            int tempSize = temp.size();
            while (tempSize > 0) {
                Step c = temp.removeFirst();
                TreeNode n = c.node;
                int col = c.col;
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(n.val);
                if (n.left != null) temp.add(new Step(n.left, col - 1));
                if (n.right != null) temp.add(new Step(n.right, col + 1));
                tempSize--;
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    class Step {
        TreeNode node;
        int col;
        Step(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }
}
