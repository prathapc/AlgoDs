package com.practice.A_ds.C_linkedlist;

import com.practice.B_algo.A_sort_search_math.Utility;

/**
 * Created by prathapchowdary on 11/09/21.
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Similar to prev problem, but count total nodes first and exit the last batch if no of nodes < k
 */
public class E_ReverseInGroupsII {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t = head;
        int l = 0;
        while (t != null) {
            t = t.next;
            l++;
        }

        return reverseKGroupUtil(head, k, l/k, 1);

    }

    public ListNode reverseKGroupUtil(ListNode head, int k, int l, int cl) {
        if (cl > l) {
            return head;
        }

        ListNode curr = head, prev = null, next = null;
        int temp = 0;
        while (temp < k && curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

            temp++;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}
