package com.practice.ds.trees;

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
public class RangeSumInBst {

    public int rangeSumBST(Node root, int L, int R) {
        int sum = 0;
        if (root.getData() >= L && root.getData() <= R) sum += root.getData();
        if (root.getLeft() != null) sum += rangeSumBST(root.getLeft(), L, R);
        if (root.getRight() != null) sum += rangeSumBST(root.getRight(), L, R);
        return sum;
    }

}
