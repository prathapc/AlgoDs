package com.practice.ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Prathap on 15 Jan, 2020
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 *
 * https://leetcode.com/problems/4sum/
 *
 */
public class L18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++) {
            for(int j=i+1;j<nums.length-2;j++) {
                int k=j+1;
                int l=nums.length-1;
                while(k<l) {
                    int sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target) {
                        set.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    }
                    else if(sum<target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return new ArrayList<>(set);
    }

}
