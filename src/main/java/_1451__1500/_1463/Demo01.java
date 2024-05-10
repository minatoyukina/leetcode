package _1451__1500._1463;

import org.junit.Test;
import util.Common;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(cherryPickup(Common.strToArray("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]")));
    }

    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int[][] ints : dp) for (int[] anInt : ints) Arrays.fill(anInt, -1);
        return dfs(grid, 0, 0, grid[0].length - 1);
    }

    private int[][][] dp;

    private int dfs(int[][] grid, int row, int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (row >= m) return 0;
        if (dp[row][x][y] >= 0) return dp[row][x][y];
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            int x1 = x + i;
            if (x1 < 0 || x1 >= n) continue;
            for (int j = -1; j <= 1; j++) {
                int y1 = y + j;
                if (y1 < 0 || y1 >= n || y1 == x1) continue;
                max = Math.max(max, grid[row][x] + grid[row][y] + dfs(grid, row + 1, x1, y1));
            }
        }
        return dp[row][x][y] = max;
    }

}