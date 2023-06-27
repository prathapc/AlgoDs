package com.practice.A_ds.F_trees;

import java.util.Stack;

/**
 * Created by prathapchowdary on 29/04/23.
 *
 * You are given the root of a binary tree.
 *
 * A ZigZag path for a binary tree is defined as follow:
 *
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * 
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class I_LongestZigZagPath {
    //recursion - beats 13% (check below using stack which beats 99%:))
    int maxPath = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxPath;
    }

    private void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) return;
        maxPath = Math.max(maxPath, steps);
        if (goLeft) {
            dfs(node.left, false, steps+1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, steps+1);
            dfs(node.left, false, 1);
        }
    }

    //using stack - beats 99%
    int max = 0;
    public int longestZigZag1(TreeNode root) {
        if (root == null) return 0;
        Stack<Data> stack = new Stack<>();
        if (root.left != null) {
            stack.push(new Data(root.left, true, 1));
        }
        if (root.right != null) {
            stack.push(new Data(root.right, false, 1));
        }
        while (!stack.isEmpty()) {
            Data curr = stack.pop();
            if (curr.depth > max) max = curr.depth;
            if (curr.isLeft) {
                if (curr.node.right != null) {
                    stack.push(new Data(curr.node.right, false, curr.depth+1));
                }
                if (curr.node.left != null) {
                    stack.push(new Data(curr.node.left, true, 1));
                }
            }

            if (!curr.isLeft) {
                if (curr.node.left != null) {
                    stack.push(new Data(curr.node.left, true, curr.depth+1));
                }
                if (curr.node.right != null) {
                    stack.push(new Data(curr.node.right, false, 1));
                }
            }
        }
        return max;
    }

    class Data {
        TreeNode node;
        boolean isLeft;
        int depth;
        public Data(TreeNode node, boolean isLeft, int depth) {
            this.node = node;
            this.isLeft = isLeft;
            this.depth = depth;
        }
    }
}
