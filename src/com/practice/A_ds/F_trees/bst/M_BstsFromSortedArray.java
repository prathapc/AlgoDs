package com.practice.A_ds.F_trees.bst;

import com.practice.A_ds.F_trees.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class M_BstsFromSortedArray {

  private static TreeNode sortedArrayToBSTUtil(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = (start+end)/2;
    TreeNode node = new TreeNode(nums[mid]);

    node.left = sortedArrayToBSTUtil(nums, start, mid-1);
    node.right = sortedArrayToBSTUtil(nums, mid+1, end);

    return node;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBSTUtil(nums, 0, nums.length-1);
  }
}
