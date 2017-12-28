package com.practice.algo.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prathap on 17/12/17.
 */
public class PrimeSum {

  public static void main(String args[]) {
    PrimeSum ps = new PrimeSum();
    //ps.primesum(10);

  }



  public ArrayList<Integer> primesum(int a) {
    ArrayList<Integer> result = new ArrayList<>();
    List<Integer> primeNumbers = new ArrayList<>();
    primeNumbers.add(2);
    for(int i=3; i<a; i++) {
      if(isPrime(i)) {
        primeNumbers.add(i);
      }
    }
    int i=0;
    int j=primeNumbers.size()-1;
    while(i<j) {
      if(primeNumbers.get(i) * 2 == a) {
        result.add(i);
        result.add(j);
        break;
      }
      int sum = primeNumbers.get(i) + primeNumbers.get(j);
      if(sum == a) {
        result.add(i);
        result.add(j);
        break;
      } else if(sum > a) {
        j--;
      } else {
        i++;
      }
    }
    return result;
  }

  private boolean isPrime(int num) {
    if ( num > 2 && num%2 == 0 ) {
      System.out.println(num + " is not prime");
      return false;
    }
    int top = (int)Math.sqrt(num) + 1;
    for(int i = 3; i < top; i+=2){
      if(num % i == 0){
        System.out.println(num + " is not prime");
        return false;
      }
    }
    return true;
  }
}
