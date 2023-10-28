package com.practice.B_algo_ps.H_backtracking;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 * Created by prathap on 04/08/17.
 */
public class G_MazePath_BackTracking {
  public static void main(String[] args) {
    int a[][] = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
    };
    findPathInMaze(a, 4, 4);
  }

  private static void findPathInMaze(int maze[][], int r, int c) {
    int[][] sol = new int[r][c];
    sol[0][0] = 1; //we are starting from this cell
    int[] moveX = {1, 0, 0, -1};
    int[] moveY = {0, 1, -1, 0};

    if(findPathInMazeUtil(maze, sol, 0, 0, moveX, moveY, 1)) {
      Utility.printArray(sol, r, c);
    }
    System.out.print("No Sol exist");
  }

  private static boolean findPathInMazeUtil(int[][] maze, int[][] sol, int x, int y, int[] moveX, int[] moveY, int movei) {

    //base condition - exit on reaching destincation cell
    if(x == 3 && y == 3) {
      sol[3][3] = 1;
      return true;
    }
    //base condition - exit on traversing all possible cells
    if(movei == 16) {
      return false;
    }

    int nextX, nextY;
    for(int k=0; k<4; k++) {
      nextX = x + moveX[k];
      nextY = y + moveY[k];
      if(isValidCell(maze, nextX, nextY)) {
        //make decision
        sol[nextX][nextY] = 1;
        System.out.println("nextX:"+nextX+"  nextY:"+nextY);
        if(findPathInMazeUtil(maze, sol, nextX, nextY, moveX, moveY, movei+1)) {
          return true;
        }
        //backtracking
        sol[nextX][nextY] = 0;
      }
    }
    return false;
  }

  private static boolean isValidCell(int[][] maze, int x, int y) {
    return (x>=0 && y>=0 && x < 4 && y < 4 && maze[x][y] != 0);
  }
}
