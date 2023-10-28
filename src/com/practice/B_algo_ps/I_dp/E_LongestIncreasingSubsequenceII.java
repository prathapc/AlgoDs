package com.practice.B_algo_ps.I_dp;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 19/10/23.
 */
public class E_LongestIncreasingSubsequenceII {
    //similar to prev sol with an additional condition
    //71/84 testcases passed
    //use segment tree to pass all
    public int lengthOfLIS(int[] nums, int k) {
        if(nums.length==1) return 1;
        int len=nums.length;
        if(len==0) return 0;
        int[] cache=new int[len];
        Arrays.fill(cache,1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && nums[i]-nums[j]<=k){
                    cache[i]=Math.max(cache[i], cache[j]+1);
                }
            }
        }
        return Arrays.stream(cache).max().getAsInt();
    }
}
