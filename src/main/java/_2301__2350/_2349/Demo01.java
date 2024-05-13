package _2301__2350._2349;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Demo01 {


    @Test
    public void test() {
        NumberContainers nc = new NumberContainers();
        nc.find(10); // 没有数字 10 ，所以返回 -1 。
        nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
        nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
        nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
        nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
        System.out.println(nc.find(10));
        nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
        nc.find(10); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。

    }

    static class NumberContainers {

        Map<Integer, TreeSet<Integer>> tree = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        public NumberContainers() {

        }

        public void change(int index, int number) {
            if (map.containsKey(index)) tree.get(map.get(index)).remove(index);
            tree.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
            map.put(index, number);
        }

        public int find(int number) {
            if (tree.containsKey(number) && !tree.get(number).isEmpty()) return tree.get(number).first();
            return -1;
        }
    }

}