package com.practice.B_algo_ps.I_dp;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 19/10/23.
 *
 * Input: nums = [4,2,1,4,3,4,5,8,15], k = 3
 * Output: 5
 * Explanation:
 * The longest subsequence that meets the requirements is [1,3,4,5,8].
 * The subsequence has a length of 5, so we return 5.
 * Note that the subsequence [1,3,4,5,8,15] does not meet the requirements because 15 - 8 = 7 is larger than 3.
 *
 * https://leetcode.com/problems/longest-increasing-subsequence-ii/
 */
public class E_LongestIncreasingSubsequenceII__ {
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

    //solution using segment tree TODO
    public int lengthOfLIS_1(int[] nums, int k) {
        SegmentTree root = new SegmentTree(1, 100000);
        int res = 0;
        for (int num : nums) {
            int preMax = root.rangeMaxQuery(root, num - k, num - 1);
            root.update(root, num, preMax + 1);
            res = Math.max(res, preMax + 1);
        }
        return res;
    }
    class SegmentTree {
        SegmentTree left, right;
        int start, end, val;
        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            setup(this, start, end);
        }
        public void setup(SegmentTree node, int start, int end) {
            if (start == end) return;
            int mid = start + (end - start) / 2;
            if (node.left == null) {
                node.left = new SegmentTree(start, mid);
                node.right = new SegmentTree(mid + 1, end);
            }
            setup(node.left, start, mid);
            setup(node.right, mid + 1, end);
            node.val = Math.max(node.left.val, node.right.val);
        }

        public void update(SegmentTree node, int index, int val) {
            if (index < node.start || index > node.end) return;
            if (node.start == node.end && node.start == index) {
                node.val = val;
                return;
            }
            update(node.left, index, val);
            update(node.right, index, val);
            node.val = Math.max(node.left.val, node.right.val);
        }

        public int rangeMaxQuery(SegmentTree node, int start, int end) {
            if (node.start > end || node.end < start) return 0;
            if (node.start >= start && node.end <= end) return node.val;
            return Math.max(rangeMaxQuery(node.left, start, end), rangeMaxQuery(node.right, start, end));
        }
    }
}
