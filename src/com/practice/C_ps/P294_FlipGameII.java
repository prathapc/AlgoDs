package com.practice.C_ps;

import java.util.HashMap;

/**
 * Created by Prathap on 29 Nov, 2019
 * https://leetcode.com/problems/flip-game-ii/
 *
 * ou are given a string currentState that contains only '+' and '-'.
 * You and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move, and therefore the other person will be the winner.
 * Return true if the starting player can guarantee a win, and false otherwise.
 */
public class P294_FlipGameII {

    public static void main(String args[]) {
        //first approach
        System.out.println(canWin1("++++--+-++"));
        //second approach
        System.out.println(canWin2("++++--+-++"));
    }

    public static boolean canWin1(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String nextState = s.substring(0, i) + "--" + s.substring(i+2);
                if (!canWin1(nextState)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean canWin2(String s) {
        HashMap<String, Boolean> h = new HashMap();
        return canWin2(s.toCharArray(), h);
    }

    private static boolean canWin2(char[] c, HashMap<String, Boolean> h) {
        for (int i = 1; i < c.length; i++)
            if (c[i] == '+' && c[i - 1] == '+') {
                c[i] = '-'; c[i - 1] = '-';

                boolean t;
                String key = String.valueOf(c);
                if (!h.containsKey(key)) {
                    t = canWin2(c, h);
                    h.put(key, t);      //System.out.println(key + " --> " + t);
                } else {
                    t = h.get(key);     //System.out.println(key + " ==> " + t);
                }   // can not directly use if (t) return true here, cuz you need to restore

                c[i] = '+'; c[i - 1] = '+';
                if (!t) return true;
            }
        return false;
    }
}
