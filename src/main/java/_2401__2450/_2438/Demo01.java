package _2401__2450._2438;

import org.junit.Test;
import util.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(productQueries(15, Common.strToArray("[[0,1],[2,2],[0,3]]"))));
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 32; i++) if ((n >> i & 1) == 1) list.add(i);
        int[] pre = new int[list.size() + 1];
        for (int i = 0; i < list.size(); i++) pre[i + 1] = pre[i] + list.get(i);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            ans[i] = (int) (Math.pow(2, pre[queries[i][1] + 1] - pre[queries[i][0]]) % ((int) 1e9 + 7));
        return ans;
    }

}