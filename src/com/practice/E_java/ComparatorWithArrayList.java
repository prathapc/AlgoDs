package com.practice.E_java;

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
        System.out.print(intervals.toString());

        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("abc");
        names.add("ac");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.print(names);
    }
}
