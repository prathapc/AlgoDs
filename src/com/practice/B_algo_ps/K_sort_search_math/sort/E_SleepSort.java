package com.practice.B_algo_ps.K_sort_search_math.sort;

import java.util.concurrent.CountDownLatch;

/**
 * Created by prathapchowdary on 08/07/23.
 *
 * https://xeiaso.net/blog/sleeping-the-technical-interview
 *
 * Sleep sort works by starting a separate task for each item to be sorted.
 * Each task sleeps for an interval corresponding to the item's sort key, then emits the item.
 * Items are then collected sequentially in time.
 */
public class E_SleepSort {
  public static void sleepSortAndPrint(int[] nums) {
    final CountDownLatch doneSignal = new CountDownLatch(nums.length);
    for (final int num : nums) {
      new Thread(new Runnable() {
        public void run() {
          doneSignal.countDown();
          try {
            doneSignal.await();

            //using straight milliseconds produces unpredictable
            //results with small numbers
            //using 1000 here gives a nifty demonstration
            Thread.sleep(num * 500);
            System.out.println(num);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }).start();
    }
  }
  public static void main(String[] args) {
    int[] nums ={700, 3, 2, 1, 0, 5};
    for (int i = 0; i < args.length; i++)
      nums[i] = Integer.parseInt(args[i]);
    sleepSortAndPrint(nums);
  }
}
