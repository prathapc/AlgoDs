package com.practice.A_ds.C_linkedlist;

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

    //non-recursive
    public ListNode reverseKGroup_1(ListNode head, int k) {
        if (head==null||head.next==null||k<2) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy,temp;
        int count;
        while(true){
            count =k;
            while(count>0&&tail!=null){
                count--;
                tail=tail.next;
            }
            if (tail==null) break;//Has reached the end


            head=prev.next;//for next cycle
            // prev-->temp-->...--->....--->tail-->....
            // Delete @temp and insert to the next position of @tail
            // prev-->...-->...-->tail-->head-->...
            // Assign @temp to the next node of @prev
            // prev-->temp-->...-->tail-->...-->...
            // Keep doing until @tail is the next node of @prev
            while(prev.next!=tail){
                temp=prev.next;//Assign
                prev.next=temp.next;//Delete

                temp.next=tail.next;
                tail.next=temp;//Insert

            }

            tail=head;
            prev=head;

        }
        return dummy.next;

    }



    public ListNode reverseKGroup(ListNode head, int k) {
        int n = getLength(head);
        int groups = n/k;
        return reverseKGroups(head, k, groups, 1);
    }

    private ListNode reverseKGroups(ListNode node, int k, int groups, int currGroup) {
        if (currGroup > groups) {
            return node;
        }
        int temp = 0;
        ListNode prev = null, curr = node, next = null;
        while (curr != null && temp++ < k) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        if (next != null) {
            node.next = reverseKGroup(next, k);
        }
        return prev;
    }

    private int getLength(ListNode node) {
        int l = 0;
        while (node != null) {
            node = node.next;
            l++;
        }
        return l;
    }
}
