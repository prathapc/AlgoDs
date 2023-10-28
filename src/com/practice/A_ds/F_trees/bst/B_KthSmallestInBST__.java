package com.practice.A_ds.F_trees.bst;

import com.practice.A_ds.F_trees.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by prathapchowdary on 08/07/23.
 * <p>
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 * <p>
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class B_KthSmallestInBST__ {

    int res = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallest(root);
        return res;
    }

    private void kthSmallest(TreeNode root) {
        if (root.left != null) {
            kthSmallest(root.left);
        }
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        if (root.right != null) {
            kthSmallest(root.right);
        }
    }

    //keep going left while saving nodes in stack so that you can search right if you dont find on left
    private int kthSmallestInBst(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int count = 0;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                if (++count == k) {
                    return temp.val;
                }
                node = temp.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    //not so efficient
    public int kthSmallest_1(TreeNode root, int k) {
        List<Integer> inOrderList = new ArrayList<>();
        inorder(root, inOrderList);
        return inOrderList.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }
        inorder(root.left, inOrderList);
        inOrderList.add(root.val);
        inorder(root.right, inOrderList);
    }

}
