package com.practice.A_ds.C_linkedlist;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 * Created by prathapchowdary on 15/10/21.
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
 * 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> NULL
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class B_SwapNodesInPairs {

    //beats 100%
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode curr = head, next = curr.next;
        ListNode temp = next.next;

        next.next = curr;
        curr.next = swapPairs(temp);

        return next;
    }

    public static void main(String args[]) {
        ListNode head = Utility.createLinkedList();
        Utility.printLinkedList(head);
        Utility.printLinkedList(swapPairs2(head));
        Utility.printLinkedList(swapPairs(head));
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode newHead = head.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = cur.next;

            cur.next = tmp;
            cur = tmp.next;
            if (cur != null && cur.next != null) tmp.next = cur.next;
        }
        return newHead;
    }

    public static ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy.next;

        while (p2 !=null && p2.next != null) {
            p1.next = p2.next;
            p2.next = p1.next.next;
            p1.next.next = p2;

            p1 = p2;
            p2 = p2.next;
        }

        return dummy.next;
    }
}
