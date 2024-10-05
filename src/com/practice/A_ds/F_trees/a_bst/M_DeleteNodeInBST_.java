package com.practice.A_ds.F_trees.a_bst;

import com.practice.A_ds.F_trees.TreeNode;

/**
 * Created by prathapchowdary on 09/04/22.
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class M_DeleteNodeInBST_ {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
