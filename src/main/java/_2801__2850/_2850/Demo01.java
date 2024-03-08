package _2801__2850._2850;

import org.junit.Test;
import util.Common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumMoves(Common.strToArray("[" +
                "[0,0,0]," +
                "[0,0,0]," +
                "[0,0,9]]")));
    }

    public int minimumMoves(int[][] grid) {
        List<int[]> overflow = new LinkedList<>();
        List<int[]> empty = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) overflow.add(new int[]{i, j, grid[i][j]});
                if (grid[i][j] == 0) empty.add(new int[]{i, j});
            }
        }
        return dfs(overflow, empty, 0);
    }

    private int dfs(List<int[]> overflow, List<int[]> empty, int idx) {
        if (idx >= empty.size()) return 0;
        int min = Integer.MAX_VALUE;
        for (int[] ints : overflow) {
            List<int[]> copy = new ArrayList<>();
            for (int[] arr : overflow) if (arr != ints) copy.add(arr);
            if (ints[2] > 2) copy.add(new int[]{ints[0], ints[1], ints[2] - 1});
            min = Math.min(min, Math.abs(empty.get(idx)[0] - ints[0]) + Math.abs(empty.get(idx)[1] - ints[1]) + dfs(copy, empty, idx + 1));
        }
        return min;
    }

}