package com.practice.ds.stack;


/**
 * Created by prathap on 13/07/17.
 */
public class StackImplementation {

  public static void main(String args[]) {
    Stack stack = new Stack(1);
    stack.push(2);
    stack.push(3);
    stack.pop();
  }
}

class Stack {
  int len;
  int top;
  int a[];

  Stack(int size) {
    this.len = size;
    a = new int[size];
    top = -1;
  }

  public int size() {
    return len;
  }

  public boolean isEmpty() {
    return top==-1;
  }

  public boolean isFull() {
    return top==len-1;
  }

  public void push(int i) {
    ensureCapacity();
    a[++top] = i;
  }

  public int pop() {
    return a[--top];
  }

  public int peek() {
    return a[top];
  }

  private void ensureCapacity() {
    if(top+1 >= len) {
      int b[] = new int[len*2];
      for(int i=0; i<len; i++) {
        b[i] = a[i];
      }
      a = b;
      len *= 2;
    }
  }
}

