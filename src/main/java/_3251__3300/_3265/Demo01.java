package _3251__3300._3265;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(countPairs(new int[]{8, 12, 5, 5, 14, 3, 12, 3, 3, 6, 8, 20, 14, 3, 8}));
    }

    public int countPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (swap(nums[i]).contains(nums[j]) || swap(nums[j]).contains(nums[i])) cnt++;
        return cnt;
    }

    private Set<Integer> swap(int num) {
        StringBuilder s = new StringBuilder(String.valueOf(num));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                StringBuilder ss = new StringBuilder(s.toString());
                ss.replace(i, i + 1, s.charAt(j) + "");
                ss.replace(j, j + 1, s.charAt(i) + "");
                set.add(Integer.parseInt(ss.toString()));
            }
        }
        return set;
    }

}