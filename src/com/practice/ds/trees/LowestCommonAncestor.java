package com.practice.ds.trees;

import com.practice.ps.Utility;

/**
 * Created by prathap on 29/12/17.
 *
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 *
 */
public class LowestCommonAncestor {
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();

    Node lca = lowestCommonAncestor(root, 12, 14);
    System.out.print(lca.getData());
  }

  /**
   * Note that the above method assumes that keys are present in Binary Tree. If one key is present and other is absent, then it returns the present key as LCA (Ideally should have returned NULL).
   * We can extend this method to handle all cases by passing two boolean variables v1 and v2. v1 is set as true when n1 is present in tree and v2 is set as true if n2 is present in tree.
   *
   * To handle this case have two static boolean values to track n1, n2 found status. In the end if both booleans are true then return node else return null.
   */
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
