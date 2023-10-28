package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by prathapchowdary on 04/01/22.
 * https://leetcode.com/problems/simplify-path/
 * Input: path = "/home/"
 * Output: "/home"
 * Input: path = "/../"
 * Output: "/"
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 *
 * Input: "//home/../"
 * Output: "/"
 * Note: "home/../" is invalid input
 */
public class H_SimplifyCanonicalDirectoryPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] nodes = path.split("/");
        for (String node : nodes) {
            if (node.equals(".") || node.isEmpty()) {
                continue;
            } else if (node.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(node);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String node : stack) { //NOTE: not usual pop from top, instead using iterator from bottom
            result.append("/");
            result.append(node);
        }
        return result.length() > 0 ? result.toString() : "/";
    }
}
