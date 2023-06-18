package com.practice.E_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by prathap on 18/08/17.
 */
public class Java8Examples {
  public static void main(String[] args) {
    //iterate over string array
    String[] words = new String[]{"i","love","leetcode","i","love","coding"};
    Arrays.stream(words).forEach(System.out::println);

    //get string from list of max length
    List<String> names = new ArrayList<>();
    names.add("abc"); names.add("pq"); names.add("wxyz");
    names.stream().max(Comparator.comparing(String::length)); // gives wxyz
    names.stream()
            .mapToInt(String::length)
            .max()
            .orElse(0); // gives 4

    //predicate
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

    //sum of list elements using stream
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
    Integer sum = integers.stream()
      .mapToInt(Integer::intValue)
      .sum();
    /**
     * for custom type:
     * int totalWeight = servers.stream()
     *             .mapToInt(Node::getWeight)
     *             .reduce((a,b)->a+b).getAsInt();
     */


    //
    System.out.println("*chars stream test*");
    String str = "w90ko";
    str.chars()
            .filter(ch -> Character.isDigit(ch))
            .mapToObj(ch -> Character.valueOf((char)ch))
            .forEach(System.out::println);
  }

}
