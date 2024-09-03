package _3151__3200._3160;

import org.junit.Test;
import util.Common;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(queryResults(1, Common.strToArray("[[0,1],[0,4],[0,4],[0,1],[1,2]]"))));
    }

    @SuppressWarnings("unused")
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> cMap = new HashMap<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] arr = queries[i];
            Integer preColor = cMap.get(arr[0]);
            if (preColor != null && preColor != arr[1]) {
                map.get(preColor).remove(arr[0]);
                if (map.get(preColor).isEmpty()) map.remove(preColor);

            }
            cMap.put(arr[0], arr[1]);
            map.computeIfAbsent(arr[1], k -> new HashSet<>()).add(arr[0]);
            ans[i] = map.size();
        }
        return ans;
    }

}