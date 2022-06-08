package challenges.leetcode;

public class PowerOfTwo231 {
    public static void main() {
        System.out.println(new PowerOfTwo231().isPowerOfTwo(14));
    }

    public boolean fastSolution(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
