package com.practice.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by prathap on 18/08/17.
 */
public class Java8Examples {
  public static void main(String[] args) {
    List<Integer> listOFNumbers = new ArrayList<>();
    listOFNumbers.add(1);
    listOFNumbers.add(2);
    listOFNumbers.add(3);
    listOFNumbers.add(4);
    listOFNumbers.add(5);
    listOFNumbers.add(6);

    Predicate<Integer> isEven = e -> e%2 == 0;

    listOFNumbers.stream().filter(isEven).forEach(System.out::println);

    //other way by accessing index of array
    IntStream.range(0, listOFNumbers.size())
        .forEach(index -> {
          if(listOFNumbers.get(index) % 2 == 0) {
            System.out.print(index);
          }
    });
  }

}
