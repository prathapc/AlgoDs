package com.practice.java;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by prathap on 04/08/17.
 */
public class ProducerConsumerProblem {
  public static void main(String[] args) {
    BlockingDeque blockingDeque = new LinkedBlockingDeque();
    Producer producer = new Producer(blockingDeque);
    producer.start();

    Consumer consumer = new Consumer(blockingDeque);
    consumer.start();
  }

  static class Producer extends Thread {
    BlockingDeque sharedQueue;
    Producer(BlockingDeque sharedQueue) {
      this.sharedQueue = sharedQueue;
    }

    public void run() {
      for(int i=0; i<10; i++) {
        System.out.println("Producing: "+i);
        sharedQueue.add(i);
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
          System.out.println("Consuming: "+sharedQueue.take());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}


