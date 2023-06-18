package com.practice.A_ds.F_trees;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

import java.util.*;

/**
 * Created by prathap on 29/12/17.
 */
public class C_LevelOrder {

  public static void main(String args[]) {
    levelOrder(Utility.createMaxHeapTree());

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solution/
    zigzagLevelOrder(Utility.createSampleTree());
  }

  public static void levelOrder(Node root) {
    Queue<Node> queue = new LinkedList<Node>();

    if (root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.print(node.getData() + " ");
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
    }
  }

  private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue1 = new LinkedList<>();
    Queue<TreeNode> queue2 = new LinkedList<>();
    if (root != null) {
      queue1.add(root);
    }

    List<Integer> temp = null;
    boolean flip = false;
    while (!queue1.isEmpty() || !queue2.isEmpty()) {
      temp = new ArrayList<>();
      while(!queue1.isEmpty()) {
        TreeNode node = queue1.poll();
        temp.add(node.val);
        if (node.left != null) {
          queue2.add(node.left);
        }
        if (node.right != null) {
          queue2.add(node.right);
        }
      }
      if (!temp.isEmpty()) {
        if (flip) {
          Collections.reverse(temp);
          flip = false;
        } else {
          flip = true;
        }
        result.add(temp);
      }


      temp = new ArrayList<>();
      while(!queue2.isEmpty()) {
        TreeNode node = queue2.poll();
        temp.add(node.val);
        if (node.left != null) {
          queue1.add(node.left);
        }
        if (node.right != null) {
          queue1.add(node.right);
        }
      }
      if (!temp.isEmpty()) {
        if (flip) {
          Collections.reverse(temp);
          flip = false;
        } else {
          flip = true;
        }
        result.add(temp);
      }
    }
    return result;
  }
}
