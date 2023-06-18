package com.practice.E_java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by prathap on 23/11/17.
 */
public class LambdaExample {

  public static void main(String args[]) {
    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    //shorter code
    Collections.sort(names, (String a, String b) -> {
      return b.compareTo(a);
    });

    //even shorter code -> you can skip both the braces {} and the return keyword
    Collections.sort(names, (String a, String b) -> b.compareTo(a));

    //The java compiler is aware of the parameter types so you can skip them as well
    Collections.sort(names, (a, b) -> b.compareTo(a));


  }

}
