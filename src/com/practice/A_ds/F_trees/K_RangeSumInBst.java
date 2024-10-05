package com.practice.A_ds.F_trees;

/**
 * Created by Prathap on 25 Dec, 2019
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 *
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class K_RangeSumInBst {
    //beats 45%
    public int rangeSumBST(Node root, int L, int R) {
        int sum = 0;
        if (root.getVal() >= L && root.getVal() <= R) sum += root.getVal();
        if (root.getLeft() != null) sum += rangeSumBST(root.getLeft(), L, R);
        if (root.getRight() != null) sum += rangeSumBST(root.getRight(), L, R);
        return sum;
    }

    //beats 100%
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > high) return rangeSumBST(root.left, low, high);
        if (root.val < low) return rangeSumBST(root.right, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
