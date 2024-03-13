package _2851__2900._2875;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minSizeSubarray(new int[]{1, 6, 5, 5, 1, 1, 2, 5, 3, 1, 5, 3, 2, 4, 6, 6}, 56));
        System.out.println(minSizeSubarray(new int[]{1, 2, 3}, 5));
    }

    public int minSizeSubarray(int[] nums, int target) {
        int min = Integer.MAX_VALUE, sum = 0;
        int[] arr = new int[nums.length * 2], pre = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < nums.length) {
                sum += nums[i];
                arr[i] = nums[i];
            } else arr[i] = nums[i - nums.length];
        }
        int n = target / sum;
        target %= sum;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pre[i + 1] = pre[i] + arr[i];
            int k = pre[i + 1] - target;
            map.put(pre[i + 1], i);
            if (map.containsKey(k)) min = Math.min(min, i - map.get(k) + n * nums.length);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}