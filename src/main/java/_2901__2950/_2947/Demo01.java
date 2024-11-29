package _2901__2950._2947;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(beautifulSubstrings("baeyh", 2));
    }

    public int beautifulSubstrings(String s, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.computeIfAbsent(0, x -> new HashSet<>()).add(-1);
        int a = 0, b = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".contains(s.charAt(i) + "")) a++;
            else b++;
            Set<Integer> set = map.getOrDefault(a - b, Collections.emptySet());
            for (Integer x : set) if (Math.pow((i - x) / 2.0, 2) % k == 0) ans++;
            map.computeIfAbsent(a - b, kk -> new HashSet<>()).add(i);
        }
        return ans;
    }

}