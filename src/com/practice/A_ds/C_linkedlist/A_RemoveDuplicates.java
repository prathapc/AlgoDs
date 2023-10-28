package com.practice.A_ds.C_linkedlist;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 * Created by prathapchowdary on 15/10/21.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class A_RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = head, next = head.next;
        while (next != null) {
            if (node.val == next.val) {
                node.next = next.next;
            } else {
                node = next;
            }
            next = node.next;
        }
        return head;
    }

    //recursive solution
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates1(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
