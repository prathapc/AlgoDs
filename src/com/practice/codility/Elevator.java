package com.practice.codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathap on 07/10/17.
 */
public class Elevator {
  public static void main(String args[]) {
    int[] A = new int[] {60, 80, 40};
    int[] B = new int[] {2, 3, 5};
    int M = 5;
    int X = 2;
    int Y = 200;
    System.out.print(solution(A, B, M, X, Y));
  }

  public static int solution(int[] A, int[] B, int M, int X, int Y) {
    if (A == null || B == null || A.length == 0 || B.length == 0 || X < 1 || Y < 1) {
      return 0;
    }
    int res = 0;
    Queue<Task> taskQueue = new LinkedList<>();
    for (int i = 0; i < A.length; i++) {
      if (A[i] > Y) {
        throw new RuntimeException("Overweight person detected!");
      }
      taskQueue.add(new Task(A[i], B[i]));
    }
    while (!taskQueue.isEmpty()) {
      res += helper(taskQueue, M, X, Y);
    }
    return res;
  }

  /**
   * Process as much tasks as possible and then remove tasks from task queue.
   * <p>
   * Note: Here we use <code>bitmap</code> for enhance performance, while <code>set</code> is also an alternative.
   *
   * @param taskQueue task queue
   * @param M         floor range
   * @param X         max persons
   * @param Y         max weigth
   *
   * @return stops
   */
  static int helper(Queue<Task> taskQueue, int M, int X, int Y) {
    BitSet floors = new BitSet(M);
    while (!taskQueue.isEmpty() && X > 0 && (Y - taskQueue.peek().weight) >= 0) {
      Task task = taskQueue.poll();
      X -= 1;
      Y -= task.weight;
      floors.set(task.floor);
    }
    return floors.cardinality() + 1;
  }

  /**
   * Task
   * <p>
   * For simplicity, here I do not let it be a POJO, just expose field publicly.
   */
  static class Task {
    int weight;
    int floor;

    public Task(int weight, int floor) {
      this.weight = weight;
      this.floor = floor;
    }
  }

  @Test
  public void test() {
    int[] A = new int[] {60, 80, 40};
    int[] B = new int[] {2, 3, 5};
    int M = 5;
    int X = 2;
    int Y = 200;
    Assert.assertEquals(solution(A, B, M, X, Y), 5);

    A = new int[] {40, 40, 100, 80, 20};
    B = new int[] {3, 3, 2, 2, 3};
    M = 3;
    X = 5;
    Y = 200;
    Assert.assertEquals(solution(A, B, M, X, Y), 6);

    A = new int[] {40, 40, 100, 200, 20};
    B = new int[] {3, 3, 2, 2, 3};
    M = 3;
    X = 5;
    Y = 200;
    Assert.assertEquals(solution(A, B, M, X, Y), 7);

    A = new int[] {40, 40, 100, 200, 20};
    B = new int[] {3, 3, 2, 2, 3};
    M = 3;
    X = 1;
    Y = 200;
    Assert.assertEquals(solution(A, B, M, X, Y), 10);
  }
}
