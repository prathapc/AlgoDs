package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 13/05/22.
 *
 * Suppose you are at a party with n people labeled from 0 to n - 1 and among them,
 * there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know the celebrity,
 * but the celebrity does not know any of them.
 *
 * You are given a helper function bool knows(a, b) that tells you whether A knows B.
 * Implement a function int findCelebrity(n). There will be exactly one celebrity if they are at the party.
 *
 * https://leetcode.com/problems/find-the-celebrity/
 */
public class L_FindTheCelebrity {
    private int numberOfPeople;

    public int findCelebrity(int n) {
        numberOfPeople = n;
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }

    //utility method provided to know relationships
    private boolean knows(int i, int j) {
        return true; // or false
    }
}
