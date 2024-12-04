package _3001__3050._3016;

import org.junit.Test;

import java.util.Arrays;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
        System.out.println(minimumPushes("xyzxyzxyzxyz"));
        System.out.println(minimumPushes("abcde"));
    }

    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) arr[word.charAt(i) - 'a']++;
        Arrays.sort(arr);
        int cnt = 0, ans = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) break;
            ans += (((++cnt - 1) / 8) + 1) * arr[i];
        }
        return ans;
    }

}