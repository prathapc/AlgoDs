package com.practice.A_ds.F_trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 08/07/23.
 *
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers.
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class I_RootToLeafPathsSum {
  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    List<Integer> nums = new ArrayList<>();
    sumNumbers(root, 0, nums);
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum;
  }

  private void sumNumbers(TreeNode root, int num, List<Integer> nums) {
    if (root == null) return;

    num *= 10;
    num += root.val;

    if (root.left == null && root.right == null) {
      nums.add(num);
    } else {
      sumNumbers(root.left, num, nums);
      sumNumbers(root.right, num, nums);
    }
  }
}
