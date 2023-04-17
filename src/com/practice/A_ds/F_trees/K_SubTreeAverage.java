package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 08/05/22.
 *
 * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
 * Note:
 * The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
 * A subtree of root is a tree consisting of root and all of its descendants.
 *
 * Input: root = [4,8,5,0,1,null,6]
 * Output: 5
 * Explanation:
 * For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
 * For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
 * For the node with value 0: The average of its subtree is 0 / 1 = 0.
 * For the node with value 1: The average of its subtree is 1 / 1 = 1.
 * For the node with value 6: The average of its subtree is 6 / 1 = 6.
 *
 */
public class K_SubTreeAverage {
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        averageOfSubtreeUtil(root);
        return result;
    }

    private int[] averageOfSubtreeUtil(TreeNode root) {
        if (root == null) return new int[]{0,0};
        int l[] = averageOfSubtreeUtil(root.left);
        int r[] = averageOfSubtreeUtil(root.right);

        int totalNodes = l[0] + r[0] + 1;
        int totalSum = l[1] + r[1] + root.val;
        if (totalSum/totalNodes == root.val) {
            result++;
        }
        return new int[]{totalNodes, totalSum};
    }
}
