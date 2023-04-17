package com.practice.A_ds.B_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by prathap on 13/10/17.
 */
public class B_QueueWithTwoStacks {
  public static class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();

    public void enqueue(T value) { // Push onto newest stack
      stackNewestOnTop.push(value);
    }

    public T peek() {
      if(stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
        return null;
      } else if(stackOldestOnTop.isEmpty()) {
        while(!stackNewestOnTop.isEmpty()) {
          stackOldestOnTop.push(stackNewestOnTop.pop());
        }
      }
      return stackOldestOnTop.peek();
    }

    public T dequeue() {String s;
      if(stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
        return null;
      } else if(stackOldestOnTop.isEmpty()) {
        while(!stackNewestOnTop.isEmpty()) {
          stackOldestOnTop.push(stackNewestOnTop.pop());
        }
      }
      return stackOldestOnTop.pop();
    }
  }


  public static void main(String[] args) {
    B_QueueWithTwoStacks.MyQueue<Integer> queue = new B_QueueWithTwoStacks.MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }

  /*
  private Stack<Integer> s1 = new Stack<>();
  private Stack<Integer> s2 = new Stack<>();

  public void push(int x) {
    s1.push(x);
  }

  public int pop() {
    if (s2.isEmpty()) {
      while (!s1.isEmpty())
        s2.push(s1.pop());
    }
    return s2.pop();
  }

  public int peek() {
    if (!s2.isEmpty()) {
      return s2.peek();
    } else {
      while (!s1.isEmpty())
        s2.push(s1.pop());
    }
    return s2.peek();
  }

  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }
   */
}
