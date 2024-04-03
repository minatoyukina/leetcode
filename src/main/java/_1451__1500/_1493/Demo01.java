package _1451__1500._1493;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestSubarray(new int[]{1, 0, 0, 0}));
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
    }

    public int longestSubarray(int[] nums) {
        int max = 0, preLen = 0, preIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            int idx = i;
            while (idx < nums.length && nums[idx] == 1) idx++;
            if (nums[i] == 1) {
                if (preIdx == i - 2) max = Math.max(max, preLen + idx - i);
                preIdx = idx - 1;
                preLen = idx - i;
                max = Math.max(idx - i, max);
                i = idx - 1;
            }
        }
        return max == nums.length ? (max - 1) : max;
    }

}