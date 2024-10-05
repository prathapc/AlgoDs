package com.practice.A_ds.F_trees.c_segment;

/**
 * Created by prathapchowdary on 28/10/23.
 *
 * Used in range queries and point updates. Let's say we have to update a value at an index in an array and
 * also find sum of a range in an array, BOTH of these can not be done in log(n) time unless we use segment trees
 */
public class A_SegmentTree {
    A_SegmentTree left, right;
    int start, end, val;
    public A_SegmentTree(int start, int end) {
        this.start = start;
        this.end = end;
        setup(this, start, end);
    }
    public void setup(A_SegmentTree node, int start, int end) {
        if (start == end) return;
        int mid = start + (end - start) / 2;
        if (node.left == null) {
            node.left = new A_SegmentTree(start, mid);
            node.right = new A_SegmentTree(mid + 1, end);
        }
        setup(node.left, start, mid);
        setup(node.right, mid + 1, end);
        node.val = Math.max(node.left.val, node.right.val);
    }

    public void update(A_SegmentTree node, int index, int val) {
        if (index < node.start || index > node.end) return;
        if (node.start == node.end && node.start == index) {
            node.val = val;
            return;
        }
        update(node.left, index, val);
        update(node.right, index, val);
        node.val = Math.max(node.left.val, node.right.val);
    }


    public int rangeMaxQuery(A_SegmentTree node, int start, int end) {
        if (node.start > end || node.end < start) return 0;
        if (node.start >= start && node.end <= end) return node.val;
        return Math.max(rangeMaxQuery(node.left, start, end), rangeMaxQuery(node.right, start, end));
    }
}
