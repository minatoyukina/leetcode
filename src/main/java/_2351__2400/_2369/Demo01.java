package _2351__2400._2369;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(validPartition(new int[]{993335, 993336, 993337, 993338, 993339, 993340, 993341}));
    }

    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[1] = nums[0] == nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && dp[i - 2]) dp[i] = true;
            else if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] && (i == 2 || dp[i - 3])) dp[i] = true;
            else if (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2 && (i == 2 || dp[i - 3])) dp[i] = true;
        }
        return dp[nums.length - 1];
    }

}