package com.practice.B_algo_ps.A_arrays.intervals;

/**
 * Created by Prathap on 22 Jan, 2020
 *
 * #Array #Greedy #DP
 */
public class BuySellStocks {

    public static void main(String[] args) throws Exception {

        int[] prices = {7,1,5,3,6,4};

        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        maxProfitByBuySellStockAtMost1Time(prices);

        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        maxProfitByBuySellStockAnyNoOfTimes();

        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        maxProfitByBuySellStockAtMost2Times();

        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
        maxProfitByBuySellStockAtMostKTimes();

        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
        maxProfitByBuySellStockAnyTimesWithTransactionFee();

    }

    private static int maxProfitByBuySellStockAtMost1Time(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i]-min);
            }
        }
        return maxProfit;
    }






    private static void maxProfitByBuySellStockAnyNoOfTimes() {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        int n = prices.length;
        int profit = 0;
        int currProfit = 0;
        for(int day = 1; day < prices.length; day++) {
            currProfit = prices[day] - prices[day-1];
            if(currProfit > 0) {
                profit += currProfit;
            }
        }
        System.out.println(profit);
    }
    public static  int maxProfitByBuySellStockAnyNoOfTimes1(int[] prices) {
        int i = 0, buy = 0, sell = 0, profit = 0, n = prices.length - 1;
        while (i < n) {
            while (i < n && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < n && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }


    //DP - top down
    public static int maxProfitByBuySellStockAtMost2Times() {
        int prices[] = {10,5,22,65,8,75,90,80};
        Integer[][][] memo = new Integer[2][2][prices.length];
        return getMaxProfit(prices, 0, 0, 0, memo);
    }
    private static int getMaxProfit(int[] prices, int transactions, int holding, int position, Integer[][][] memo) {
        if (transactions == 2) return 0;
        if (position == prices.length) return 0;
        if (memo[transactions][holding][position] != null) return memo[transactions][holding][position];

        int profit = 0;
        // when we are at buy position, we can sell, when at sell, we can buy
        if (holding == 1) {
            int sellProfit = prices[position] + getMaxProfit(prices, transactions + 1, 0, position + 1, memo); //sell
            profit = Math.max(profit, sellProfit);
        } else {
            int buyProfit = -prices[position] + getMaxProfit(prices, transactions, 1, position + 1, memo); //buy
            profit = Math.max(profit, buyProfit);
        }
        // nothing
        int nothing = getMaxProfit(prices, transactions, holding, position + 1, memo);
        profit = Math.max(profit, nothing);

        memo[transactions][holding][position] = profit;
        return profit;
    }

    // DP - top down
    public static int maxProfitByBuySellStockAtMostKTimes() {
        int k = 3;
        int prices[] = {12, 14, 17, 10, 14, 13, 12, 15};
        return maxProfit(prices, 0, k, 0, new int[prices.length + 1][k + 1][2]);
    }
    public static int maxProfit(int[] prices, int day, int remainingTrans, int holding, int[][][] memo) {
        if (remainingTrans == 0 && holding == 0) return 0;
        if (day == prices.length - 1) { // last day
            if (holding == 1) return prices[day]; // must sell
            return 0;
        }
        if (memo[day][remainingTrans][holding] != 0) return memo[day][remainingTrans][holding];

        int maxProfit;
        if (holding == 1) {
            maxProfit = Math.max(maxProfit(prices, day + 1, remainingTrans, 0, memo) + prices[day], // sell
                    maxProfit(prices, day + 1, remainingTrans, 1, memo)); // do nothing - keep holding
        }
        else {
            maxProfit = Math.max(maxProfit(prices, day + 1, remainingTrans, 0, memo), // do nothing - keep holding
                    maxProfit(prices, day + 1, remainingTrans - 1, 1, memo) - prices[day]); // buy
        }
        return memo[day][remainingTrans][holding] = maxProfit;
    }

    // DP - top down
    public static int maxProfitByBuySellStockAnyTimesWithTransactionFee() {
        int prices[] = {1,3,2,8,4,9};
        int fee = 2;
        return dp(prices, fee, 0, 0, new Integer[prices.length][2]);
    }
    private static int dp(int[] prices, int fee, int index, int holding, Integer[][] memo) {
        if (index == prices.length) return 0;
        if (memo[index][holding] != null) return memo[index][holding];

        if (holding == 0) {
            int buy = dp(prices, fee, index + 1, 1, memo) - prices[index];
            int doNothing = dp(prices, fee, index + 1, holding, memo);
            memo[index][holding] = Math.max(buy, doNothing);
        } else {
            int sell = dp(prices, fee, index + 1, 0, memo) + prices[index] - fee;
            int doNothing = dp(prices, fee, index + 1, holding, memo);
            memo[index][holding] = Math.max(sell, doNothing);
        }
        return memo[index][holding];
    }
}
