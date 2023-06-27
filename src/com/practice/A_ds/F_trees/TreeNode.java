package com.practice.A_ds.F_trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathapchowdary on 19/11/21.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, com.practice.A_ds.F_trees.TreeNode left, com.practice.A_ds.F_trees.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /*public static TreeNode buildTree(String[] input) {
        if (input.length == 0) return null;
        Queue<String> queue = new LinkedList<>();
        for (String inputNode : input) {
            queue.offer(inputNode);
        }
        return deserialise(queue);
    }

    private static TreeNode deserialise(Queue<String> q) {
        String val = q.poll();
        if ("null".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserialise(q);
        root.right = deserialise(q);
        return root;
    }*/

    static StringBuilder sbr;
    static String splitter=",";
    static String nullString="null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sbr = new StringBuilder();
        serializeHelper(root);
        return sbr.toString();
    }
    public void serializeHelper(TreeNode root){
        if(root == null){
            sbr.append(nullString).append(splitter);
            return;
        }
        sbr.append(root.val).append(splitter);
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(splitter)));
        return deserializeHelper(q);
    }
    public static TreeNode deserializeHelper(Queue<String> q){
        String val = q.poll();

        if(val.equals(nullString))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserializeHelper(q);
        root.right = deserializeHelper(q);
        return root;
    }
}
