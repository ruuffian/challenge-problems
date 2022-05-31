package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indeces = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indeces = new int[]{i, hash.get(nums[i])};
            } else {
                hash.put(target - nums[i], i);
            }
        }
        return indeces;
    }
}
