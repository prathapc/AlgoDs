package com.practice.ps.leetcode;

import java.util.*;

/**
 * Created by Prathap on 28 Jan, 2020
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *          7
 *       3     15
 *           9    20
 *
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 */

class P173_BinarySearchTreeIterator {

    Stack<TreeNode> stack;
    TreeNode node;

    public P173_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null && root.left != null) {
            stack.push(root);
            root = root.left;
        }
        node = root;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = node;
        if (node.right != null) {
            stack.push(node);
            node = node.right;
            while(node.left != null) {
                stack.push(node);
                node = node.left;
            }
            return ret.val;
        }
        while(!stack.isEmpty() && stack.peek().right == node) {
            node = stack.pop();
        }
        node = stack.isEmpty() ? null : stack.pop();

        return ret.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node != null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

