package _2801__2850._2840;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {


    @Test
    public void test() {
        System.out.println(checkStrings("abcdba", "cabdab"));
    }

    public boolean checkStrings(String s1, String s2) {
        List<Character> a1 = new ArrayList<>(), a2 = new ArrayList<>(), b1 = new ArrayList<>(), b2 = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) a1.add(s1.charAt(i));
            else a2.add(s1.charAt(i));
            if (i % 2 == 0) b1.add(s2.charAt(i));
            else b2.add(s2.charAt(i));
        }
        Arrays.asList(a1, a2, b1, b2).forEach(s -> s.sort(Character::compareTo));
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            a.append(i % 2 == 0 ? a1.get(i / 2) : a2.get(i / 2));
            b.append(i % 2 == 0 ? b1.get(i / 2) : b2.get(i / 2));
        }
        return a.toString().equals(b.toString());

    }

}