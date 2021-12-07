package com.practice.B_algo.J_bfs_dfs;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class MinModificationsToReachDest {

    public static void main(String[] args) {
        char[][] arr = {{'R','R','D'},{'L','L','L'},{'U','U','R'}};
        char[][] arr2 = {{'D','L','L'},{'L','R','D'},{'U','U','R'}};
        System.out.println(findMinimumModifications(arr));
        System.out.println(findMinimumModifications(arr2));
    }

    private static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static char[] dc = {'D', 'R', 'U', 'L'};
    private static int findMinimumModifications(char[][] arr) {
        if(arr == null || arr.length == 0)
            return -1;
        int m = arr.length;
        int n = arr[0].length;
        int[][] result = new int[m][n];
        for(int[] res : result) {
            Arrays.fill(res, Integer.MAX_VALUE);
        }
        result[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            for(int i=0; i<4; ++i) {
                int[] d = dir[i];
                int x = d[0] + info[0];
                int y = d[1] + info[1];
                if(x>=0 && y>=0 && x<m && y<n) {
                    int temp = arr[info[0]][info[1]] == dc[i] ? 0 : 1;
                    if(result[x][y] != Integer.MAX_VALUE) {
                        int cur = result[x][y] + temp;
                        if(result[x][y] <= cur) continue;
                    }
                    result[x][y] = temp;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return result[m-1][n-1];
    }
}
