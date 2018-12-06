package com.practice.java;

public class StaticSynchronization {

  public static void main(String[] args) {
    Person p1 =new Person();
    p1.start();

    Person p2 =new Person();
    p2.drink();
  }

  static class Person extends Thread {

    public static synchronized void eat() {
      try {
        System.out.println("eat");
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public void drink() {
      try {
        System.out.println("drink");
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    public void run() {
      eat();
      //drink();
    }
  }

}
