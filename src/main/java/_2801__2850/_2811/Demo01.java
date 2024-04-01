package _2801__2850._2811;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canSplitArray(Arrays.asList(2, 3, 3, 2, 3), 6));
    }

    public boolean canSplitArray(List<Integer> nums, int m) {
        for (int i = 0; i < nums.size() - 1; i++) if (nums.get(i) + nums.get(i + 1) >= m) return true;
        return nums.size() <= 2;
    }

}