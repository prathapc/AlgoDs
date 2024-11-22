package com.practice.D_design.lld;

import java.util.concurrent.TimeUnit;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by prathapchowdary on 18/11/23.
 */
public class G_DelayedQueue {
    public interface DelayedScheduler {
        void delayedRun(long timeToRunFromNowMillis, Runnable task);
    }

    static class MyDelayedScheduler implements DelayedScheduler {

        private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        private final PriorityQueue<DelayedTask> delayedTasks = new PriorityQueue<>();

        @Override
        public void delayedRun(long timeToRunFromNowMillis, Runnable task) {
            long scheduledTime = System.currentTimeMillis() + timeToRunFromNowMillis;
            DelayedTask delayedTask = new DelayedTask(scheduledTime, task);
            delayedTasks.offer(delayedTask);

            // Schedule the next task
            executorService.schedule(() -> executeNextTask(), timeToRunFromNowMillis, TimeUnit.MILLISECONDS);
        }

        private void executeNextTask() {
            DelayedTask nextTask = delayedTasks.poll();
            if (nextTask != null) {
                nextTask.run();
            }
        }

        private class DelayedTask implements Comparable<DelayedTask>, Runnable {
            private final long scheduledTime;
            private final Runnable task;

            public DelayedTask(long scheduledTime, Runnable task) {
                this.scheduledTime = scheduledTime;
                this.task = task;
            }

            @Override
            public void run() {
                task.run();
            }

            @Override
            public int compareTo(DelayedTask other) {
                return Long.compare(this.scheduledTime, other.scheduledTime);
            }
        }
    }

    public static void main(String[] args) {
        DelayedScheduler scheduler = new MyDelayedScheduler();

        Runnable task1 = () -> System.out.println("Task 1 executed");
        Runnable task2 = () -> System.out.println("Task 2 executed");
        Runnable task3 = () -> System.out.println("Task 3 executed");

        scheduler.delayedRun(10000, task1);
        scheduler.delayedRun(15000, task2);
        scheduler.delayedRun(30000, task3);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
