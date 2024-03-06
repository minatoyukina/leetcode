package _1551__1600._1562;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(findLatestStep(new int[]{1, 2}, 1));
        System.out.println(findLatestStep(new int[]{3, 1, 5, 4, 2}, 2));
    }

    public int findLatestStep(int[] arr, int m) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            Map.Entry<Integer, Integer> lower = tree.lowerEntry(value), higher = tree.higherEntry(value);
            if (lower != null && lower.getValue() == value - 1) {
                if (higher != null && higher.getKey() == value + 1) {
                    tree.put(lower.getKey(), higher.getValue());
                    tree.remove(higher.getKey());
                    fix(map, lower.getKey(), lower.getValue(), false);
                    fix(map, higher.getKey(), higher.getValue(), false);
                    fix(map, lower.getKey(), higher.getValue(), true);
                } else {
                    tree.put(lower.getKey(), value);
                    fix(map, lower.getKey(), lower.getValue(), false);
                    fix(map, lower.getKey(), value, true);
                }
            } else {
                if (higher != null && higher.getKey() == value + 1) {
                    tree.put(value, higher.getValue());
                    fix(map, value, higher.getValue(), true);
                    tree.remove(higher.getKey());
                    fix(map, higher.getKey(), higher.getValue(), false);
                } else {
                    tree.put(value, value);
                    map.put(1, map.getOrDefault(1, 0) + 1);
                }
            }
            if (map.getOrDefault(m, 0) > 0) ans = i + 1;
        }
        return ans;
    }

    private void fix(Map<Integer, Integer> map, int left, int right, boolean isAdd) {
        int d = right - left + 1;
        map.put(d, map.getOrDefault(d, 0) + (isAdd ? 1 : -1));
    }

}