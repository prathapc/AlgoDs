package com.practice.ps;

/**
 * Created by prathap on 09/10/17.
 *
 * An Linear Array can be used to represent the Snake and Ladder Game.
 * Each index will tell us the position we have rolled dice for. say board.

 and board[i]=i

 Representing Snake & Ladder.
 Say there is snake from which takes us from 10 to 3 then

 board[10]=3
 similarly for Ladders.

 Throw of Dice

 The throw of dice can be implemented by a function returning a random number between 1 and 6.

 Game of Play.
 we get evaluate the player position by checking the position the player has rolled for in the board i.e.
 say i am at 10 and by throw of dice returns 3 so I will check board[13] and the value will be final position.
 */
public class SnakeLadderGame {

  public static void main(String args[]) {
    initialiseBoard();
  }

  private static int[] initialiseBoard() {
    int a[] = new int[64];

    return a;
  }



}
