package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 07/08/23.
 *
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
 * to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel
 * around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution,
 * it is guaranteed to be unique
 *
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 *
 * https://leetcode.com/problems/gas-station/
 */
public class R_GasStation {

  //O(n^2) - bruteforce - TLE
  //traverse one by one and check if we can cover all stations with out running out of fuel
  //once we run out of fuel, break and start from next index
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    for (int i=0; i<n; i++) {
      int totFuel = 0;
      int stopCount = 0;
      int j = i;
      while (stopCount < n) {
        totFuel += gas[j%n] - cost[j%n];
        if (totFuel < 0) break;
        stopCount++;
        j++;
      }
      if (stopCount == n && totFuel >= 0) return i;
    }
    return -1;
  }

  //O(n) - instead of starting again from back which are any way invalid starting points
  //start from next position
  public int canCompleteCircuit1(int[] gas, int[] cost) {
    int n = gas.length;
    int total_surplus = 0;
    int surplus = 0;
    int start = 0;

    for(int i = 0; i < n; i++){
      total_surplus += gas[i] - cost[i];
      surplus += gas[i] - cost[i];
      if(surplus < 0){
        surplus = 0;
        start = i + 1;
      }
    }
    return (total_surplus < 0) ? -1 : start;
  }
}
