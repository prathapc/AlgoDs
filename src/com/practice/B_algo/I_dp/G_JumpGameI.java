package com.practice.B_algo.I_dp;

/**
 * Created by Prathap on 19 Oct, 2019
 *
 * https://leetcode.com/problems/jump-game/
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class G_JumpGameI {

    //accepted solution beats 100%

    //Once we have our code in the bottom-up state, we can make one final, important observation.
    //From a given position, when we try to see if we can jump to a GOOD position,
    //we only ever use one - the first one (see the break statement).
    //In other words, the left-most one. If we keep track of this left-most GOOD position as a separate variable,
    //we can avoid searching for it in the array. Not only that, but we can stop using the array altogether.
    //
    //Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array. If first position is a GOOD index then we can reach the last index from the first position.
    //To illustrate this scenario, we will use the diagram below, for input array nums = [9, 4, 2, 1, 0, 2, 0].
    //We write G for GOOD, B for BAD and U for UNKNOWN.
    //Let's assume we have iterated all the way to position 0 and we need to decide if index 0 is GOOD.
    //Since index 1 was determined to be GOOD, it is enough to jump there and then be sure we can eventually reach index 6.
    //It does not matter that nums[0] is big enough to jump all the way to the last index. All we need is one way.
    //Index	0	1	2	3	4	5	6
    //nums	9	4	2	1	0	2	0
    //memo	U	G	B	B	B	G	G
    public boolean canJump1(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    //other solution: beats 22%
    public static void main(String args[]) {
        int[] nums = new int[]{2,3,1,1,4};
        //other standard dfs way of solving
        Boolean[] memo = new Boolean[nums.length];
        memo[nums.length - 1] = true;

        System.out.println(dfs(0, nums, memo));
    }

    private static boolean dfs(int pos, int[] nums, Boolean[] memo) {
        if (memo[pos] != null) return memo[pos];

        int furthest = Math.min(pos + nums[pos], nums.length - 1);
        boolean canReach = false;
        for (int i = furthest; i >= pos + 1; --i) {
            if (dfs(i, nums, memo)) {
                canReach = true;
                break;
            }
        }

        memo[pos] = canReach;
        return canReach;
    }
}
