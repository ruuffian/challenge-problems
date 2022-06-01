package challenges.leetcode;

public class RomanToInt {
    public static void main() {
        System.out.println(new RomanToInt().romanToInt("III"));
        System.out.println(new RomanToInt().romanToInt("IV"));
        System.out.println(new RomanToInt().romanToInt("IVCD"));
    }

    public int romanToInt(String s) {
        int sum = 0;
        int prev = 1001;
        for (int i = 0; i < s.length(); i++) {
            int cur = val(s.charAt(i));
            sum += cur;
            if (cur > prev) {
                sum -= 2 * prev;
            }
            prev = cur;
        }
        return sum;
    }

    public static int val(char numeral) {
        int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};
        char[] numerals = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int i = 0;
        while (numeral != numerals[i]) {
            i++;
        }
        return values[i];
    }
}
