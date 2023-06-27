package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 18/06/23.
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X
 * there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class K_CountGoodNodes {
    int goodNodesCount = 0;
    public int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return goodNodesCount;
    }

    private void goodNodes(TreeNode node, int prevMax) {
        if (node == null) return;
        if (node.val >= prevMax) goodNodesCount++;

        prevMax = Math.max(prevMax, node.val);
        goodNodes(node.left, prevMax);
        goodNodes(node.right, prevMax);
    }
}
