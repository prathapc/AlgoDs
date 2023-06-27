package com.practice.A_ds.F_trees;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 *
 * https://leetcode.com/problems/path-sum-ii/
 */
public class K_SumPathII {

  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<Integer> temp = new ArrayList<>();
    pathSum(root, targetSum, temp);
    return result;
  }

  private void pathSum(TreeNode node, int targetSum, List<Integer> temp) {
    if (node == null) return;

    temp.add(node.val);
    if (node.left == null && node.right == null && targetSum-node.val == 0) {
      result.add(new ArrayList<>(temp));
    } else {
      pathSum(node.left, targetSum-node.val, temp);
      pathSum(node.right, targetSum-node.val, temp);
    }
    temp.remove(temp.size()-1);
  }
}
