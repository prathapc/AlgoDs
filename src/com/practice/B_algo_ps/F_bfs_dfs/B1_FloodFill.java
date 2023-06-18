package com.practice.B_algo_ps.F_bfs_dfs;

/**
 * Created by prathapchowdary on 18/03/22.
 *
 * https://leetcode.com/problems/flood-fill/
 */
public class B1_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int existingColor = image[sr][sc];
        if (existingColor == newColor) return image;
        dfs(image, sr, sc, existingColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int existingColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != existingColor)
            return;

        image[r][c] = newColor;

        dfs(image, r-1, c, existingColor, newColor);
        dfs(image, r+1, c, existingColor, newColor);
        dfs(image, r, c-1, existingColor, newColor);
        dfs(image, r, c+1, existingColor, newColor);
    }
}
