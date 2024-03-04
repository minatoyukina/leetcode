package _1801__1850._1829;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 1, 3}, 2)));
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] ans = new int[nums.length];
        int suf = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            suf ^= nums[nums.length - 1 - i];
            int sum = 0;
            for (int j = 0; j < maximumBit; j++) sum += ((suf >> j & 1) ^ 1) << j;
            ans[i] = sum;
        }
        return ans;
    }

}