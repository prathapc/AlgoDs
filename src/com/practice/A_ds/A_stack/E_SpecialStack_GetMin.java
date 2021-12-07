package com.practice.A_ds.A_stack;

/**
 * Created by prathap on 06/01/18.
 *
 * Ge min from stack in O(1) time and space
 */
public class E_SpecialStack_GetMin {
  public static void main(String[] args) {
    MyStack s = new MyStack();
    s.push(3);
    s.push(5);
    s.getMin();
    s.push(2);
    s.push(1);
    s.push(10);
    s.getMin();
    s.pop();
    s.getMin();
    s.pop();
    s.peek();
  }

  static class MyStack {
    java.util.Stack<Integer> s;
    Integer minEle;

    MyStack() { s = new java.util.Stack<Integer>(); }

    void getMin() {
      if (s.isEmpty())
        System.out.println("Stack is empty");
      else
        System.out.println("Minimum Element in the " +
            " stack is: " + minEle);
    }

    void peek() {
      if (s.isEmpty()) {
        System.out.println("Stack is empty ");
        return;
      }

      Integer t = s.peek();

      System.out.print("Top Most Element is: ");

      // If t < minEle means minEle stores
      // value of t.
      if (t < minEle)
        System.out.println(minEle);
      else
        System.out.println(t);
    }

    // Removes the top element from MyStack
    void pop()
    {
      if (s.isEmpty()) {
        System.out.println("Stack is empty");
        return;
      }

      System.out.print("Top Most Element Removed: ");
      Integer x = s.pop();

      // Minimum will change as the minimum element
      // of the stack is being removed.
      if (x < minEle) {
        System.out.println(minEle);
        minEle = 2*minEle - x;
      } else {
        System.out.println(x);
      }
    }

    void push(Integer x) {
      if (s.isEmpty()) {
        minEle = x;
        s.push(x);
        System.out.println("Number Inserted: " + x);
        return;
      }
//10 9 => 8
//8
      if (x < minEle) {
        s.push(2*x - minEle);
        minEle = x;
      } else
        s.push(x);
        System.out.println("Number Inserted: " + x);
      }
  }
}


