package com.practice.B_algo.B_arrays;

import com.practice.A_ds.C_linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * Created by prathapchowdary on 24/04/22.
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class H_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode root : lists) {
            while (root != null) {
                minHeap.add(root.val);
                root = root.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }

        return dummy.next;
    }

    //The complexity of this problem is O(knlogk), no algorithm can run it O(nlogk).
    // We have T(n) = 2T(n/2) + kn, and therefore, O(kn*logk).
    //Or you can think about the complexity on each node and expand.
    // For each node, the complexity is O(logk), which is the complexity for adding to the PQ,
    // and there are k*n that many of nodes, which gives us O(knlogk).
}
