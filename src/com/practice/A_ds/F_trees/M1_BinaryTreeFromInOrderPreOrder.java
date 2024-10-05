package com.practice.A_ds.F_trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 01/07/23.
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class M1_BinaryTreeFromInOrderPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; ++i)
            inOrderIndex.put(inorder[i], i);

        return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, inOrderIndex);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inOrderIndex) {
        if (preStart > preEnd)
            return null;

        final int rootVal = preorder[preStart];
        final int rootIndexInInorder = inOrderIndex.get(rootVal);
        final int leftSize = rootIndexInInorder - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, rootIndexInInorder - 1,
            preorder, preStart + 1, preStart + leftSize, inOrderIndex);
        root.right = build(inorder, rootIndexInInorder + 1, inEnd,
            preorder, preStart + leftSize + 1, preEnd, inOrderIndex);

        return root;
    }
}
