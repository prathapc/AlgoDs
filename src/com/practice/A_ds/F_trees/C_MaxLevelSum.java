package com.practice.A_ds.F_trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathapchowdary on 18/06/23.
 */
public class C_MaxLevelSum {
    public static void main(String args[]) {
        maxLevelSum(TreeNode.deserialize("1,7,0,7,-8,null,null,"));
    }

    public static int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;
        queue.add(root);
        queue.add(null);
        int tempSum = 0, maxSumLevel = 0, level = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;

            tempSum += node.val;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (queue.peek() == null) {
                if (tempSum > maxSum) {
                    maxSumLevel = level;
                    maxSum = tempSum;
                }
                tempSum = 0;
                ++level;
                queue.poll();
                queue.add(null);
            }
        }
        return maxSumLevel;
    }
}
