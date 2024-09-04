package _2551__2600._2588;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(beautifulSubarrays(new int[]{1, 10, 4}));
        System.out.println(beautifulSubarrays(new int[]{4, 3, 1, 2, 4}));
    }

    public long beautifulSubarrays(int[] nums) {
        int[] pre = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) pre[i + 1] += ((nums[i] >> j & 1) ^ (pre[i] >> j & 1)) << j;
            cnt += map.getOrDefault(pre[i + 1], 0);
            map.put(pre[i + 1], map.getOrDefault(pre[i + 1], 0) + 1);
        }
        return cnt;
    }

}