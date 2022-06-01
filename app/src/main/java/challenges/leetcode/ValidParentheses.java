package challenges.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses {
    public static void main() {
        System.out.println(isValid("(({({})}))"));
        System.out.println(isValid("("));
        System.out.println(isValid(")"));
        System.out.println(isValid("(}"));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 40 || s.charAt(i) == 91 || s.charAt(i) == 123) {
                stack.push(s.charAt(i));
            } else {
                    if (!stack.isEmpty() && ((stack.peek() == 40 && s.charAt(i) == 41) || (stack.peek() == 91 && s.charAt(i) == 93) || (stack.peek() == 123 && s.charAt(i) == 125)))
                        stack.pop();
                    else
                        return false;
                }
            }

        return stack.isEmpty();
    }
}
