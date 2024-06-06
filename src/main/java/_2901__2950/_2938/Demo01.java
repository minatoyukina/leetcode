package _2901__2950._2938;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumSteps("111111111100100010"));
    }

    public long minimumSteps(String s) {
        int left = 0, right = s.length() - 1;
        long ans = 0;
        while (left < right) {
            if (s.charAt(left) == '1' && s.charAt(right) == '0') ans += right-- - left++;
            if (s.charAt(left) == '0') left++;
            if (s.charAt(right) == '1') right--;
        }
        return ans;
    }

}