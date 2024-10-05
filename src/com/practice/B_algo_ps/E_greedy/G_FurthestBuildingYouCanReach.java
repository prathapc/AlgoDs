package com.practice.B_algo_ps.E_greedy;

/**
 * Created by prathapchowdary on 17/02/24.
 */
public class G_FurthestBuildingYouCanReach {

    //recursion
    public int furthestBuilding_recursion(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        return solve_recursion(heights, 0, bricks, ladders);
    }
    public int solve_recursion(int[] heights, int i, int bricks, int ladders) {
        if(i == heights.length-1) return i;
        int diff = heights[i+1] - heights[i];
        if(diff > 0) {
            int ans = i;
            if(bricks >= diff) {
                ans = Math.max(ans, solve_recursion(heights, i+1, bricks - diff, ladders));
            }
            if(ladders > 0) {
                ans = Math.max(ans, solve_recursion(heights, i+1, bricks, ladders-1));
            }
            return ans;
        } else {
            return solve_recursion(heights, i+1, bricks, ladders);
        }
    }

    //DP
    Integer[][][] memo;
    public int furthestBuilding_dp(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        memo = new Integer[n+1][bricks+1][ladders+1];
        return solve_dp(heights, 0, bricks, ladders);
    }
    public int solve_dp(int[] heights, int i, int bricks, int ladders) {
        if(i == heights.length-1) return i;
        if(memo[i][bricks][ladders] != null) return memo[i][bricks][ladders];
        int diff = heights[i+1] - heights[i];
        if(diff > 0) {
            int ans = i;
            if(bricks >= diff) {
                ans = Math.max(ans, solve_dp(heights, i+1, bricks - diff, ladders));
            }
            if(ladders > 0) {
                ans = Math.max(ans, solve_dp(heights, i+1, bricks, ladders-1));
            }
            return memo[i][bricks][ladders] = ans;
        } else {
            return memo[i][bricks][ladders] = solve_dp(heights, i+1, bricks, ladders);
        }
    }


    //greedy
    /**
     * GREEDY >>>> DP ( Sorry DP lovers )
     *
     * Whenever you apply DP in any question, first always try to make this
     * using simple greedy approach. If greedy fails then go for DP.
     *
     * Because for DP either you might require O(n^2) or
     * sometime for 3D dp O(n^3) time.
     *
     * But in greedy which mostly work by sorting data it will be
     * in O(n*logn).
     *
     * If you closely check the input size is 10^5 so for sure
     * we have to do this in O(nlogn) or lower time.
     *
     * Here it's not like I have choice either I can pick ladder or brick, I also need to make sure I reach the maximum index.
     *
     * So let's say you have to climb 8 and 2, and you have 5 bricks and 1 ladder.
     *
     * What will you do ?
     * Obviously you will try to climb the highest using ladder else you will waste too many bricks.
     *
     * Conclusion: So here we know that we will use ladders for the highest
     * climb and bricks for the remaining.
     *
     *
     */

}
