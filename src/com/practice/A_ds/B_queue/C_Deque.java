package com.practice.A_ds.B_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathapchowdary on 25/04/22.
 */
public class C_Deque {
    public static void main(String args[]) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        System.out.println(deque);

        deque.add(4); // equivalent to addLast() // add in the end
        deque.poll(); // equivalent to pollFirst() //returns null if queue is empty
        deque.pollLast();

        System.out.println(deque);
    }
}
