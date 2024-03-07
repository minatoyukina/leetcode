package _1501__1550._1525;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numSplits("aaaaa"));
    }

    public int numSplits(String s) {
        Map<Character, Integer> left = new HashMap<>(), right = new HashMap<>();
        for (int i = 0; i < s.length(); i++) right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) + 1);
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            left.put(c, left.getOrDefault(c, 0) + 1);
            int x = right.get(c);
            if (x == 0) right.remove(c);
            else right.put(c, x - 1);
            if (left.size() == right.size()) cnt++;
        }
        return cnt;
    }

}