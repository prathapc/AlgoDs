package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

/**
 * Created by prathapchowdary on 04/09/22.
 * https://www.geeksforgeeks.org/sum-of-all-substrings-of-a-string-representing-a-number/
 *
 * Input  : num = “1234”
 * Output : 1670
 * Sum = 1 + 2 + 3 + 4 + 12 + 23 +
 *        34 + 123 + 234 + 1234
 *     = 1670
 */
public class L_SumOfDigits {
    public static int sumOfSubstrings(String num)
    {
        int n = num.length();
        int sumofdigit[] = new int[n];

        sumofdigit[0] = num.charAt(0) - '0';
        int res = sumofdigit[0];

        for (int i = 1; i < n; i++) {
            int numi = num.charAt(i) - '0';

            // update each sumofdigit from previous value
            sumofdigit[i] = (i + 1) * numi + 10 * sumofdigit[i - 1];

            // add current value to the result
            res += sumofdigit[i];
        }

        return res;
    }

    /**
     * Example : num = "1234"
     * sumofdigit[0] = 1 = 1
     * sumofdigit[1] = 2 + 12  = 14
     * sumofdigit[2] = 3 + 23  + 123 = 149
     * sumofdigit[3] = 4 + 34  + 234 + 1234  = 1506
     * Result = 1670
     *
     * For above example,
     * sumofdigit[3] = 4 + 34 + 234 + 1234
     *            = 4 + 30 + 4 + 230 + 4 + 1230 + 4
     *            = 4*4 + 10*(3 + 23 +123)
     *            = 4*4 + 10*(sumofdigit[2])
     * In general,
     * sumofdigit[i]  =  (i+1)*num[i] + 10*sumofdigit[i-1]
     */
    public static void main(String[] args) {
        String num = "1234";
        System.out.println(sumOfSubstrings(num));
    }
}
