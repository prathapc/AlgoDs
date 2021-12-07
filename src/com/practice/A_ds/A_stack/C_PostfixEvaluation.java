package com.practice.A_ds.A_stack;

import java.util.*;
import java.util.Stack;

/**
 * Created by prathap on 10/12/17.
 */
public class C_PostfixEvaluation {

  public static void main(String args[]) {
    ArrayList<String> input = new ArrayList<>();
    input.add("5");
    input.add("1");
    input.add("2");
    input.add("+");
    input.add("4");
    input.add("*");
    input.add("+");
    input.add("3");
    input.add("-");
    System.out.print(evalRPN(input));
  }


  public static int evalRPN(ArrayList<String> a) {
    java.util.Stack<String> stack = new Stack<>();
    int result = 0;
    for(String s : a) {
      if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
        String s1 = stack.pop();
        String s2 = stack.pop();
        Integer n1 = Integer.parseInt(s1);
        Integer n2 = Integer.parseInt(s2);
        if(s.equals("+")) {
          result = (n1+n2);
        }else if(s.equals("-")) {
          result = (n1-n2);
        }else if(s.equals("*")) {
          result = (n1*n2);
        }else if(s.equals("/")) {
          result = (n1/n2);
        }
        stack.push(String.valueOf(result));
      } else {
        stack.push(s);
      }
    }
    return Integer.parseInt(stack.pop());
  }
}
