package com.practice.A_ds.F_trees.a_bst;

import com.practice.A_ds.F_trees.TreeNode;

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

/**
 * simple solution (O(n) space:
 class BSTIterator {
    List<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        inorder(root);
        this.index = -1;
        System.out.println(list);
    }

    public int next() {
        index++;
        return list.get(index);
    }
    public boolean hasNext() {
        if(index>=list.size()-1) return false;
        else return true;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
 }
 */

class O_BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public O_BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}