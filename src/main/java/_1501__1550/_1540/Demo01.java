package _1501__1550._1540;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(canConvertString("input", "ouput", 9));
        System.out.println(canConvertString("abc", "bcd", 10));
    }

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            int d = b >= a ? (b - a) : (26 + b - a);
            if (d != 0) map.put(d, map.getOrDefault(d, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getKey() + (entry.getValue() - 1) * 26);
        }
        return k >= max;
    }

}