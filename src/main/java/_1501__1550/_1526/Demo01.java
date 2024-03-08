package _1501__1550._1526;

import org.junit.Test;

import java.util.Stack;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minNumberOperations(new int[]{3, 1, 5, 4, 2}));
        System.out.println(minNumberOperations(new int[]{1, 2, 3, 2, 1}));
    }

    public int minNumberOperations(int[] target) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : target) {
            if (!stack.isEmpty() && stack.peek() > i) sum += stack.pop() - i;
            stack.push(i);
        }
        if (!stack.isEmpty()) sum += stack.pop();
        return sum;
    }

}