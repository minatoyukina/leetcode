package _1751__1800._1786;

import org.junit.Test;
import util.Common;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countRestrictedPaths(5, Common.strToArray("[[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]")));
        System.out.println(countRestrictedPaths(7, Common.strToArray("[[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3],[2,6,4]]")));
    }

    @SuppressWarnings("unchecked")
    public int countRestrictedPaths(int n, int[][] edges) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        int[] dj = new int[n + 1];
        Arrays.fill(dj, Integer.MAX_VALUE);
        dj[n] = 0;
        queue.offer(new int[]{n, 0});
        List<int[]>[] list = new List[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for (int[] edge : edges) {
            list[edge[0]].add(new int[]{edge[1], edge[2]});
            list[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[1] > dj[poll[0]]) continue;
            for (int[] ints : list[poll[0]]) {
                if (ints[1] + poll[1] < dj[ints[0]]) {
                    dj[ints[0]] = ints[1] + poll[1];
                    queue.offer(new int[]{ints[0], ints[1] + poll[1]});
                }
            }
        }
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(list, 1, n, dj);
    }

    private int[] dp;

    private int dfs(List<int[]>[] list, int pos, int dest, int[] dj) {
        if (dp[pos] >= 0) return dp[pos];
        if (pos == dest) return 1;
        int cnt = 0;
        for (int[] ints : list[pos]) {
            if (dj[pos] > dj[ints[0]]) cnt += dfs(list, ints[0], dest, dj);
            cnt %= (int) 1e9 + 7;
        }
        return dp[pos] = cnt;
    }

}