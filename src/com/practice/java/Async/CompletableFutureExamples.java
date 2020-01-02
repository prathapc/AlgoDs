package com.practice.java.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Prathap on 26 Apr, 2019
 */
public class CompletableFutureExamples {

    public static void main(String args[]) {
        /*test();
        System.out.println("in main");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("All : " + Thread.getAllStackTraces().keySet().size());
        int nbRunning = 0;
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getState()==Thread.State.RUNNABLE) nbRunning++;
        }
        System.out.println("running: " + nbRunning);

        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        }).thenApply(result -> {

            return result;
        });*/

        //return;

    }

    private static void test() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("in future");
            return "Hello";
        });
    }
}
