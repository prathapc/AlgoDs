package com.practice.algo;

/**
 * Created by Prathap on 19 Oct, 2019
 */
public class CanJumpInArray {

    //accepted solution
    public boolean canJump1(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    //other solution
    public static void main(String args[]) {

        //Works but memory limit exceeded in leetcode submission:
        //Filling 2D array with all the possibilities from the element
        //then checking each COLUMN for a True value
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(canJump(nums));

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

    public static boolean canJump(int[] nums) {
        boolean[][] arr = new boolean[nums.length][nums.length];
        for (int i=0; i<nums.length; i++) {
            int element = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (--element < 0) {
                    break;
                }
                arr[i][j] = true;
            }
        }

        for (int j=1; j<nums.length; j++) {
            boolean doesColHasTrue = false;
            for (int i=0; i<nums.length; i++) {
                if (arr[i][j] == true) {
                    doesColHasTrue = true;
                }
            }
            if (!doesColHasTrue) {
                return false;
            }
        }
        return true;
    }
}
