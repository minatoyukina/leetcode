package _2901__2950._2939;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(maximumXorProduct(570713374625622L, 553376364476768L, 35));
        System.out.println(maximumXorProduct(6, 7, 5));
    }

    public int maximumXorProduct(long a, long b, int n) {
        long mod = (long) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            long x = a >> i & 1, y = b >> i & 1, offset = 1L << i;
            if (x == 0 && y == 0) {
                a += offset;
                b += offset;
            } else if (x != y) {
                if (a > b && x == 1 && a - b > offset) {
                    a -= offset;
                    b += offset;
                } else if (b > a && y == 1 && b - a > offset) {
                    a += offset;
                    b -= offset;
                }
            }
        }
        return (int) ((a % mod) * (b % mod) % mod);
    }

}