package com.practice.B_algo_ps.B_strings;

/**
 * Created by prathapchowdary on 20/01/22.
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 *
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class A_AlienDictionaryVerify {
    public static void main(String args[]) {
        System.out.println(isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        for (int i=0; i<words.length-1; i++) {
            String curr = words[i];
            String next = words[i+1];
            int cc = 0, nc = 0;
            boolean isValid = false;
            while (cc < curr.length() && nc < next.length()) {
                char cChar = curr.charAt(cc++);
                char nChar = next.charAt(nc++);
                if (order.indexOf(cChar) == order.indexOf(nChar)) {
                    continue;
                } else if (order.indexOf(cChar) > order.indexOf(nChar)) {
                    return false;
                } else {
                    isValid = true;
                    break;
                }
            }
            //handling ["apple", "app"] use case for returning false here
            if (!isValid && curr.length() > cc) return false;
        }
        return true;
    }
}
