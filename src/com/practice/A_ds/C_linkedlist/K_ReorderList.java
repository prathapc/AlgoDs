package com.practice.A_ds.C_linkedlist;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 * Created by prathapchowdary on 16/11/21.
 *
 * https://leetcode.com/problems/reorder-list/
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * 1 -> 5 -> 2 -> 4 -> 3 -> NULL
 */
public class K_ReorderList {

    public static void main(String args[]) {
        ListNode head = Utility.createLinkedList();
        Utility.printLinkedList(head);
        reorderList(head);
        Utility.printLinkedList(head);
    }

    public static void reorderList(ListNode head) {
        //break into two lists
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head, l2 = slow.next;
        slow.next = null;  //this must be set to null; otherwise cycle in output

        //reverse second list
        ListNode prev = null, curr = l2;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }
        l2 = prev;

        //merge two lists
        while (l2 != null) {
            ListNode tempL1 = l1.next;
            l1.next = l2;

            l1 = l2;
            l2 = tempL1;
        }
    }

}
