package com.practice.A_ds.F_trees;

/**
 * Created by prathapchowdary on 18/09/22.
 *
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 *
 * Input: root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 * Explanation:
 * The tree has only one odd level.
 * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
 *
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
 */
public class O_ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevelsUtil(root.left, root.right, 1);
        return root;
    }

    private void reverseOddLevelsUtil(TreeNode node1, TreeNode node2, int height) {
        if (node1 == null || node2 == null) return;

        reverseOddLevelsUtil(node1.left, node2.right, height+1);
        reverseOddLevelsUtil(node1.right, node2.left, height+1);

        if (height % 2 == 1) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }
}
