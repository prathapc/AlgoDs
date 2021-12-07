package com.practice.F_companyQA.Tekion;

/**
 * *) FizzBuzz - Print numbers from 1 to 100. If a number is divisible by 3, print ‘Fizz,
 * if it is divisible by 5, print ‘Buzz’,
 * if it is divisible by both, print ‘FizzBuzz’, else print the number.
 */
public class TekiornTest {
  public static void main(String[] args) {
    for (int i=3; i<=100; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        System.out.println("FizzBuzz");
      } else if (i % 3 == 0) {
        System.out.println("Fizz");
      } else if (i % 5 == 0) {
        System.out.println("Buzz");
      } else {
        System.out.println(i);
      }
    }
  }
}
