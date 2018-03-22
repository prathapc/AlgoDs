package com.practice.codility;

/**
 * Created by prathap on 27/02/18.
 */
public class CasinoGameRounds {

  public static void main(String args[]) {
    System.out.print(solution(147, 10));
  }

  public static int solution(int N, int K) {
    // write your code in Java SE 8
    int result = 0;
    while(N>0) {
      if(N%2 == 0) {
        if(--K >= 0) {
          N /= 2;
        } else {
          N--;
        }
      } else {
        N--;
      }
      result++;
    }
    return result-1;
  }
}
