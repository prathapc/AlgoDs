package com.practice.B_algo.I_dp;

/**
 * Created by prathapchowdary on 29/04/22.
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class B__MinCostClimbingStair {

    //beats 100%
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length+1];
        for (int i=2; i<minCost.length; i++) {
            int takeOneStep = cost[i-1] + minCost[i-1];
            int takeTwoStep = cost[i-2] + minCost[i-2];
            minCost[i] = Math.min(takeOneStep, takeTwoStep);
        }
        return minCost[minCost.length-1];
    }

    //beats 5% : topDown DP
    /*public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> data = new HashMap<>();
        return Math.min(minCostClimbingStairsUtil(cost, 0, data), minCostClimbingStairsUtil(cost, 1, data));
    }

    private int minCostClimbingStairsUtil(int[] cost, int currIndex, Map<Integer, Integer> data) {
        //meaning we can reach nth stair with curr index cost from here
        if (currIndex > cost.length-3) {
            return cost[currIndex];
        }

        if (data.containsKey(currIndex)) {
            return data.get(currIndex);
        }

        int oneStepCost = cost[currIndex] + minCostClimbingStairsUtil(cost, currIndex+1, data);
        int twoStepCost = cost[currIndex] + minCostClimbingStairsUtil(cost, currIndex+2, data);
        int minCost = Math.min(oneStepCost, twoStepCost);

        data.put(currIndex, minCost);
        return minCost;
    }*/
}
