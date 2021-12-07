package com.practice.B_algo.A_sort_search_math.math;

/**
 * Created by prathapchowdary on 05/12/21.
 *
 * https://leetcode.com/problems/divide-two-integers/submissions/
 *
 * Division with out using / * %
 */
public class DivideTwoIntegers {

    public static void main(String args[]) {
        System.out.println(divide(Integer.MIN_VALUE, -6));
        System.out.println(divide(2344, -6));
    }
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        //
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int quotient = 0;
        boolean negativeSign = false;
        if (dividend < 0 && divisor < 0) {
            divisor *= -1;
            dividend *= -1;
        } else if (dividend > 0 && divisor < 0) {
            negativeSign = true;
            divisor *= -1;
        } else if (dividend < 0 && divisor > 0) {
            negativeSign = true;
            dividend *= -1;
        }

        while (dividend - divisor >= 0) {
            dividend -= divisor;
            quotient++;
        }

        if (negativeSign) {
            return -1*quotient;
        }
        return quotient;
    }

    //another approach using bit manipulation
    public int divide1(int dividend, int divisor) {

        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        /* In the first loop, we simply find the largest double of divisor
         * that fits into the dividend.
         * The >= is because we're working in negatives. In essence, that
         * piece of code is checking that we're still nearer to 0 than we
         * are to INT_MIN. */
        int highestDouble = divisor;
        int highestPowerOfTwo = -1;
        while (highestDouble >= Integer.MIN_VALUE/2 && dividend <= highestDouble + highestDouble) {
            highestPowerOfTwo += highestPowerOfTwo;
            highestDouble += highestDouble;
        }

        /* In the second loop, we work out which powers of two fit in, by
         * halving highestDouble and highestPowerOfTwo repeatedly.
         * We can do this using bit shifting so that we don't break the
         * rules of the question :-) */
        int quotient = 0;
        while (dividend <= divisor) {
            if (dividend <= highestDouble) {
                quotient += highestPowerOfTwo;
                dividend -= highestDouble;
            }
            /* We know that these are always even, so no need to worry about the
             * annoying "bit-shift-odd-negative-number" case. */
            highestPowerOfTwo >>= 1;
            highestDouble >>= 1;
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }
}
