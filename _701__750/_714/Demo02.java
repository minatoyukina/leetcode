package leetcode._701__750._714;

import org.junit.Test;

public class Demo02 {


    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 1));
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    private int maxProfit(int[] prices, int fee) {
        // 0持币观望 1等待抛售
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }


}