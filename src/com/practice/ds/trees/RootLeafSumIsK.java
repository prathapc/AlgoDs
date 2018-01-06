package com.practice.ds.trees;

import com.practice.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 29/12/17.
 */
public class RootLeafSumIsK {
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    List<Integer> path = new ArrayList<>();
    rootToLeafSum(root, 50, path);

  }

  private static void rootToLeafSum(Node node, int k, List<Integer> path) {
    if(node == null)
      return;
    path.add(node.getData());
    if(node.getData() == k) {
      path.forEach(System.out:: println);
    }
    rootToLeafSum(node.getLeft(), k-node.getData(), path);
    rootToLeafSum(node.getRight(), k-node.getData(), path);
    path.remove(path.size()-1);
  }
}
