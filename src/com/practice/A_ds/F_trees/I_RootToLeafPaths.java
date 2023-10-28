package com.practice.A_ds.F_trees;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 07/10/17.
 *
 * Update: 21/11/2021
 *
 * https://leetcode.com/problems/binary-tree-paths
 */
public class I_RootToLeafPaths {
  public static void main(String args[]) {
    List<String> paths = binaryTreePaths(Utility.createSampleTree());
    System.out.println(paths);
  }

  public static List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    binaryTreePathsUtil(root, "", paths);
    return paths;
  }

  private static void binaryTreePathsUtil(TreeNode root, String path, List<String> paths) {
    if (root != null) {
      path += String.valueOf(root.val);
      if (root.left == null && root.right == null) {
        paths.add(path);
      } else {
        path += "->";
        binaryTreePathsUtil(root.left, path, paths);
        binaryTreePathsUtil(root.right, path, paths);
      }
    }
  }
}
