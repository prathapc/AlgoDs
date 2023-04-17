package com.practice.A_ds.C_linkedlist;

import com.practice.B_algo.A_sort_search_math.Utility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by prathapchowdary on 15/10/21.
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
 * 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> NULL
 */
public class B_SwapNodes {

    public static void main(String args[]) {
        ListNode head = Utility.createLinkedList();
        Utility.printLinkedList(head);
        Utility.printLinkedList(swapPairs(head));
        Utility.printLinkedList(swapNodes_recursion(head));
    }

    public static ListNode swapPairs(ListNode head) {
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

    private static ListNode swapNodes_recursion(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapNodes_recursion(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

}
