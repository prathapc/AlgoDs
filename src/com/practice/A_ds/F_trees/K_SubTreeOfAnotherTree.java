package com.practice.A_ds.F_trees;

import com.practice.B_algo.A_sort_search_math.Utility;

//https://leetcode.com/problems/subtree-of-another-tree/
public class K_SubTreeOfAnotherTree {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    Node target = new Node(8);
    target.setRight(new Node(12));
    System.out.println(subTree(root, target));
  }

  private static boolean subTree(Node root, Node target) {
    if (root == null && target == null) {
      return true;
    }
    if (root == null || target == null) {
      return false;
    }

    if (checkIfEqual(root, target)){
      return true;
    }

    return subTree(root.getLeft(), target.getLeft()) || subTree(root.getRight(), target.getRight());
  }

  private static boolean checkIfEqual(Node root, Node target) {
    if (root == null && target == null) {
      return true;
    }
    if (root == null || target == null) {
      return false;
    }
    if (root.getData() == target.getData()) {
      return checkIfEqual(root.getLeft(), target.getLeft()) && checkIfEqual(root.getRight(), target.getRight());
    }
    return false;
  }
}
