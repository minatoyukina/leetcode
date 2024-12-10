package _901__950._935;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(knightDialer(3131));
    }

    public int knightDialer(int n) {
        int[][] arr = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[n + 1][10];
        int mod = (int) 1e9 + 7;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 1) dp[i][j] = 1;
                else
                    for (int k : arr[j]) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
            }
        }
        return Arrays.stream(dp[n]).reduce(0, (x, y) -> (x + y) % mod);
    }

}