package com.practice.java.Async;

/**
 * Created by Prathap on 28 Apr, 2019
 */
public class Test2 {

    public String test2method1() {
        System.out.println("test2method1 : " + Thread.currentThread().getName());
        sleep(5000);
        return "test2method1";
    }


    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
}
