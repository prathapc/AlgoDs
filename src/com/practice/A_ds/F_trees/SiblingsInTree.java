package com.practice.A_ds.F_trees;

import com.practice.C_ps.Utility;

/**
 * Created by prathap on 22/08/17.
 */
public class SiblingsInTree {

  public static void main(String args[]) {
    TreeNode root = Utility.createSampleTree();
    printNoSiblingNode(root);
  }

  private static void printNoSiblingNode(TreeNode root) {
    if(root == null) {
      return;
    }

    if(root.left != null && root.right != null) {
      printNoSiblingNode(root.left);
      printNoSiblingNode(root.right);
    } else if(root.left != null) {
      System.out.print(root.val + " ");
      printNoSiblingNode(root.left);
    } else if(root.right != null) {
      System.out.print(root.val + " ");
      printNoSiblingNode(root.right);
    }
  }

}
