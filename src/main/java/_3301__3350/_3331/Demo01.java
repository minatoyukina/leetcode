package _3301__3350._3331;

import org.junit.Test;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(findSubtreeSizes(new int[]{-1, 0, 14, 15, 9, 2, 15, 4, 9, 0, 15, 5, 18, 7, 0, 2, 4, 10, 3}, "cebcebaacacebbcedda")));
        System.out.println(Arrays.toString(findSubtreeSizes(new int[]{-1, 17, 1, 9, 9, 11, 4, 17, 7, 0, 9, 9, 1, 4, 3, 6, 15, 10}, "eecceecdcdeebbabbe")));
        System.out.println(Arrays.toString(findSubtreeSizes(new int[]{-1, 12, 10, 2, 3, 3, 2, 5, 6, 10, 0, 6, 2}, "dccdbececbccb")));
        System.out.println(Arrays.toString(findSubtreeSizes(new int[]{-1, 0, 4, 0, 1}, "abbba")));
        System.out.println(Arrays.toString(findSubtreeSizes(new int[]{-1, 10, 0, 12, 10, 18, 11, 12, 2, 3, 2, 2, 2, 0, 4, 11, 4, 2, 0}, "babadabbdabcbaceeda")));
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) map.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
        int[] ans = new int[parent.length];
        dfs(map, s, 0, new HashMap<>(), ans);
        return ans;
    }


    private void dfs(Map<Integer, List<Integer>> map, String s, int pos, Map<Character, Integer> hiSet, int[] ans) {
        List<Integer> list = map.getOrDefault(pos, Collections.emptyList());
        Map<Character, Integer> loSet = new HashMap<>();
        loSet.put(s.charAt(pos), 1);
        ans[pos] = cnt(pos, map, s, hiSet, loSet, false);
        hiSet.merge(s.charAt(pos), 1, Integer::sum);
        for (Integer i : list) {
            dfs(map, s, i, hiSet, ans);
        }
        hiSet.computeIfPresent(s.charAt(pos), (k, v) -> v == 1 ? null : v - 1);
    }

    private int cnt(int pos, Map<Integer, List<Integer>> map, String s, Map<Character, Integer> hiSet, Map<Character, Integer> loSet, boolean upper) {
        int cnt = !loSet.containsKey(s.charAt(pos)) && (hiSet.containsKey(s.charAt(pos)) || upper) ? 0 : 1;
        List<Integer> list = map.getOrDefault(pos, Collections.emptyList());
        upper = upper || !loSet.containsKey(s.charAt(pos)) && hiSet.containsKey(s.charAt(pos));
        if (loSet.containsKey(s.charAt(pos))) upper = false;
        if (upper) hiSet.merge(s.charAt(pos), 1, Integer::sum);
        else loSet.merge(s.charAt(pos), 1, Integer::sum);
        for (Integer i : list) {
            cnt += cnt(i, map, s, hiSet, loSet, upper);

        }
        if (!upper) loSet.computeIfPresent(s.charAt(pos), (k, v) -> v == 1 ? null : v - 1);
        else hiSet.computeIfPresent(s.charAt(pos), (k, v) -> v == 1 ? null : v - 1);
        return cnt;
    }
}
