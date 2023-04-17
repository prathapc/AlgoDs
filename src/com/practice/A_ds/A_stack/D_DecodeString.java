package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by prathapchowdary on 17/03/22.
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * https://leetcode.com/problems/decode-string/
 */
public class D_DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c==']'){
                StringBuilder sb=new StringBuilder();
                while(stack.peek()!='['){
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder number=new StringBuilder();
                while(!stack.isEmpty() && stack.peek()<90 ){
                    number.append(stack.pop());
                }
                int num=Integer.parseInt(number.reverse().toString());
                String tmp=sb.reverse().toString();
                for(int i=1;i<num;i++){
                    sb.append(tmp);
                }
                for(char chr: sb.toString().toCharArray()){
                    stack.push(chr);
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop()) ;
        }
        return res.reverse().toString();
    }
}
