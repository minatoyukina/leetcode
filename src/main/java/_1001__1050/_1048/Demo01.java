package _1001__1050._1048;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }

    public int longestStrChain(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<>();
        int min = 16, max = 0;
        for (String word : words) {
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
            map.computeIfAbsent(word.length(), k -> new HashSet<>()).add(word);
        }
        Map<String, Integer> last = new ConcurrentHashMap<>();
        for (int i = min; i <= max; i++) {
            for (String s : map.getOrDefault(i, Collections.emptySet())) {
                for (Map.Entry<String, Integer> entry : last.entrySet()) {
                    if (check(s, entry.getKey())) {
                        last.put(s, Math.max(last.getOrDefault(s, 0), entry.getValue() + 1));
                    }
                }
                if (!last.containsKey(s)) last.put(s, 1);
            }
        }
        return last.values().stream().max(Integer::compareTo).orElse(0);
    }

    private boolean check(String longer, String shorter) {
        if (longer.length() != shorter.length() + 1) return false;
        int l = 0, r = 0;
        while (l < longer.length() && r < shorter.length()) {
            if (longer.charAt(l) == shorter.charAt(r)) r++;
            l++;
        }
        return r >= shorter.length();
    }

}