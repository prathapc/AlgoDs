package com.practice.A_ds.C_linkedlist;

/**
 * Created by prathap on 04/10/17.
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class G_IntersectionNode {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = length(headA), lenB = length(headB);

    // move headA and headB to the same start point
    while (lenA > lenB) {
      headA = headA.next;
      lenA--;
    }
    while (lenA < lenB) {
      headB = headB.next;
      lenB--;
    }

    // find the intersection until end
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }

  private int length(ListNode node) {
    int length = 0;
    while (node != null) {
      node = node.next;
      length++;
    }
    return length;
  }
}
