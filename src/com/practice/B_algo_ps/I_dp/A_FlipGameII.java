package com.practice.B_algo_ps.I_dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Prathap on 29 Nov, 2019
 * https://leetcode.com/problems/flip-game-ii/
 *
 * you are given a string currentState that contains only '+' and '-'.
 * You and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move, and therefore the other person will be the winner.
 * Return true if the starting player can guarantee a win, and false otherwise.
 */
public class A_FlipGameII {

    public static void main(String args[]) {
        //first approach
        System.out.println(canWin("++++--+-++"));//recursion => O(n!)! ; double factorial?
        //second approach
        System.out.println(canWin_dp("++++--+-++")); // beats 67%; complexity from factorial to exponential?

        System.out.println(canWin_dp2("++++--+-++")); //beats 84%; reduced complexity by
    }

    //recursion => O(n!)! ; double factorial?
    public static boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String nextState = s.substring(0, i) + "--" + s.substring(i+2);
                if (!canWin(nextState)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean canWin_dp(String s) {
        if(s == null || s.length() < 2) return false;

        Set<String> winSet = new HashSet<>();
        return canWin(s, winSet);
    }
    public static boolean canWin(String s, Set<String> winSet){
        if(winSet.contains(s)) return true;

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {

                String sOpponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!canWin(sOpponent, winSet)) {
                    winSet.add(s);
                    return true;
                }
            }
        }
        return false;
    }




    public static boolean canWin_dp2(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Map<String, Boolean> memo = new HashMap<>();
        StringBuilder sb = new StringBuilder(s);
        return dfs(sb, memo);
    }
    private static boolean dfs(StringBuilder sb, Map<String, Boolean> memo) {
        if (memo.containsKey(sb.toString())) {
            return memo.get(sb.toString());
        }

        for (int i = 0; i < sb.length()-1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i+1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i+1, '-');
                if (!dfs(sb, memo)) {
                    sb.setCharAt(i, '+');
                    sb.setCharAt(i+1, '+');
                    memo.put(sb.toString(), true);
                    return true;
                }
                sb.setCharAt(i, '+');
                sb.setCharAt(i+1, '+');
            }
        }
        memo.put(sb.toString(), false);
        return false;
    }
}
