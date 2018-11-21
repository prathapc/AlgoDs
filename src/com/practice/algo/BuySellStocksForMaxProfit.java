package com.practice.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * The cost of a stock on each day is given in an array,
 * find the max profit that you can make by buying and selling in those days
 *
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
public class BuySellStocksForMaxProfit {

  public static void main(String args[]) {
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
}
