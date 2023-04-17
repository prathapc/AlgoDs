package com.practice.A_ds.A_stack;


/**
 * Created by prathap on 13/07/17.
 */
public class A_StackImplementation {

  public static void main(String args[]) {
    Stack stack = new Stack(1);
    stack.push(2);
    stack.push(3);
    stack.pop();
  }

  static class Stack {
    int capacity;
    int topIndex;
    int a[];

    Stack(int size) {
      this.capacity = size;
      a = new int[size];
      topIndex = -1;
    }

    public int size() {
      return capacity;
    }

    public boolean isEmpty() {
      return topIndex ==-1;
    }

    public boolean isFull() {
      return topIndex == capacity -1;
    }

    public void push(int i) {
      ensureCapacity();
      a[++topIndex] = i;
    }

    public int pop() {
      return a[--topIndex];
    }

    public int peek() {
      return a[topIndex];
    }

    private void ensureCapacity() {
      if(topIndex +1 >= capacity) {
        int b[] = new int[capacity *2];
        for(int i = 0; i< capacity; i++) {
          b[i] = a[i];
        }
        a = b;
        capacity *= 2;
      }
    }
  }

}

