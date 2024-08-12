package _3051__3100._3071;

import org.junit.Test;
import util.Common;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumOperationsToWriteY(Common.strToArray("[" +
                "[1,2,2]," +
                "[1,1,0]," +
                "[0,1,0]" +
                "]")));
    }

    public int minimumOperationsToWriteY(int[][] grid) {
        int a0 = 0, a1 = 0, a2 = 0, b0 = 0, b1 = 0, b2 = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean b = (i == j && j < n / 2) || (i >= n / 2 && j == n / 2) || (i + j == n - 1 && j > n / 2);
                if (grid[i][j] == 0) {
                    if (b) b0++;
                    else a0++;
                }
                if (grid[i][j] == 1) {
                    if (b) b1++;
                    else a1++;
                }
                if (grid[i][j] == 2) {
                    if (b) b2++;
                    else a2++;
                }
            }
        }
        int x = a1 + a2 + Math.min(b0 + b2, b0 + b1);
        int y = a0 + a2 + Math.min(b1 + b2, b0 + b1);
        int z = a0 + a1 + Math.min(b1 + b2, b0 + b2);
        return Math.min(x, Math.min(y, z));
    }

}