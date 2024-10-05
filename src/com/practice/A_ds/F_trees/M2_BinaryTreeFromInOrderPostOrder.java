package com.practice.A_ds.F_trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 09/07/23.
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class M2_BinaryTreeFromInOrderPostOrder {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; ++i)
      inorderIndexMap.put(inorder[i], i);
    return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inorderIndexMap);
  }

  private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderIndexMap) {
    if (postStart > postEnd) return null;

    int rootVal = postorder[postEnd];
    int rootIndexInInorder = inorderIndexMap.get(rootVal);
    int leftSize = rootIndexInInorder - inStart;

    TreeNode root = new TreeNode(rootVal);
    root.left = build(inorder, inStart, rootIndexInInorder-1,
        postorder, postStart, postStart+leftSize-1, inorderIndexMap);
    root.right = build(inorder, rootIndexInInorder+1, inEnd,
        postorder, postStart+leftSize, postEnd-1, inorderIndexMap);
    return root;
  }
}
