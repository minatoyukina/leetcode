package _1501__1550._1524;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numOfSubarrays(new int[]{7}));
        System.out.println(numOfSubarrays(new int[]{100, 100, 99, 99}));
    }

    public int numOfSubarrays(int[] arr) {
        int dp = 0, po = 0, pe = 0, mod = (int) 1e9 + 7;
        for (int i : arr) {
            if (i % 2 == 0) {
                dp += po;
                pe++;
            } else {
                dp += pe + 1;
                int t = pe;
                pe = po;
                po = t + 1;
            }
            dp %= mod;
        }
        return dp;
    }

}