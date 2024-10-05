package com.practice.A_ds.G_graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathapchowdary on 24/11/23.
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class E_WallsAndGates {

    static int EMPTY = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        boolean visited[][] = new boolean[rooms.length][rooms[0].length];
        for(int i=0; i< rooms.length; i++){
            for(int j=0; j< rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms, i, j, visited, 0);
                }
            }
        }
    }
    private void dfs(int[][] rooms, int x, int y, boolean[][] visited, int distance){
        if(x < 0 || x >= rooms.length
            || y < 0 || y >= rooms[0].length || rooms[x][y] == -1)
            return;
        if(visited[x][y] || distance > rooms[x][y]) return;

        rooms[x][y] = Math.min(rooms[x][y], distance);// since a room is already 0,
        // in first level, there is no set really.
        visited[x][y] = true;//  to avoid loop.
        dfs(rooms, x+1, y, visited, distance+1);
        dfs(rooms, x-1, y, visited, distance+1);
        dfs(rooms, x, y+1, visited, distance+1);
        dfs(rooms, x, y-1, visited, distance+1);
        visited[x][y] =false;

    }

    //bfs solution
    public void wallsAndGates_bfs(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) q.add(new int[] { i, j });
            }
        }
        if (q.size() == 0) return;
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (
                    x >= m ||
                        y >= n ||
                        x < 0 ||
                        y < 0 ||
                        rooms[x][y] != Integer.MAX_VALUE
                ) continue;
                q.add(new int[] { x, y });
                //since cur is basically the index of door (which is equal to 0)
                //So, we can just grab that value (rooms[row][col]) and add 1 to it and change it every time
                rooms[x][y] = rooms[row][col] + 1;
                //So, one level further from door (value 0) is equal to 1. Now, we do bfs from that position so value will be 2 and so on.
            }
        }
    }
}
