package com.practice.B_algo.D_recursion;

import java.util.*;

/**
 * Created by prathapchowdary on 28/11/21.
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 *
 */
public class B_LetterCombinationsOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }

        Map<Integer, List<Character>> data = new HashMap<>();
        data.put(2, new ArrayList<Character>(Arrays.asList(new Character[]{'a', 'b', 'c'})));
        data.put(3, new ArrayList<Character>(Arrays.asList(new Character[]{'d', 'e', 'f'})));
        data.put(4, new ArrayList<Character>(Arrays.asList(new Character[]{'g', 'h', 'i'})));
        data.put(5, new ArrayList<Character>(Arrays.asList(new Character[]{'j', 'k', 'l'})));
        data.put(6, new ArrayList<Character>(Arrays.asList(new Character[]{'m', 'n', 'o'})));
        data.put(7, new ArrayList<Character>(Arrays.asList(new Character[]{'p', 'q', 'r', 's'})));
        data.put(8, new ArrayList<Character>(Arrays.asList(new Character[]{'t', 'u', 'v'})));
        data.put(9, new ArrayList<Character>(Arrays.asList(new Character[]{'w', 'x', 'y', 'z'})));

        int firstDigit = Integer.parseInt(String.valueOf(digits.charAt(0)));
        List<Character> chars = data.get(firstDigit);
        for (Character c : chars) {
            result.add(String.valueOf(c));
        }
        for (int i=1; i<digits.length(); i++) {
            List<Character> digitChars = data.get(Integer.parseInt(String.valueOf(digits.charAt(i))));
            List<String> temp = new ArrayList<>();
            for (String s : result) {
                for (Character c : digitChars) {
                    temp.add(s + c);
                }
            }
            result = temp;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(letterCombinations("23"));
    }
}
