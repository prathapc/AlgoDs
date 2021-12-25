package com.practice.A_ds.F_trees;

import com.practice.B_algo.A_sort_search_math.Utility;

import java.util.ArrayList;
import java.util.List;

//TODO Bug:- one path getting printed two times
public class SumPath_AnyNodeToDownwards {

  private static int res = 0;
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    List<Integer> path = new ArrayList<>();

    pathSum(root, 22);

    System.out.println(res);
  }

  private static void pathSum(Node root, int sum) {
    List<Integer> list = new ArrayList<>();
    pathSumUtil(root, sum, list, sum);
  }

  private static void pathSumUtil(Node root, int sum, List<Integer> list, int inputSum) {
    if (root != null) {
      list.add(root.getData());

      if (root.getData() - sum == 0) {
        list.forEach(e->System.out.print(e + " "));
        System.out.println("sum:" + sum);
        res++;
      }

      pathSumUtil(root.getLeft(), sum-root.getData(), list, inputSum);
      pathSumUtil(root.getLeft(), inputSum, new ArrayList<>(), inputSum);

      pathSumUtil(root.getRight(), inputSum, new ArrayList<>(), inputSum);
      pathSumUtil(root.getRight(), sum-root.getData(), list, inputSum);

      list.remove(list.size() - 1);
    }
  }

  //count - sum paths from any node to any node in tree ; beats 15%
  public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;
    return pathSumUtil(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int pathSumUtil(TreeNode node, int sum) {
    if (node == null) return 0;
    int count = pathSumUtil(node.left, sum-node.val) + pathSumUtil(node.right, sum-node.val);
    if (node.val == sum) count++;
    return count;
  }

  class TreeNode{
    TreeNode left, right;
    int val;
  }
}
