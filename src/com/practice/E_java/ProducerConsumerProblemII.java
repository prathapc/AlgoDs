package com.practice.E_java;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by prathap on 04/08/17.
 */
public class ProducerConsumerProblemII {
  public static void main(String[] args) {
    BlockingDeque blockingDeque = new LinkedBlockingDeque(5);
    Producer producer = new Producer(blockingDeque);
    producer.start();

    Consumer consumer = new Consumer(blockingDeque);
    consumer.start();

    Consumer2 consumer2 = new Consumer2(blockingDeque);
    consumer2.start();
  }

  static class Producer extends Thread {
    BlockingDeque sharedQueue;
    Producer(BlockingDeque sharedQueue) {
      this.sharedQueue = sharedQueue;
    }

    public void run() {
      for(int i=0; i<10; i++) {
        System.out.println("Producing: "+i);
        sharedQueue.offer(i);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class Consumer extends Thread {
    BlockingDeque sharedQueue;
    Consumer(BlockingDeque sharedQueue) {
      this.sharedQueue = sharedQueue;
    }

    public void run() {
      while(true) {
        try {
          System.out.println("Consuming: "+sharedQueue.take().toString());
          /*try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }*/
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class Consumer2 extends Thread {
    BlockingDeque sharedQueue;
    Consumer2(BlockingDeque sharedQueue) {
      this.sharedQueue = sharedQueue;
    }

    public void run() {
      while(true) {
        try {
          System.out.println("Consuming2: "+sharedQueue.take().toString());
          /*try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }*/
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}


