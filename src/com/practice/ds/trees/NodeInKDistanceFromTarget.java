package com.practice.ds.trees;

import com.practice.util.Utility;

/**
 * Created by prathap on 02/09/17.
 *
 * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 */
public class NodeInKDistanceFromTarget {
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    Node target = root.getLeft();
    findNodesInKDistanceFromTarget(root, target, 2);
  }

  private static int findNodesInKDistanceFromTarget(Node  node, Node target, int k) {
    if(node == null) {
      return -1;
    }
    if(node == target) {
      findNodesInTargetSubTree(target, k);
      return 0;
    }

    //if target present in left sub tree
    int d1 = findNodesInKDistanceFromTarget(node.getLeft(), target, k);
    if(d1 != -1) {
      //print root if in k distnace from target
      if(d1+1 == k) {
        System.out.println(node.getData());
      } else {
        findNodesInTargetSubTree(node.getRight(), k-d1-2);
      }
      return 1+d1;
    }

    //if target present in right sub tree
    int d2 = findNodesInKDistanceFromTarget(node.getRight(), target, k);
    if(d2 != -1) {
      //print root if in k distnace from target
      if(d2+1 == k) {
        System.out.println(node.getData());
      } else {
        findNodesInTargetSubTree(node.getLeft(), k-d2-2);
      }
      return 1+d2;
    }

    return -1;
  }

  private static void findNodesInTargetSubTree(Node target, int k) {
    if(target == null || k < 0) {
      return;
    }
    if(k==0) {
      System.out.println(target.getData());
      return;
    }
    findNodesInTargetSubTree(target.getLeft(), k-1);
    findNodesInTargetSubTree(target.getRight(), k-1);
  }

}
