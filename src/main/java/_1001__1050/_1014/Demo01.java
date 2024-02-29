package _1001__1050._1014;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    private int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                max = Math.max(max, values[i] + values[j] + i - j);
            }
        }
        return max;
    }

}