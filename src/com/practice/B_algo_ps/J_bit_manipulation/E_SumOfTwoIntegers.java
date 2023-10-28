package com.practice.B_algo_ps.J_bit_manipulation;

/**
 * Created by prathapchowdary on 24/10/23.
 */
public class E_SumOfTwoIntegers {

    public static void main(String[] args) {

    }

    public int getSum(int a, int b) {
        String aBinary = Integer.toBinaryString(a);
        String bBinary = Integer.toBinaryString(b);
        if (aBinary.length() >= bBinary.length()) {
            return getSum(aBinary, bBinary);
        } else {
            return getSum(bBinary, aBinary);
        }
    }

    private int getSum(String aBinary, String bBinary) {
        int i = bBinary.length()-1 ;
        for (; i>=0; i--) {
            int c = aBinary.charAt(i) | bBinary.charAt(i);
        }

        return 0;
    }
}
