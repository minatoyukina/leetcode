package _2801__2850._2831;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestEqualSubarray(Arrays.asList(8, 1, 7, 8, 7, 3, 7, 9, 9, 7, 4, 5, 3, 5, 5, 6, 3, 3, 3, 6, 1, 3, 5, 6), 3));
        System.out.println(longestEqualSubarray(Arrays.asList(1, 3, 2, 3, 1, 3), 3));
        System.out.println(longestEqualSubarray(Arrays.asList(1, 1, 2, 2, 1, 1), 2));
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        int left = 0, right = 0, max = 0;
        boolean b = true;
        while (left < nums.size() && right < nums.size()) {
            Integer l = nums.get(left), r = nums.get(right);
            if (b) {
                map.merge(r, 1, Integer::sum);
                tree.merge(map.get(r), 1, Integer::sum);
                tree.compute(map.get(r) - 1, (a, y) -> y == null || y == 1 ? null : y - 1);
            }
            if (tree.lastKey() + k >= right - left + 1) {
                max = Math.max(max, tree.lastKey());
                right++;
                b = true;
            } else {
                tree.compute(map.get(l), (a, y) -> y == null || y == 1 ? null : y - 1);
                tree.merge(map.get(l) - 1, 1, Integer::sum);
                map.compute(l, (a, y) -> y == null || y == 1 ? null : y - 1);
                left++;
                b = false;
            }

        }
        return max;
    }

}