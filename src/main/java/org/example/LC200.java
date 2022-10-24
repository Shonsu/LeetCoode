package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}
        };

        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        boolean[][] gridVisited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!gridVisited[i][j]) {
                    if (grid[i][j] == '1') {
                        buildIsland(grid, gridVisited, i, j);
                        islandCount++;
                    }
                }
            }
        }
        return islandCount;
    }
    private static void buildIsland(char[][] grid, boolean[][] gridVisited, int i, int j) {

        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || gridVisited[i][j] || grid[i][j] != '1')
            return;
        gridVisited[i][j] = true;
        buildIsland(grid, gridVisited, i - 1, j);
        buildIsland(grid, gridVisited, i + 1, j);
        buildIsland(grid, gridVisited, i, j - 1);
        buildIsland(grid, gridVisited, i, j + 1);
    }


}
