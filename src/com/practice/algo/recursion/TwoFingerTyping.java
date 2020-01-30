package com.practice.algo.recursion;

import java.util.*;

/**
 * Created by Prathap on 29 Jan, 2020
 *
 * https://leetcode.com/discuss/interview-question/456785/Google-or-Onsite-or-Two-Finger-Typing
 *
 * The problem is you are given a word and you need to type the word with only 2 fingers.
 * Each key rests at a coordinate [i,j] and the distance between them is absolute value of the differences between
 * their components |i1 - i2| + |j1 - j2|. Compute the minimum distance you would have to travel between the points.
 *
 * Keyboard Layout
 *
 * ABCDEF
 * GHIJKL
 * MNOPQR
 * STUVWX
 * YZ
 * Your initial positions are considered free so don't count towards your total distance.
 * Your 2 fingers do NOT have to start at the first letter or the first 2 letters. CAKE minimum would start at C & K with a total distance of 3.
 */
//TODO
public class TwoFingerTyping {

    //I often see people jumping to DP straightaway.
    // I can never do that. Below is my recursive solution with comments. This can be easily memoized or bottom-up(ed).
    public static class Location{
        int r,c;
        public Location(int x, int y) {
            this.r = x;
            this.c = y;
        }
        public int distance(Location other) {
            return Math.abs(r - other.r) + Math.abs(c  - other.c);
        }
        public String toString() {
            return this.r + ":" + this.c;
        }
    }

    static Map<Character,Location> map = new HashMap<>();
    static String [] keyboardLayout = {
            "ABCDEF",
            "GHIJKL",
            "MNOPQR",
            "STUVWX",
            "YZ"};

    public static void main(String args[]) {
        for(int r=0;r<keyboardLayout.length;r++)
            for(int c =0;c<keyboardLayout[r].length();c++) {
                map.put(keyboardLayout[r].charAt(c), new Location(r,c));
            }

        //borrowed test cases from @madno in this same thread
        System.out.println(helper(map.get("CAKE".charAt(0)), null, 1, "CAKE"));
        System.out.println(helper(map.get("ABZ".charAt(0)), null, 1, "ABZ"));
        System.out.println(helper(map.get("ABXZ".charAt(0)), null, 1, "ABXZ"));
        System.out.println(helper(map.get("ASBTCU".charAt(0)), null, 1, "ASBTCU"));
        System.out.println(helper(map.get("ASGTCU".charAt(0)), null, 1, "ASGTCU"));
    }

    public static int helper(Location finger1, Location finger2, int start, String input) {
        //if we are done with typing all characters, return.
        //start indicates the index of next character to type
        if(start == input.length())
            return 0;

        // get next location to move to as indicated by character pointed by start
        Location nextLocation = map.get(input.charAt(start));

        //choice 1: move finger1 to nextLocation and add the cost
        int costStartingWithFinger1Move  = finger1.distance(nextLocation) + helper(nextLocation, finger2, start+1, input);

        //choice 2: move finger2 to nextLocation with 2 scenarios
        //2a -> finger2 was never used, then move f2 to nextLocation without any cost
        //2b -> finger2 was used earlier and add the cost
        int costStartingWithFinger2Move  = (finger2 == null? 0 : finger2.distance(nextLocation)) + helper(finger1, nextLocation, start+1, input);

        //choose the best of the 2 options
        return Math.min(costStartingWithFinger1Move, costStartingWithFinger2Move);
    }
}
