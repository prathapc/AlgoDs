package com.practice.ds.arrays;

/**
 * Created by prathap on 26/09/17.
 */
public class QueuePrograms {
  public static void main(String args[]) {
    Queue queue = new Queue(1);
    queue.push(1);
    queue.push(2);
    queue.pop();
  }
}

class Queue {
  int size;
  int a[];
  int front;
  int rear;

  public Queue(int initialSize) {
    a= new int[initialSize];
    size = initialSize;
    front = 0;
    rear = -1;
  }

  public void push(int i) {
    ensureCapacity();
    rear++;
    a[rear] = i;
  }

  public int pop() {
    front++;
    return a[front];
  }

  private void ensureCapacity() {
    if(rear+1 >= size) {
      int b[] = new int[size*2];
      for(int i=front; i<rear; i++) {
        b[i] = a[i];
      }
      size *= 2;
      a = b;
    }
  }
}
