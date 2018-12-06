package com.practice.ds.trees;

import java.util.ArrayList;
import java.util.List;

public class BstsFromSortedArray {

  public static void main(String args[]) {
    int n = 5; //if n=5 then input array is [1,2,3,4,5]
    List<Node> bsts = bsts(1,n);
  }

  private static List<Node> bsts(int start, int end) {
    List<Node> result = new ArrayList<>();
    if (start > end) {
      return result;
    }

    for (int i=start; i<end; i++) {
      List<Node> leftTrees = bsts(start, i-1);
      List<Node> rightTrees = bsts(i+1, end);

      for (Node leftTree : leftTrees) {
        for (Node rightTree : rightTrees) {
          Node root = new Node(i);
          root.setLeft(leftTree);
          root.setRight(rightTree);
          result.add(root);
        }
      }
    }

    return result;
  }
}
