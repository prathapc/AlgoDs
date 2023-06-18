package com.practice.A_ds.C_linkedlist;

/**
 * Created by prathapchowdary on 17/06/23.
 *
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
public class F_DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;

        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
