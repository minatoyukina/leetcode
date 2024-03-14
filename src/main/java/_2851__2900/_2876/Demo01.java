package _2851__2900._2876;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(Arrays.toString(countVisitedNodes(Arrays.asList(1, 2, 3, 3))));
    }

    public int[] countVisitedNodes(List<Integer> edges) {
        int[] ans = new int[edges.size()];
        for (int i = 0; i < edges.size(); i++) if (!globalVisited.contains(i)) point(edges, i, new HashSet<>());
        for (Integer x : circlePoint) {
            Set<Integer> circle = new HashSet<>();
            circle(edges, x, circle);
            for (Integer y : circle) ans[y] = circle.size();
        }
        Set<Integer> filter = new HashSet<>(edges);
        IntStream.range(0, edges.size()).filter(x -> !filter.contains(x)).forEach(i -> dp(ans, edges, i));
        return ans;

    }

    private int dp(int[] ans, List<Integer> edges, int idx) {
        if (ans[idx] > 0) return ans[idx];
        return ans[idx] = 1 + dp(ans, edges, edges.get(idx));
    }


    Set<Integer> circlePoint = new HashSet<>();
    Set<Integer> globalVisited = new HashSet<>();

    private void point(List<Integer> edges, int idx, Set<Integer> visited) {
        if (!visited.add(idx)) circlePoint.add(idx);
        else if (globalVisited.add(idx)) point(edges, edges.get(idx), visited);
    }

    private void circle(List<Integer> edges, int idx, Set<Integer> visited) {
        if (visited.add(idx)) circle(edges, edges.get(idx), visited);
    }

}