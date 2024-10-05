package com.practice.B_algo_ps.I_dp;

/**
 * Created by prathapchowdary on 31/10/23.
 *
 * Input: stones = [3,5,1,2,6], k = 3
 * Output: 25
 * Explanation: We start with [3, 5, 1, 2, 6].
 * We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
 * We merge [3, 8, 6] for a cost of 17, and we are left with [17].
 * The total cost was 25, and this is the minimum possible.
 *
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 */
public class M_MinCostToMergeStones {

    int[][][] dp;
    int max = Integer.MAX_VALUE;
    int K;
    public int mergeStones(int[] stones, int K) {
        this.K = K;
        int len = stones.length;
        if ((len - 1) % (K - 1) != 0) {
            return -1;
        }
        dp = new int[len + 1][len + 1][K + 1];
        int[] prefixSum = new int[len + 1];

        int i;
        for (i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        getResult(prefixSum, 1, len, 1);
        return dp[1][len][1];
    }

    private int getResult(int[] prefixSum, int left, int right, int piles) {
        if (dp[left][right][piles] != 0) {
            return dp[left][right][piles];
        }
        int res = max;
        int t;
        if (left == right) {
            res = (piles == 1) ? 0 : max;
        }
        else {
            if (piles == 1) {
                int mergeK = getResult(prefixSum, left, right, K);
                if (mergeK != max) {
                    res = mergeK + prefixSum[right] - prefixSum[left - 1];
                }
            }
            else {
                for (t = left; t < right; t++) {
                    int l = getResult(prefixSum, left, t, piles - 1);
                    int r = getResult(prefixSum, t + 1, right, 1);
                    if (l != max && r != max) {
                        res = Math.min(res, l + r);
                    }
                }
            }
        }
        dp[left][right][piles] = res;
        return res;
    }
}
