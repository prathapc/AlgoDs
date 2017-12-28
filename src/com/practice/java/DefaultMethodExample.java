package com.practice.java;

/**
 * Created by prathap on 23/11/17.
 */
public class DefaultMethodExample {
  public static void main(String args[]) {
    //anonymous object
    Formula formula = new Formula() {
      @Override
      public double calculate(int a) {
        return 0;
      }
    };
  }

  public interface Formula {
    double calculate(int a);

    //non-abstract method is possible in java8 with 'default'
    default double sqrt(int a) {
      return Math.sqrt(a);
    }
  }
}

