package _3201__3250._3208;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6));
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int cnt = 0;
        int[] arr = new int[colors.length + k - 1];
        for (int i = 0; i < arr.length; i++) arr[i] = i < colors.length ? colors[i] : colors[i - colors.length];
        int left = 0, right = 0;
        while (right < arr.length) {
            if (right == arr.length - 1 || (right + 1 < arr.length && arr[right] == arr[right + 1])) {
                if (right - left + 1 >= k) cnt += right - left + 2 - k;
                left = right + 1;
            }
            right++;
        }
        return cnt;
    }

}