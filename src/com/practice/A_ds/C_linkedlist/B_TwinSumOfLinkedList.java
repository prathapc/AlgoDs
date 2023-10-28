package com.practice.A_ds.C_linkedlist;

import java.util.Stack;

/**
 * Created by prathapchowdary on 17/05/23.
 *
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known
 * as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 *
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
 * These are the only nodes with twins for n = 4.
 *
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */
public class B_TwinSumOfLinkedList {

    //simpler sol using stack :)
    public int pairSum(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        int max = Integer.MIN_VALUE;
        while (slow != null) {
            max = Math.max(max, slow.val+stack.pop().val);
            slow = slow.next;
        }
        return max;
    }

    public int pairSum1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next, prev = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;

            prev = slow;
            slow = next;
        }

        ListNode start = head;
        int maxSum = 0;
        while (prev != null) {
            maxSum = Math.max(maxSum, start.val+prev.val);
            prev = prev.next;
            start = start.next;
        }

        return maxSum;
    }

    //simple solution using linkedlist
    /*public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int max = 0, n = list.size();
        for (int i=0; i<n; i++) {
            max = Math.max(max, list.get(i) + list.get(n-1-i));
        }
        return max;
    }*/
}
