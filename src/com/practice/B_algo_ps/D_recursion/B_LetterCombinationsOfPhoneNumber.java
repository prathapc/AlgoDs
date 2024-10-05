package com.practice.B_algo_ps.D_recursion;

import java.util.*;

/**
 * Created by prathapchowdary on 28/11/21.
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * NOTE:
 * I think the wording of the problem is incorrect.
 * "Combination of letters" means that we don't care about the ordering of individual words formed from digits.
 * (e.g. "ae" and "ea" would be the same combination).
 * But what the problem really wants is all Permutations of letters formed from digits.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class B_LetterCombinationsOfPhoneNumber {

    public static void main(String args[]) {
        letterCombinations("23");
        System.out.println(result);
    }

    static List<String> result;
    static Map<Integer, String> keyMap;
    public static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) return result;
        keyMap = new HashMap<>();
        buildKeyMap();

        letterCombinations(digits, 0, "");
        return result;
    }
    private static void letterCombinations(String digits, int index, String temp) {
        if (index == digits.length()) {
            result.add(temp);
            return;
        }
        String letters = keyMap.get(digits.charAt(index) - '0');
        for (int i=0; i<letters.length(); i++) {
            letterCombinations(digits, index+1, temp+letters.charAt(i));
        }
    }
    private static void buildKeyMap() {
        keyMap.put(2, "abc");
        keyMap.put(3, "def");
        keyMap.put(4, "ghi");
        keyMap.put(5, "jkl");
        keyMap.put(6, "mno");
        keyMap.put(7, "pqrs");
        keyMap.put(8, "tuv");
        keyMap.put(9, "wxyz");
    }

    //iterative approach
    public static List<String> letterCombinations1(String digits) {
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
        for (int i = 1; i < digits.length(); i++) {
            List<Character> digitChars = data.get(
                Integer.parseInt(String.valueOf(digits.charAt(i))));
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
}
