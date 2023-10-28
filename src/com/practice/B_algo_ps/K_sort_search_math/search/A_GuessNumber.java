package com.practice.B_algo_ps.K_sort_search_math.search;

import java.util.Random;

/**
 * Created by prathapchowdary on 19/06/23.
 *
 * https://leetcode.com/problems/guess-number-higher-or-lower
 */
public class A_GuessNumber {

    int guess(int num) {return new Random().nextInt(new int[]{-1,0,1}.length); }

    public int guessNumber(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (guess(mid) == 0) return mid;
            else if(guess(mid) == -1) end = mid-1;
            else start = mid+1;
        }
        return start;
    }


}
