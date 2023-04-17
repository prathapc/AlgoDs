package com.practice.B_algo.A_sort_search_math.math;

/**
 * Created by Prathap on 08 Feb, 2020
 * 
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */
public class J_AngleBetweenHandsOfClock {
    public double angleClock(int hour, int minutes) {
        int oneMinAngle = 6;
        int oneHourAngle = 30;

        double minutesAngle = oneMinAngle * minutes;
        double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

        double diff = Math.abs(hourAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }
}
