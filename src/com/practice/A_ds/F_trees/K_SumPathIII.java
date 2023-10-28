package com.practice.A_ds.F_trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by prathapchowdary on 18/06/23.
 *
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 * https://leetcode.com/problems/path-sum-iii/
 */
public class K_SumPathIII {
    //failing for one test case
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumUtil(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumUtil(TreeNode node, int sum) {
        if (node == null) return 0;
        int count = pathSumUtil(node.left, sum-node.val) + pathSumUtil(node.right, sum-node.val);
        if (node.val == sum) count++;
        return count;
    }

    //passes all cases - prefix sum
    int count = 0;
    public int pathSum1(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        solve(root, targetSum, 0L, map);
        return count;
    }
    private void solve(TreeNode root, int targetSum, long sum, Map<Long, Integer> map){
        if(root==null){
            return;
        }
        sum = sum + root.val;
        long required = sum-targetSum;
        if(map.containsKey(required)){
            count = count + map.get(required);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        solve(root.left, targetSum, sum, map);
        solve(root.right, targetSum, sum, map);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }



    //100/120 cases passed; failing for below ex, fix it.
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        root.right = r1;
        TreeNode r2 = new TreeNode(3);
        r1.right = r2;
        TreeNode r3 = new TreeNode(4);
        r2.right = r3;
        TreeNode r4 = new TreeNode(5);
        r3.right = r4;
        pathSum_bfs(root, 3);
    }
    public static int pathSum_bfs(TreeNode root, int targetSum) {
        int count = 0;
        if (root == null) return count;
        Queue<Data> bfs = new LinkedList<>();
        bfs.offer(new Data(root, root.val));
        while (!bfs.isEmpty()) {
            Data curr = bfs.poll();
            if (curr.sum == targetSum) count++;
            if (curr.node.left != null) {
                bfs.offer(new Data(curr.node.left, curr.sum + curr.node.left.val));
                bfs.offer(new Data(curr.node.left, curr.node.left.val));
            }
            if (curr.node.right != null) {
                bfs.offer(new Data(curr.node.right, curr.sum + curr.node.right.val));
                bfs.offer(new Data(curr.node.right, curr.node.right.val));
            }
        }
        return count;
    }
    static class Data {
        TreeNode node;
        int sum;
        public Data(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
}
