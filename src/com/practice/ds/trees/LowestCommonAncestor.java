package com.practice.ds.trees;

import com.practice.algo.Utility;

/**
 * Created by prathap on 29/12/17.
 */
public class LowestCommonAncestor {
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();

    Node lca = lowestCommonAncestor(root, 12, 14);
    System.out.print(lca.getData());
  }

  private static Node lowestCommonAncestor(Node node, int n1, int n2) {
    if(node != null) {
      if(node.getData() == n1 || node.getData() == n2) {
        return node;
      } else {
        Node l = lowestCommonAncestor(node.getLeft(), n1, n2);
        Node r = lowestCommonAncestor(node.getRight(), n1, n2);
        if(l != null && r != null) {
          return node;
        }
        if(l != null) {
          return l;
        } else {
          return r;
        }
      }
    }
    return null;
  }
}
