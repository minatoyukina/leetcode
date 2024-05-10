package _2951__3000._2962;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        System.out.println(countSubarrays(new int[]{28, 5, 58, 91, 24, 91, 53, 9, 48, 85, 16, 70, 91, 91, 47, 91, 61, 4, 54, 61, 49}, 1));
    }

    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int left = 0, right = 0, n = nums.length, max = Arrays.stream(nums).max().orElse(0), cnt = 0;
        while (left < n) {
            if (cnt >= k) {
                ans += n - right + 1;
                cnt -= nums[left++] == max ? 1 : 0;
            } else if (right < n) cnt += nums[right++] == max ? 1 : 0;
            else break;
        }
        return ans;
    }

}