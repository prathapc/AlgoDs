package com.practice.B_algo_ps.K_sort_search_math.intervals;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class BuySellStocks {

    public static void main(String[] args) throws Exception {
        maxProfitByBuySellStockAtMost1Time();
        maxProfitByBuySellStockAnyNoOfTimes();
        maxProfitByBuySellStockAtMost2Times();
        maxProfitByBuySellStockAtMostKTimes();
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    private static int maxProfitByBuySellStockAtMost1Time() {
        int[] prices = {7,1,5,3,6,4};
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

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
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

    private static void maxProfitByBuySellStockAtMost2Times() {
        //int price[] = {2,30,15,10,8,25,80};
        int price[] = {10,5,22,65,8,75,90,80};
        int n = price.length;

        // Create profit array and initialize it as 0
        int profit[] = new int[n];
        for (int i=0; i<n; i++)
            profit[i] = 0;

        /* Get the maximum profit with only one transaction
           allowed. After this loop, profit[i] contains maximum
           profit from price[i..n-1] using at most one trans. */
        int max_price = price[n-1];
        for (int i=n-2;i>=0;i--)
        {
            // max_price has maximum of price[i..n-1]
            if (price[i] > max_price)
                max_price = price[i];

            // we can get profit[i] by taking maximum of:
            // a) previous maximum, i.e., profit[i+1]
            // b) profit by buying at price[i] and selling at
            //    max_price
            profit[i] = Math.max(profit[i+1], max_price-price[i]);
        }

        /* Get the maximum profit with two transactions allowed
           After this loop, profit[n-1] contains the result */
        int min_price = price[0];
        for (int i=1; i<n; i++)
        {
            // min_price is minimum price in price[0..i]
            if (price[i] < min_price)
                min_price = price[i];

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and add
            //    profit of other trans. stored in profit[i]
            profit[i] = Math.max(profit[i-1], profit[i] +
                    (price[i]-min_price) );
        }
        System.out.println(profit[n-1]);
    }

    //https://www.youtube.com/watch?v=oDhu5uGq_ic&t=293s
    private static void maxProfitByBuySellStockAtMostKTimes() {
        int k = 3;
        int price[] = {12, 14, 17, 10, 14, 13, 12, 15};

        int n = price.length;

        // table to store results of subproblems
        // profit[t][i] stores maximum profit
        // using atmost t transactions up to day
        // i (including day i)
        int profit[][] = new int[k + 1][ n + 1];

        // For day 0, you can't earn money
        // irrespective of how many times you trade
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        // profit is 0 if we don't do any
        // transation (i.e. k =0)
        for (int j = 0; j <= n; j++)
            profit[0][j] = 0;

        // fill the table in bottom-up fashion
        for (int i = 1; i <= k; i++)
        {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++)
            {
                prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
                profit[i][j] = Math.max(profit[i][j - 1], price[j] + prevDiff);
            }
        }

        System.out.println(profit[k][n - 1]);
    }


}
