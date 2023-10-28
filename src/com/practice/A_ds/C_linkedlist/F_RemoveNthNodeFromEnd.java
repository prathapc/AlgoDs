package com.practice.A_ds.C_linkedlist;

import java.util.List;

/**
 * Created by prathap on 27/12/17.
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 */
public class F_RemoveNthNodeFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int size = size(head);
    int toRemove = size - n;
    //if (toRemove == 0) return head.next; //special case of handling removal of first node from beginning
    ListNode temp = dummy; //observe, we are taking dummy (not head) as temp so that we can delete first node as well
    while (toRemove-- > 0) {
      temp = temp.next;
    }
    temp.next = temp.next.next;
    return dummy.next;
  }

  private int size(ListNode node) {
    int s = 0;
    while (node != null) {
      node = node.next;
      s++;
    }
    return s;
  }

  //another way
  public static ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy, second = dummy;
    for (int i=0; i<=n; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }

}
