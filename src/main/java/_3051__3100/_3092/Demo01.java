package _3051__3100._3092;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(mostFrequentIDs(new int[]{2, 2, 5, 4, 2}, new int[]{4, 1, 3, 4, -2})));
        System.out.println(Arrays.toString(mostFrequentIDs(new int[]{5, 5, 3}, new int[]{2, -2, 1})));
        System.out.println(Arrays.toString(mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1})));
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        TreeMap<Long, Long> tree = new TreeMap<>();
        Map<Integer, Long> map = new HashMap<>();
        long[] ans = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Long cnt = map.getOrDefault(nums[i], 0L);
            map.put(nums[i], cnt + freq[i]);
            tree.put(cnt + freq[i], tree.getOrDefault(cnt + freq[i], 0L) + 1);
            if (tree.containsKey(cnt))
                if (tree.get(cnt).equals(1L)) tree.remove(cnt);
                else tree.put(cnt, tree.get(cnt) - 1);
            ans[i] = tree.lastKey();
        }
        return ans;
    }

}