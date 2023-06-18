package com.practice.B_algo_ps.I_dp;

/**
 * Created by prathapchowdary on 29/09/21.
 *
 * 1. Find max prize collection possible
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * https://vidhu-verma.medium.com/optimal-strategy-for-a-game-dp-4cbf7f03e785
 * 4^n recursive solution to (n^2)! memorization
 *
 * 2. Below problem: predict if player 1 wins
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * https://leetcode.com/problems/predict-the-winner/
 * Approach - You(P1) can only win if you can put your opponent(P2) in a situation where his choices don't matter.
 * That means, both the branches of recursion for your opponent should make him lose.
 *
 * Current score of any Player = nums[l] + score_till_now or nums[r] + score_till_now
 * where l and r denote the array range they are currently playing in.
 */
public class Z_GameStrategy_PredictWinner {

    // returns true if score of P1 >= score of P2
    // turn = true, means it is P1's turn
    private boolean f(int[] nums, boolean turn, int p1, int p2, int l, int r) {
        if (l == r) {
            if (turn)
                p1 += nums[l];
            else
                p2 += nums[l];
            return p1 >= p2;
        }
        if (turn) {
            // You can win by using left OR right
            return f(nums, false, nums[l]+p1, p2, l+1, r) || f(nums, false, nums[r]+p1, p2, l, r-1);
        }
        // For you to win, opponent needs to lose using both left AND right
        return f(nums, true, p1, nums[l]+p2, l+1, r) && f(nums, true, p1, nums[r]+p2, l, r-1);
    }

    public boolean PredictTheWinner(int[] nums) {
        return f(nums, true, 0, 0, 0, nums.length-1);
    }
    public static void main(String args[]) {

    }
}
