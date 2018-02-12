package com.practice.ds.trees;

import com.practice.util.Utility;

/**
 * Created by prathap on 29/12/17.
 */
public class LowestCommonAncestor {
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();

    Node lca = lowestCommonAncestor(root, 12, 23);
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





  /*TreeNode root;
  static boolean v1 = false, v2 = false;

  // This function returns pointer to LCA of two given
  // values n1 and n2.
  // v1 is set as true by this function if n1 is found
  // v2 is set as true by this function if n2 is found
  Node findLCAUtil(TreeNod node, int n1, int n2)
  {
    // Base case
    if (node == null)
      return null;

    // If either n1 or n2 matches with root's key, report the presence
    // by setting v1 or v2 as true and return root (Note that if a key
    // is ancestor of other, then the ancestor key becomes LCA)
    if (node.data == n1)
    {
      v1 = true;
      return node;
    }
    if (node.data == n2)
    {
      v2 = true;
      return node;
    }

    // Look for keys in left and right subtrees
    TreeNode left_lca = findLCAUtil(node.left, n1, n2);
    TreeNode right_lca = findLCAUtil(node.right, n1, n2);

    // If both of the above calls return Non-NULL, then one key
    // is present in once subtree and other is present in other,
    // So this node is the LCA
    if (left_lca != null && right_lca != null)
      return node;

    // Otherwise check if left subtree or right subtree is LCA
    return (left_lca != null) ? left_lca : right_lca;
  }

  // Finds lca of n1 and n2 under the subtree rooted with 'node'
  TreeNode findLCA(int n1, int n2)
  {
    // Initialize n1 and n2 as not visited
    v1 = false;
    v2 = false;

    // Find lca of n1 and n2 using the technique discussed above
    TreeNode lca = findLCAUtil(root, n1, n2);

    // Return LCA only if both n1 and n2 are present in tree
    if (v1 && v2)
      return lca;

    // Else return NULL
    return null;
  }*/
}
