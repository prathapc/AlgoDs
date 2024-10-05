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

        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
        //maxProfitWithCooldown();

    }

    /**
     * The series of problems are typical dp. The key for dp is to find the variables to represent
     * the states and deduce the transition function.
     *
     * Of course one may come up with a O(1) space solution directly, but I think it is better to
     * be generous when you think and be greedy when you implement.
     *
     * The natural states for this problem is the 3 possible transactions : buy, sell, rest.
     * Here rest means no transaction on that day (aka cooldown).
     *
     * Then the transaction sequences can end with any of these three states.
     *
     * For each of them we make an array, buy[n], sell[n] and rest[n].
     *
     * buy[i] means before day i what is the maxProfit for any sequence end with buy.
     *
     * sell[i] means before day i what is the maxProfit for any sequence end with sell.
     *
     * rest[i] means before day i what is the maxProfit for any sequence end with rest.
     *
     * Then we want to deduce the transition functions for buy sell and rest. By definition we have:
     *
     * buy[i]  = max(rest[i-1]-price, buy[i-1])
     * sell[i] = max(buy[i-1]+price, sell[i-1])
     * rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
     * Where price is the price of day i. All of these are very straightforward. They simply represents :
     *
     * (1) We have to `rest` before we `buy` and
     * (2) we have to `buy` before we `sell`
     * One tricky point is how do you make sure you sell before you buy, since from the equations it seems that [buy, rest, buy] is entirely possible.
     *
     * Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]). That made sure [buy, rest, buy] is never occurred.
     *
     * A further observation is that and rest[i] <= sell[i] is also true therefore
     *
     * rest[i] = sell[i-1]
     * Substitute this in to buy[i] we now have 2 functions instead of 3:
     *
     * buy[i] = max(sell[i-2]-price, buy[i-1])
     * sell[i] = max(buy[i-1]+price, sell[i-1])
     * This is better than 3, but
     *
     * we can do even better
     *
     * Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1).
     */
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
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
