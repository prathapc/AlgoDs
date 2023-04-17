package com.practice.B_algo.E_recursion;

import java.util.*;

/**
 * Created by prathapchowdary on 08/05/22.
 *
 * Input: pressedKeys = "22233"
 * Output: 8
 * Explanation:
 * The possible text messages Alice could have sent are:
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae", and "ce".
 * Since there are 8 possible messages, we return 8.
 */
public class B_CountNumberOfTexts {
    static int result = 0;

    //TODO wrong answer
    public static void main(String args[]) {
        String pressedKeys = "22233";
        if (pressedKeys == null || "".equals(pressedKeys)) {
            System.out.println(0);
        }

        Map<Integer, List<Character>> data = new HashMap<>();
        data.put(2, new ArrayList<>(Arrays.asList(new Character[]{'a', 'b', 'c'})));
        data.put(3, new ArrayList<>(Arrays.asList(new Character[]{'d', 'e', 'f'})));
        data.put(4, new ArrayList<>(Arrays.asList(new Character[]{'g', 'h', 'i'})));
        data.put(5, new ArrayList<>(Arrays.asList(new Character[]{'j', 'k', 'l'})));
        data.put(6, new ArrayList<>(Arrays.asList(new Character[]{'m', 'n', 'o'})));
        data.put(7, new ArrayList<>(Arrays.asList(new Character[]{'p', 'q', 'r', 's'})));
        data.put(8, new ArrayList<>(Arrays.asList(new Character[]{'t', 'u', 'v'})));
        data.put(9, new ArrayList<>(Arrays.asList(new Character[]{'w', 'x', 'y', 'z'})));

        List<Character> letters = data.get(Character.getNumericValue(pressedKeys.charAt(0)));
        String singleLetter = "" + letters.get(0);

        countTextsUtil(pressedKeys, 0, "", data);
        System.out.println(result);
    }

    private static void count(String pressedKeys, int index, String temp, Map<Integer, List<Character>> data) {
        if (index >= pressedKeys.length()) {
            result++;
        } else {
            while (index < pressedKeys.length()) {
                int digit = pressedKeys.charAt(index);
                List<Character> keys = data.get(digit);
                count(pressedKeys, index+1, temp+keys.get(0), data);
                for (int i=1; i<keys.size(); i++) {
                    //if (digit == pressedKeys.charAt())
                }
            }
        }
    }

    private static void countTextsUtil(String pressedKeys, int index, String temp, Map<Integer, List<Character>> data) {
        if (index >= pressedKeys.length()) {
            result++;
        } else {
            List<Character> letters = data.get(Character.getNumericValue(pressedKeys.charAt(index)));

            String singleLetter = temp + letters.get(0);
            countTextsUtil(pressedKeys, index+1, singleLetter, data);
            for (int i=1; i<letters.size()-1; i++) {
                if (pressedKeys.charAt(i) == pressedKeys.charAt(i-1)) {
                    String t = temp + letters.get(i);
                    countTextsUtil(pressedKeys, index+i+1, t, data);
                    //temp = temp.substring(0, temp.length()-1);
                }
            }
        }

    }
}
