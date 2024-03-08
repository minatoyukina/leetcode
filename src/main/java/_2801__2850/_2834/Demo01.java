package _2801__2850._2834;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumPossibleSum(1000000000, 1000000000));
        System.out.println(minimumPossibleSum(37, 46));
    }

    public int minimumPossibleSum(int n, int target) {
        int mod = (int) 1e9 + 7, d = target / 2;
        long sum = 0;
        if (d >= n) d = n;
        sum += (1L + d) * d / 2;
        sum += (target * 2L + n - d - 1) * (n - d) / 2;
        return (int) (sum % mod);
    }
}