package com.practice.B_algo_ps.B_strings;

/**
 * Created by prathapchowdary on 10/07/22.
 *
 * https://leetcode.com/contest/weekly-contest-301/problems/move-pieces-to-obtain-a-string/
 *
 * You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:
 *
 * The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, and a piece 'R' can move to the right only if there is a blank space directly to its right.
 * The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
 * Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.
 *
 * Input: start = "_L__R__R_", target = "L______RR"
 * Output: true
 * Explanation: We can obtain the string target from start by doing the following moves:
 * - Move the first piece one step to the left, start becomes equal to "L___R__R_".
 * - Move the last piece one step to the right, start becomes equal to "L___R___R".
 * - Move the second piece three steps to the right, start becomes equal to "L______RR".
 * Since it is possible to get the string target from start, we return true.
 */
public class H_MovePiecesToObtainAString {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) return false;
        int sIndex = 0, tIndex = 0;
        while (sIndex < start.length() || tIndex < target.length()) {

            while (sIndex < start.length() && start.charAt(sIndex) == '_') sIndex++;
            while (tIndex < target.length() && target.charAt(tIndex) == '_') tIndex++;

            if (sIndex == start.length() && tIndex == target.length()) return true;
            else if (sIndex == start.length() || tIndex == target.length() || start.charAt(sIndex) != target.charAt(tIndex)) return false;
            else { //if both indexes in start and target has same char L/R

                //L in start string should go to lesser index target position otherwise return false
                if (start.charAt(sIndex) == 'L' && sIndex < tIndex) return false;
                //R in start string should go to higher index target position otherwise return false
                if (start.charAt(sIndex) == 'R' && sIndex > tIndex) return false;

            }
            sIndex++;
            tIndex++;
        }
        return true;
    }
}
