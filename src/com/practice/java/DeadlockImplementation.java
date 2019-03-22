package com.practice.java;

public class DeadlockImplementation {

  static class Shared {
    synchronized void test1(Shared s2) {
      System.out.println("test1 begin..");
      sleep(1000);
      s2.test2(this);
      System.out.println("test1 end.");
    }

    synchronized void test2(Shared s1) {
      System.out.println("test2 begin..");
      sleep(1000);
      s1.test1(this);
      System.out.println("test2 end.");
    }
  }

  static class Thread1 extends Thread {
    private Shared s1;
    private Shared s2;

    public Thread1(Shared s1, Shared s2) {
      this.s1 = s1;
      this.s2 = s2;
    }

    @Override
    public void run() {
      s1.test1(s2);
    }
  }

  static class Thread2 extends Thread {
    private Shared s1;
    private Shared s2;

    public Thread2(Shared s1, Shared s2) {
      this.s1 = s1;
      this.s2 = s2;
    }

    @Override
    public void run() {
      s2.test2(s1);
    }

  }

  static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Test {
  public static void main() {
    DeadlockImplementation.Shared s1 = new DeadlockImplementation.Shared();
    DeadlockImplementation.Shared s2 = new DeadlockImplementation.Shared();

    DeadlockImplementation.Thread1 t1 = new DeadlockImplementation.Thread1(s1, s2);
    t1.start();

    DeadlockImplementation.Thread2 t2 = new DeadlockImplementation.Thread2(s1, s2);
    t2.start();
  }
}
