package com.practice.B_algo.A_sort_search_math.math;

/**
 * Created by prathapchowdary on 13/11/21.
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class B_AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = b.length() - 1;
        for(int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') ++carry;
            if (j >= 0 && b.charAt(j) == '1') ++carry;

            if (carry % 2 == 1) sb.append('1');
            else sb.append('0');

            carry /= 2;
            j--;
        }
        if (carry == 1) sb.append('1');
        sb.reverse();

        return sb.toString();
    }
}
