package com.practice.B_algo_ps.F_bfs_dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by prathapchowdary on 21/01/22.
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 *
 * https://leetcode.com/problems/remove-invalid-parentheses
 */
public class Z_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;
        boolean reached = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                // Valid
                if (isValid(cur)) {
                    reached = true;
                    res.add(cur);
                }
                // Not Valid Then Delete
                if (!reached) {
                    for (int j = 0; j < cur.length(); j++) {
                        if (cur.charAt(j) != '(' && cur.charAt(j) != ')') continue;
                        String newStr = cur.substring(0, j) + cur.substring(j + 1);
                        if (!visited.contains(newStr)) {
                            queue.add(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
            if (reached) break;
        }
        return res;
    }

    // helper function checks if string s contains valid parantheses
    private boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }

    /**
     * The idea is straightforward, with the input string s, we generate all possible states by removing one ( or ),
     * check if they are valid, if found valid ones on the current level, put them to the final result list and we are done,
     * otherwise, add them to a queue and carry on to the next level.
     *
     * The good thing of using BFS is that we can guarantee the number of parentheses that need to be removed is minimal,
     * also no recursion call is needed in BFS.
     *
     * Time complexity:
     *
     * In BFS we handle the states level by level, in the worst case, we need to handle all the levels,
     * we can analyze the time complexity level by level and add them up to get the final complexity.
     *
     * On the first level, there's only one string which is the input string s, let's say the length of it is n,
     * to check whether it's valid, we need O(n) time. On the second level, we remove one ( or ) from the first level,
     * so there are C(n, n-1) new strings, each of them has n-1 characters, and for each string, we need to check whether it's valid or not,
     * thus the total time complexity on this level is (n-1) x C(n, n-1).
     * Come to the third level, total time complexity is (n-2) x C(n, n-2), so on and so forth...
     *
     * Finally we have this formula:
     *
     * T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
     */
}
