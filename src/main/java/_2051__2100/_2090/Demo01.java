package _2051__2100._2090;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));
    }

    public int[] getAverages(int[] nums, int k) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= 2 * k + 1) sum -= nums[i - 2 * k - 1];
            if (i >= 2 * k) arr[i - k] = (int) (sum / (2 * k + 1));
        }
        return arr;
    }

}