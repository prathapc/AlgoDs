package com.practice.B_algo.F_greedy;

import java.util.*;

/**
 * Created by Prathap on 22 Oct, 2019
 *
 * In Activity Selection Problem, we’re given a set of activities and the starting & finishing time of each activity,
 * we need to find the maximum number of activities that can be performed by a single person assuming that
 * a person can only work on a single activity at a time.
 *
 * i/p:-
 * (1, 4), (3, 5), (0, 6), (5, 7), (3, 8), (5, 9), (6, 10), (8, 11), (8, 12), (2, 13), (12, 14)
 * o/p:-
 * (1 4), (5 7), (8 11), (12 14)
 *
 * https://www.techiedelight.com/activity-selection-problem/
 *
 */
public class B_ActivitySelectionProblem {
    // Activity-Selection problem
    public static Set<Integer> selectActivity(List<Pair> activities)
    {
        // k keeps track of the index of the last selected activity
        int k = 0;

        // set to store the selected activities index
        Set<Integer> out = new HashSet<>();

        // select 0 as first activity
        out.add(0);

        // start iterating from the second element of
        // vector up to its last element
        for (int i = 1; i < activities.size(); i++) {
            // if start time of i'th activity is is greater or equal
            // to the finish time of the last selected activity, it
            // can be included in activities list
            if (activities.get(i).getStart() >= activities.get(k).getFinish())
            {
                out.add(i);
                k = i;	// update i as last selected activity
            }
        }

        return out;
    }

    public static void main(String[] args)
    {
        // list of given jobs. Each job has an identifier, a deadline and
        // profit associated with it
        List<Pair> activities = Arrays.asList(new Pair(1, 4), new Pair(3, 5),
                new Pair(0, 6), new Pair(5, 7), new Pair(3, 8),
                new Pair(5, 9), new Pair(6, 10), new Pair(8, 11),
                new Pair(8, 12), new Pair(2, 13), new Pair(12, 14));

        // Sort the activities according to their finishing time
        Collections.sort(activities, (a, b) -> a.getFinish() - b.getFinish());

        Set<Integer> res = selectActivity(activities);

        for (Integer i: res) {
            System.out.println(activities.get(i));
        }
    }
}

// Simple pair class to store the start time and finish time
// of the activities
class Pair
{
    private int start, finish;

    public Pair(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public int getFinish() {
        return finish;
    }

    public int getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "{" + getStart() + ", " + getFinish() + "}";
    }
};
