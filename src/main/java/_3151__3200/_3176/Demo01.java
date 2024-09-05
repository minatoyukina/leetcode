package _3151__3200._3176;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximumLength(new int[]{29, 30, 30}, 0));
        System.out.println(maximumLength(new int[]{1, 2, 1, 1, 3}, 2));
        System.out.println(maximumLength(new int[]{1, 2, 3, 4, 5, 1}, 0));
    }

    public int maximumLength(int[] nums, int k) {
        dp = new int[nums.length][nums.length][k + 1];
        for (int[][] ints : dp) for (int[] anInt : ints) Arrays.fill(anInt, -1);
        return dfs(nums, k, 0, -1, 0);
    }

    int[][][] dp;

    private int dfs(int[] nums, int k, int pos, int last, int cnt) {
        if (pos >= nums.length || cnt > k) return 0;
        if (last == -1) return Math.max(dfs(nums, k, pos + 1, -1, 0), 1 + dfs(nums, k, pos + 1, pos, 0));
        if (dp[pos][last][cnt] >= 0) return dp[pos][last][cnt];
        if (cnt == k) return dp[pos][last][cnt] = (nums[last] == nums[pos] ? 1 : 0) + dfs(nums, k, pos + 1, last, cnt);
        return dp[pos][last][cnt] = Math.max(dfs(nums, k, pos + 1, last, cnt), 1 + dfs(nums, k, pos + 1, pos, nums[last] == nums[pos] ? cnt : (cnt + 1)));
    }

}