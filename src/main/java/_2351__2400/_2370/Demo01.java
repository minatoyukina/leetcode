package _2351__2400._2370;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestIdealString("lkpkxcigcs", 6));
    }

    public int longestIdealString(String s, int k) {
        int[] dp = new int[s.length()], memo = new int[26];
        int max = 0;
        Arrays.fill(memo, -1);
        Arrays.fill(dp, 1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a', left = Math.max(0, c - k), right = Math.min(25, c + k);
            for (int j = left; j <= right; j++) if (memo[j] >= 0) dp[i] = Math.max(dp[i], dp[memo[j]] + 1);
            memo[c] = i;
            max = Math.max(dp[i], max);
        }
        return max;
    }

}