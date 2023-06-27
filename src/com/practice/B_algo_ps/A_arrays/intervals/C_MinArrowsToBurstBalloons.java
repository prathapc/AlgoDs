package com.practice.B_algo_ps.A_arrays.intervals;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 24/06/23.
 *
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 *
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class C_MinArrowsToBurstBalloons {

    public static void main(String args[]) {
        int intervals[][] = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots(intervals));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //Arrays.sort(points, (a, b) -> a[1] - b[1]);
        //above sort fails for boundary values input [[-2147483646,-2147483645],[2147483646,2147483647]]
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));

        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
