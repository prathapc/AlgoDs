package com.practice.java;

/**
 * Created by prathap on 04/08/17.
 */
public class MultiThreadingExample {
  public static void main(String args[]) {
    Task1 task1 = new Task1();
    task1.start();
    Task2 task2 = new Task2();
    task2.start();
  }
}

class Task1 extends Thread {
  public void run(){
    for(int i=0; i<10; i++) {
      try {
        Thread.sleep(1000);
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Thread1: "+ i);
    }
  }
}

class Task2 extends Thread {
  public void run() {
    for(int i=0; i<10; i++) {
      try {
        Thread.sleep(500);
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Thread2: "+ i);
    }
  }
}