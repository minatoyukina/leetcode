package _1301__1350._1310;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
    }

    private int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                ans[i] ^= arr[j];
            }
        }
        return ans;
    }

}