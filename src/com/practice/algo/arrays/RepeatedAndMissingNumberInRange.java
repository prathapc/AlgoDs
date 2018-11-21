package com.practice.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedAndMissingNumberInRange {

  public static void main(String args[]) {
    repeatedNumber(Arrays.asList(new Integer[]{3,1,2,5,3}));
  }

  private static void repeatedNumber(final List<Integer> a) {
    int arraySize = a.size();
    long sumOfNumbers = getSumOfNumbers(arraySize);
    long sumOfSquares = getSumOfSquares(arraySize);
    long differenceNumber =  getDifferenceofNumbers(a,sumOfNumbers);
    long differenceSquare = getDifferenceofSquares(a,sumOfSquares);
    long sumNumber =  differenceSquare/differenceNumber;
    int repeatedNumber = (int)((sumNumber+differenceNumber)/2);
    int missingNumber = (int)(sumNumber-repeatedNumber);
    ArrayList<Integer> result = new ArrayList<>();
    result.add(repeatedNumber);
    result.add(missingNumber);
    result.forEach(e -> System.out.println(e));
  }

  private static long getDifferenceofNumbers(List<Integer> a,long sumOfNumbers){
    long sum = sumOfNumbers*-1;
    for(Integer number:a){
      long num = (long)number;
      sum+=num;
    }
    return sum;
  }

  private static long getDifferenceofSquares(List<Integer> a, long sumOfSquares){
    long sumSquares = sumOfSquares*-1;
    for(Integer number:a){
      long num = (long)number;
      sumSquares+=(num*num);
    }
    return sumSquares;
  }

  private static long getSumOfNumbers(double n){
    return (long)(n*(n-1)/2+n);
  }

  private static long getSumOfSquares(double n){
    return (long)(n*(n+1)*(2*n+1)/6);
  }
}
