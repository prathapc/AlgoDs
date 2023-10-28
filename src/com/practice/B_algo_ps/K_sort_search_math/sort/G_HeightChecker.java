package com.practice.B_algo_ps.K_sort_search_math.sort;

/**
 * Created by prathapchowdary on 16/09/23.
 *
 * https://leetcode.com/problems/height-checker/
 */
public class G_HeightChecker {

    public int heightChecker(int[] heights) {
        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        int result = 0;
        int curHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }

            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }

        return result;
    }

}
