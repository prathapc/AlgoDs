package com.practice.A_ds.C_linkedlist;

/**
 * Created by Prathap on 10 Nov, 2019
 */
public class H_MergeTwoSortedLists {

    public static void main(String args[]) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(4);

        Node node2 = new Node(5);
        node2.next = new Node(6);
        node2.next.next = new Node(4);

        //using dummy node
        printList(mergeLists1(node1, node2));

        //using recursion
        printList(mergeLists2(node1, node2));
    }

    private static Node mergeLists2(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        if (l1.data < l2.data) {
            l1.next = mergeLists2(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeLists2(l1, l2.next);
            return l2;
        }
    }

    private static Node mergeLists1(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }

        if(l1!=null){
            dummy.next = l1;
        }

        if(l2!=null){
            dummy.next = l2;
        }

        return curr.next;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            super();
            this.data = data;
        }
    }

}
