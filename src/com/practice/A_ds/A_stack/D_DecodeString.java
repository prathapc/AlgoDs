package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by prathapchowdary on 17/03/22.
 *
 * Input: s = "3[a]2[bc]" Output: "aaabcbc"
 *
 * https://leetcode.com/problems/decode-string/
 */
public class D_DecodeString {

  public String decodeString(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == ']') {
        //get substring inside [ and ]
        StringBuilder sb = new StringBuilder();
        while (stack.peek() != '[') {
          sb.append(stack.pop());
        }
        stack.pop(); //remove "[" from stack

        //get number
        StringBuilder number = new StringBuilder();
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
          number.append(stack.pop());
        }
        int num = Integer.parseInt(number.reverse().toString());

        //repeat substring num times
        String tmp = sb.reverse().toString();
        while (--num > 0) {
          sb.append(tmp);
        }

        //push back resultant string to stack
        for (char chr : sb.toString().toCharArray()) {
          stack.push(chr);
        }
      } else {
        stack.push(c);
      }
    }
    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty()) {
      res.append(stack.pop());
    }
    return res.reverse().toString();
  }
}
