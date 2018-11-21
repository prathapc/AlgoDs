package com.practice.ds.queue;

import java.util.PriorityQueue;

//binary heap
public class PriorityQueueDemo {

  public static void main(String args[]) {
    PriorityQueue<String> pq = new PriorityQueue<String>();
    pq.add("2");
    pq.add("4");
    System.out.println(pq); //prints [2, 4]
    System.out.println(pq.peek()); //peek 2
    pq.offer("1");
    System.out.println(pq); // prints [1, 4, 2]
    System.out.println(pq.peek()); //peek 1
    pq.add("3");
    System.out.println(pq); // prints [1, 3, 2, 4]
    System.out.println(pq.peek()); //peek 1
  }
}
