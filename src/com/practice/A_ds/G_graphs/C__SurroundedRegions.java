package com.practice.A_ds.G_graphs;

/**
 * Created by prathapchowdary on 09/07/23.
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * https://leetcode.com/problems/surrounded-regions/
 */
public class C__SurroundedRegions {

  /**
   * for first and last row & cols connected islands mark as *
   * in next iteration all marked *'s ccould be 0's rest all could be X's
   */
  public void solve(char[][] board) {
    if(board.length==0) return;

    int row = board.length,col = board[0].length;

    for(int i=0; i<col; i++){
      dfs(board, 0,     i, row, col); //for FIRST ROW
      dfs(board, row-1, i, row, col); //for LAST ROW
    }
    for(int i=0;i<row;i++){
      dfs(board, i, 0,     row, col); //for FIRST COLUMN
      dfs(board, i, col-1, row, col); //for LAST COLUMN
    }
    for(int i=0;i<row;i++) {
      for(int j=0;j<col;j++) {
        if(board[i][j]=='O') board[i][j]='X';
        else if(board[i][j]=='*') board[i][j]='O';
      }
    }
  }

  private void dfs(char[][] board, int r, int c, int rsize, int csize) {
    if(r<0||c<0||r==rsize||c==csize||board[r][c]!='O') return;
    board[r][c] = '*';
    dfs(board, r+1, c,  rsize, csize);
    dfs(board, r,   c+1,rsize, csize);
    dfs(board, r-1, c,  rsize, csize);
    dfs(board, r,   c-1,rsize, csize);
  }
}
