package _3101__3150._3133;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minEnd(1, 4));
        System.out.println(minEnd(3, 4));
    }

    public long minEnd(int n, int x) {
        int zeroCnt = Integer.toBinaryString(x).length() - Integer.bitCount(x);
        int pre = (n - 1) / (1 << zeroCnt), mod = (n - 1) % (1 << zeroCnt);
        return Long.valueOf(Long.toBinaryString(pre) + replaceZeroes(mod, x, zeroCnt), 2);
    }

    public String replaceZeroes(int a, int b, int zeroCnt) {
        String x = Integer.toBinaryString(a);
        int idx = 0;
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(b));
        if (x.length() < zeroCnt) {
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < zeroCnt - x.length(); i++) t.append("0");
            x = t.append(x).toString();
        }
        for (int i = 0; i < sb.length(); i++) if (sb.charAt(i) == '0') sb.setCharAt(i, x.charAt(idx++));
        return sb.toString();
    }

}