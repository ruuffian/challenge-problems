package challenges.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class LongestPalindromicSubstring5 {
    public static void main() {
        System.out.println(new LongestPalindromicSubstring5().radiiMethod("ashjaskdbakshdjhbhjsdjasd"));
    }

    public String radiiMethod(String s) {
        /* put '|' between each letter of s- "bbg" -> "|b|b|g|" */
        String[] target = Arrays.stream(s.split(""))
                .reduce("", (a, b) -> a + "|" + b)
                .concat("|").split("");

        /* Array to store each maximum radii */
        int numElements = target.length;
        int[] radii = new int[numElements];

        /* Find the largest palindrome at each position in the string */
        int center = 0;
        while (center < numElements) {
            int radius = 0;
            while (((center - (radius + 1) >= 0) && (center + radius + 1 < numElements))
                    && (target[center - (radius + 1)].equals(target[center + radius + 1]))) {
                radius++;
            }
            radii[center] = radius;
            center++;
        }

        /* Retrieve max radius and the index of its center */
        final int max = Arrays.stream(radii)
                .max().getAsInt();

        center = (int) Arrays.stream(radii)
                .sequential()
                .takeWhile(i -> i != max).count();

        return Arrays.stream(target, center - max, center + max + 1)
                .filter(c -> !c.equals("|"))
                .collect(Collectors.joining());
    }

    public String bruteForceSolution(String s) {
        if (s.length() == 1)
            return s;
        int max = 0;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String substring;
            for (int j = max; j < s.length() - i; j++) {
                substring = s.substring(i, i + j + 1);
                if (isPalindrome(substring)) {
                    if (substring.length() > max) {
                        max = substring.length();
                        map.put(max, substring);
                    }
                }
            }
        }
        return map.get(max);
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
