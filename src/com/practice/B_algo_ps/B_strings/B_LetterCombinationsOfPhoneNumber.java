package com.practice.B_algo_ps.B_strings;

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

    //another recursive solution
    public class Solution {
        private final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        public List<String> letterCombinations(String digits) {
            List<String> result = new LinkedList<String>();
            if (digits.equals("")) return result;
            combination("", digits, 0, result);
            return result;
        }

        private void combination(String temp, String digits, int index, List<String> result) {
            if (index == digits.length()) { //or offset == digits.length()
                result.add(temp);
                return;
            }
            String letters = KEYS[(digits.charAt(index) - '0')];
            for (int i = 0; i < letters.length(); i++) {
                combination(temp + letters.charAt(i), digits, index + 1, result);
            }
        }
    }

    //another backtracking solution
    class Solution1 {
        private List<String> combinations = new ArrayList<>();
        private Map<Character, String> letters = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        private String phoneDigits;

        public List<String> letterCombinations(String digits) {
            // If the input is empty, immediately return an empty answer array
            if (digits.length() == 0) {
                return combinations;
            }

            // Initiate backtracking with an empty path and starting index of 0
            phoneDigits = digits;
            backtrack(0, new StringBuilder());
            return combinations;
        }

        private void backtrack(int index, StringBuilder path) {
            // If the path is the same length as digits, we have a complete combination
            if (path.length() == phoneDigits.length()) {
                combinations.add(path.toString());
                return; // Backtrack
            }

            // Get the letters that the current digit maps to, and loop through them
            String possibleLetters = letters.get(phoneDigits.charAt(index));
            for (char letter: possibleLetters.toCharArray()) {
                // Add the letter to our current path
                path.append(letter);
                // Move on to the next digit
                backtrack(index + 1, path);
                // Backtrack by removing the letter before moving onto the next
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String args[]) {
        System.out.println(letterCombinations("23"));
    }
}
