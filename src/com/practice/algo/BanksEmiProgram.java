package com.practice.algo;

import java.util.Scanner;

public class BanksEmiProgram {

  public static void main(String args[]) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int principle = scanner.nextInt();
    int totalYears = scanner.nextInt();
    double bankAamount = totalEmiPayable(principle, totalYears);
    double bankBamount = totalEmiPayable(principle, totalYears);

    if (bankAamount < bankBamount) {
      System.out.print("Bank A");
    } else {
      System.out.print("Bank B");
    }
  }

  private static double totalEmiPayable(int principle, int totalYears) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int intSlabs = scanner.nextInt();
    int years[] = new int[intSlabs];

    double interest[] = new double[intSlabs];
    for (int i=0; i<intSlabs; i++) {
      years[i] = scanner.nextInt();
      interest[i] = scanner.nextDouble();
    }

    int givenYears = 0;
    for (int i=0; i<intSlabs; i++) {
      givenYears += years[i];
    }

    if (totalYears != givenYears) {
      throw new Exception("total years and slabs not matching!");
    }

    double[] totalEmiAmount = new double[intSlabs];
    for (int i=0; i<intSlabs; i++) {
      totalEmiAmount[i] = principle * interest[i] / (1-1/Math.pow(1 + interest[i], years[i] * 12));
    }

    double result = 0;
    for (int i=0; i<intSlabs; i++) {
      result += totalEmiAmount[i];
    }
    return result;
  }
}
