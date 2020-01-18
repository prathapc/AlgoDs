package com.practice.java;

import java.util.*;

/**
 * Created by Prathap on 17 Jan, 2020
 */
public class ComparatorWithArrayList {

    static class Interval {
        Date start;
        Date end;

        public Interval(Date start, Date end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String args[]) {
        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(new Date(), new Date());
        Interval i2 = new Interval(new Date(), new Date());

        intervals.add(i1);
        intervals.add(i2);

        //sort by end time
        Collections.sort(intervals, Comparator.comparing(i -> i.end));
    }
}
