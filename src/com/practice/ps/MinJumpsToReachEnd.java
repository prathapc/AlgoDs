package com.practice.ps;

/**
 * Created by Prathap on 04 Jan, 2020
 *
 * https://leetcode.com/problems/jump-game-ii/
 *
 */
public class MinJumpsToReachEnd {

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

    public static void main(String args[]) {
        int nums[] = {2,3,1,1,4};
        jump(nums);
    }
}
