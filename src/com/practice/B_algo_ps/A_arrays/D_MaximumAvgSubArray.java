package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 08/06/23.
 */
public class D_MaximumAvgSubArray {
    public static double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int i=k;i<nums.length;i++){
            sum += nums[i]-nums[i-k];
            res=Math.max(res,sum);
        }
        return res/k;
    }

    public static void main(String args[]) {
        findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
    }
}
