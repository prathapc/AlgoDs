package com.practice.B_algo.A_sort_search_math.intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by prathapchowdary on 04/10/21.
 *
 * Job 1: (0, 6, 60)
 * Job 2: (1, 4, 30)
 * Job 3: (3, 5, 10)
 * Job 4: (5, 7, 30)
 * Job 5: (5, 9, 50)
 * Job 6: (7, 8, 10)
 *
 *
 * The maximum profit is 80, which is achieved by picking job 2 and Job 5.
 *
 * Approaches:
 * 1. findMaxProfit (using recursion) #exponential
 * 2. findMaxProfitDP (optimized with DP) #O(n^2)
 */
public class WeightedIntervalScheduling {

    // Function to find the maximum profit of non-overlapping jobs using DP
    public static int findMaxProfitDP(List<Job> jobs)
    {
        // sort jobs in increasing order of their finish times
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

        // get the number of jobs
        int n = jobs.size();

        // base case
        if (n == 0) {
            return 0;
        }

        // construct a lookup table where the i'th index stores the maximum profit
        // for the first `i` jobs
        int[] maxProfit = new int[n];

        // maximum profit gained by including the first job
        maxProfit[0] = jobs.get(0).profit;

        // fill the `maxProfit[]` table in a bottom-up manner from the second index
        for (int i = 1; i < n; i++)
        {
            // find the index of the last non-conflicting job with the current job
            int index = findLastNonConflictingJob(jobs, i);

            // include the current job with its non-conflicting jobs
            int incl = jobs.get(i).profit;
            if (index != -1) {
                incl += maxProfit[index];
            }

            // store the maximum profit by including or excluding the current job
            maxProfit[i] = Math.max(incl, maxProfit[i - 1]);
        }

        // return maximum profit
        return maxProfit[n - 1];
    }

    // A recursive function to find the maximum profit subset of non-overlapping
    // jobs, which are sorted according to finish time
    public static int findMaxProfit(List<Job> jobs, int n) {
        // base case
        if (n < 0) {
            return 0;
        }

        // return if only one item is remaining
        if (n == 0) {
            return jobs.get(0).profit;
        }

        // for the first `i` jobs
        int[] maxProfit = new int[n];

        // find the index of the last non-conflicting job with the current job
        int index = findLastNonConflictingJob(jobs, n);

        // include the current job and recur for non-conflicting jobs `[0, index]`
        int incl = jobs.get(n).profit + findMaxProfit(jobs, index);

        // exclude the current job and recur for remaining items `[0, n-1]`
        int excl = findMaxProfit(jobs, n - 1);

        // return the maximum profit by including or excluding the current job
        return Math.max(incl, excl);
    }

    // Function to find the index of the last job which doesn't conflict with the
    // given job. It performs a linear search on the given list of jobs.
    //THIS CAN BE OPTIMIZED WITH D+BINARY SEARCH
    public static int findLastNonConflictingJob(List<Job> jobs, int n) {
        // find the last job index whose finish time is less than or equal to the
        // given job's start time
        for (int i = n - 1; i >= 0; i--) {
            if (jobs.get(i).finish <= jobs.get(n).start) {
                return i;
            }
        }

        // return the negative index if no non-conflicting job is found
        return -1;
    }

    // Wrapper over `findMaxProfit()` function
    public static int findMaxProfit(List<Job> jobs) {
        // sort jobs in increasing order of their finish times
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

        return findMaxProfit(jobs, jobs.size() - 1);
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job(0, 6, 60),
                new Job(1, 4, 30),
                new Job(3, 5, 10),
                new Job(5, 7, 30),
                new Job(5, 9, 50),
                new Job(7, 8, 10)
        );

        System.out.print("The maximum profit is " + findMaxProfit(jobs));
    }

}

class Job
{
    int start, finish, profit;

    Job(int start, int finish, int profit)
    {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
}
