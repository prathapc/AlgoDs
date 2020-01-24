package com.practice.algo.arrays;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class BuySellStocks {

    public static void main(String[] args) throws Exception {
        maxProfitByBuySellStockAnyNoOfTimes();
        maxProfitByBuySellStockAtMost2Times();
        maxProfitByBuySellStockAtMostKTimes();
    }

    private static void maxProfitByBuySellStockAnyNoOfTimes() {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        int n = prices.length;
        List<Interval> transactions = new ArrayList<>();
        int i=0;
        while (i < n-1) {
            //find local minima
            while (i < n-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            if (i == n-1) {
                break;
            }
            Interval e = new Interval();
            e.buy = i++;

            //find local maxima
            while (i < n && prices[i-1] <= prices[i]) {
                i++;
            }
            e.sell = i-1;
            transactions.add(e);
        }

        transactions.forEach(e -> System.out.println(e.buy + ":" + e.sell));
    }

    static class Interval {
        int buy;
        int sell;
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

    private static void maxProfitByBuySellStockAtMost2Times() {
        int price[] = {2, 30, 15, 10, 8, 25, 80};
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
        System.out.print(profit[n-1]);
    }
}
