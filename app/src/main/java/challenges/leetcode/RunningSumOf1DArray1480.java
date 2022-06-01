package challenges.leetcode;

import java.util.Arrays;

public class RunningSumOf1DArray1480 {
    public static void main() {
        System.out.println(Arrays.toString(new RunningSumOf1DArray1480().runningSum(new int[]{1, 2, 3, 4})));
    }

    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return sum;
    }
}
