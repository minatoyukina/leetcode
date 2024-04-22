package _1601__1650._1616;

import org.junit.Test;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkPalindromeFormation(
                "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd",
                "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
        System.out.println(checkPalindromeFormation("s", "t"));
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public boolean check(String a, String b) {
        int left = 0, right = a.length() - 1;
        while (left < right) {
            if (a.charAt(left) == b.charAt(right)) {
                left++;
                right--;
            } else {
                String s = a.substring(0, left) + b.substring(left);
                String t = a.substring(0, right + 1) + b.substring(right + 1);
                return new StringBuilder(s).reverse().toString().equals(s) || new StringBuilder(t).reverse().toString().equals(t);
            }
        }
        return true;
    }

}