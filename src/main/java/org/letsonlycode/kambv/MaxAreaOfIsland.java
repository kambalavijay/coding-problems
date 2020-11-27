package org.letsonlycode.kambv;

public class MaxAreaOfIsland {
    private static int dfs(int i, int j, int[][] grid) {

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return 1 +  dfs(i+1, j, grid) +
                    dfs(i-1, j, grid) +
                    dfs(i, j-1, grid) +
                    dfs(i, j+1, grid);
    }

    public static void main(String[] args) {

        int grid[][] = new int[][]{
                {0,1,1,1,1,0,0,1,0,0,0,0,0},
                {1,0,1,0,0,0,0,1,1,1,0,0,0},
                {1,1,1,0,1,0,0,0,0,0,0,0,0},
                {1,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {1,1,0,0,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,1,1,1,0,0,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
    }
}
