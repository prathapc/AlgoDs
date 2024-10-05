package com.practice.E_java;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by prathapchowdary on 18/11/23.
 */
public class TimerDemo {

    public static void main(String[] args) {
        System.out.println("demo start");
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 10000) {}
        System.out.println("10sec wait is over");
        //in above program while we are waiting for 10s one cpu core is completely utilised; we can check the same in activity monitor cpu utilization

        //better way to do this with out making cpu core busy for 10s is as follows
        System.out.println("demo start");
        Timer timer = new Timer();
        long delayMilliSec = 10000;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("10sec wait is over");
                timer.cancel();
            }
        }, delayMilliSec);

    }

}
