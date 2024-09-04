package _2901__2950._2915;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(lengthOfLongestSubsequence(Arrays.asList(4, 1, 3, 2, 1, 5), 7));
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (num > target) continue;
            Map<Integer, Integer> copy = new HashMap<>(map);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() + num > target) continue;
                copy.put(entry.getKey() + num, Math.max(map.getOrDefault(entry.getKey() + num, 0), map.get(entry.getKey()) + 1));
            }
            copy.put(num, Math.max(map.getOrDefault(num, 0), 1));
            map = copy;
        }
        return map.getOrDefault(target, -1);
    }

}