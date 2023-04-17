package com.practice.B_algo.I_dp;

/**
 * Created by Prathap on 04 Jan, 2020
 *
 * https://leetcode.com/problems/jump-game-ii/
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps. You can assume that you can always reach the last index.
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class G_JumpGameII {

    public static void main(String args[]) {
        int nums[] = {2,3,1,1,4};
        jump(nums);
    }

    //beats 99.5%
    public int jump2(int[] nums) {
        int jumps = 0, currentJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // we continuously find the how far we can reach in the current jump
            farthest = Math.max(farthest, i + nums[i]);
            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }

    //beats 99.5%
    public static int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        // keep track of the largest ladder you have
        int ladder = nums[0];

        // keep track of number of stairs in the current ladder
        int stair = nums[0];

        int jump = 1;

        for (int i = 1; i < nums.length; i++) {
            //if you reach the end of the ladder,
            //return the number jumps you made so far
            if (i == nums.length - 1) {
                return jump;
            }

            // if you can construct a ladder bigger than the current one, construct it
            if (nums[i] + i >= ladder) {
                ladder = nums[i] + i;
            }

            // climb up one stair
            stair--;

            if (stair == 0) { // if there are no stairs left, make a jump to the next ladder
                jump++;
                //length of remaining stairs will be length of ladder minus the step you are on
                stair = ladder - i;
                // still no stairs it means we cannot reach the end..
                if (stair == 0) {
                    return -1;
                }
            }
        }
        return jump;
    }
}
