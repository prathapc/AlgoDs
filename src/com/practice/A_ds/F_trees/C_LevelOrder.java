package com.practice.A_ds.F_trees;

import com.practice.B_algo_ps.K_sort_search_math.Utility;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * Created by prathap on 29/12/17.
 */
public class C_LevelOrder {

  public static void main(String args[]) {
    //https://leetcode.com/problems/binary-tree-level-order-traversal/
    levelOrder(Utility.createSampleTree());

    //https://leetcode.com/problems/n-ary-tree-level-order-traversal/
    nArrayTreeLevelOrder(null);


    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    zigzagLevelOrder(Utility.createSampleTree());

    //https://leetcode.com/problems/average-of-levels-in-binary-tree/
    averageOfLevels(Utility.createSampleTree());
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> bfs = new LinkedList<>();
    bfs.add(root);
    while (!bfs.isEmpty()) {
      int currLevelSize = bfs.size();
      List<Integer> level = new ArrayList<>();
      for (int i=0; i<currLevelSize; i++) {
        TreeNode curr = bfs.poll();
        level.add(curr.val);

        if (curr.left != null) bfs.add(curr.left);
        if (curr.right != null) bfs.add(curr.right);
      }
      result.add(level);
    }
    return result;
  }

  //check below Node class for input
  public static List<List<Integer>> nArrayTreeLevelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<Node> bfs = new LinkedList<>();
    bfs.add(root);

    while (!bfs.isEmpty()) {
      int levelCount = bfs.size();
      List<Integer> levelNodes = new ArrayList<>();
      while (levelCount-- > 0) {
        Node node = bfs.poll();
        if (node == null) continue;
        levelNodes.add(node.val);
        bfs.addAll(node.children);
      }
      result.add(levelNodes);
    }
    return result;
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }
    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isLeftToRight = true;
    while (!queue.isEmpty()) {
      Deque<Integer> currRow = new LinkedList<>();
      for (int i=queue.size(); i>0; i--) {
        TreeNode node = queue.poll();
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);

        if (isLeftToRight) {
          currRow.addLast(node.val);
        } else {
          currRow.addFirst(node.val);
        }
      }
      result.add(new ArrayList<>(currRow));
      isLeftToRight = !isLeftToRight;
    }
    return result;
  }

  public static List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if(root == null) return result;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()) {
      int n = q.size();
      double sum = 0.0;
      for(int i = 0; i < n; i++) {
        TreeNode node = q.poll();
        sum += node.val;
        if(node.left != null) q.offer(node.left);
        if(node.right != null) q.offer(node.right);
      }
      result.add(sum / n);
    }
    return result;
  }
}
