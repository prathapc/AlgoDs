package com.practice.B_algo.C_strings;

/**
 * Created by prathapchowdary on 08/11/21.
 *
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * 1. Read in and ignore any leading whitespace.
 * 2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * 3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * 6. Return the integer as the final result.
 */
public class B_atoi {
    public int myAtoi(String str) {
        int index = 0;
        int total = 0;
        int sign = 1;

        // Check if empty string
        if(str.length() == 0)
            return 0;

        // remove white spaces from the string
        while(index < str.length() && str.charAt(index) == ' ')
            index++;

        if (index == str.length()) return 0;

        // get the sign
        if(str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // convert to the actual number and make sure it's not overflow
        while(index < str.length()) {
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            // check for overflow
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = total*10 + digit;
            index++;
        }
        return total*sign;
    }
}
