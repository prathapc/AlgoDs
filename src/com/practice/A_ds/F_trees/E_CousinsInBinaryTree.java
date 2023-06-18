package com.practice.A_ds.F_trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathapchowdary on 18/06/23.
 */
public class E_CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int count=0;
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();

                if (x == node.val || y == node.val) {
                    count++;
                }

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

                if(node.left!=null && node.right!=null){
                    if((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)){
                        return false;
                    }
                }
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
