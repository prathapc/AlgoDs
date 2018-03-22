package com.practice.codility;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MaxNumberOfTwinGroups {

    public static void main(String args[]) {
        System.out.print(solution("LR"));
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        int lCount = 0, rCount = 0, result = 0;
        for(int i=0; i<S.length(); i++) {
            if(lCount > 0 && rCount > 0 && lCount == rCount) {
                result++;
                lCount = 0;
                rCount = 0;
            }
            if (S.charAt(i) == 'L') {
                lCount++;
            } else if (S.charAt(i) == 'R') {
                rCount++;
            } else {
                System.exit(0);
            }
        }
        return result+1;
    }
}