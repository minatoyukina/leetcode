package _3101__3150._3112;

import org.junit.Test;
import util.Common;

import java.util.*;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(minimumTime(3, Common.strToArray("[[0,1,2],[1,2,1],[0,2,4]]"), new int[]{1, 1, 5})));
    }

    @SuppressWarnings("unchecked")
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] newEdges = new List[n];
        for (int i = 0; i < n; i++) {
            newEdges[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            newEdges[edge[0]].add(new int[]{edge[1], edge[2], disappear[edge[1]]});
            newEdges[edge[1]].add(new int[]{edge[0], edge[2], disappear[edge[0]]});
        }
        int[] dj = new int[n];
        Arrays.fill(dj, -1);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (dj[poll[0]] == -1) dj[poll[0]] = poll[1];
            else continue;
            List<int[]> list = newEdges[poll[0]];
            for (int[] ints : list) {
                if (poll[1] + ints[1] < ints[2]) queue.offer(new int[]{ints[0], poll[1] + ints[1]});
            }
        }
        return dj;
    }

}