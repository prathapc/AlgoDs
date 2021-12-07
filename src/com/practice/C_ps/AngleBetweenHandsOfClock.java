package com.practice.C_ps;

/**
 * Created by Prathap on 08 Feb, 2020
 */
public class AngleBetweenHandsOfClock {
    public static void main(String args[]) {
        int h=3, m=15;
        if (h <0 || m < 0 || h >12 || m > 60)
            System.out.println("Wrong input");

        if (h == 12)
            h = 0;
        if (m == 60)
            m = 0;

        double hour_angle = 0.5 * (h * 60 + m);
        double minute_angle = 6*m;

        double angle = Math.abs(hour_angle - minute_angle);
        angle = Math.min(360-angle, angle);

        System.out.println(angle);
    }
}
