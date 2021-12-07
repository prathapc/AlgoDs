package com.practice.A_ds.F_trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 14/09/21.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 *          1
 *       2    3
 *     4   5    6
 *
 *     1
 *       2
 *         3
 *           4
 *             5
 *               6
 */
public class F_FlattenBinaryTreeToList {


    public void flatten_recursion(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        // We need to return the "rightmost" node after we are done wiring the new connections.
        return rightTail != null ? rightTail : leftTail;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            // move on to the right side of the tree
            node = node.right;
        }
    }
}
