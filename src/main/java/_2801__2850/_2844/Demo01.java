package _2801__2850._2844;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumOperations("10"));
        System.out.println(minimumOperations("2245047"));
    }

    public int minimumOperations(String num) {
        boolean z = false, f = false;
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (((c == '0' || c == '5') && z) || ((c == '2' || c == '7') && f)) return num.length() - i - 2;
            if (!z) z = c == '0';
            if (!f) f = c == '5';
        }
        return num.length() - (z ? 1 : 0);
    }

}