package challenges.leetcode;

/*
Problem Description::
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */

import java.util.*;

public class ThreeSum {
    public static void main() {
        System.out.println(new ThreeSum().algorithmHashMapImplementation(new int[]{1, 2, -2, -1}).toString());
    }

    public List<List<Integer>> algorithmHashMapImplementation(int[] nums) {
        /* discard arrays with < 3 elements */
        if (nums.length < 3) {
            return new ArrayList<>(new ArrayList<>());
        }
        /* sort in n*log(n) time to force duplicate solutions to be lists in identical order */
        Arrays.sort(nums);
        /* initialize as a Set of Lists to reject duplicate lists */
        Set<List<Integer>> solutions = new HashSet<>();
        /* fix our target, then apply the 2Sum hashmap method to solve the equation 0 = target + a + b */
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int target = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    solutions.add(new ArrayList<>(List.of(target, nums[j], nums[map.get(nums[j])])));
                } else {
                    map.put(-1 * target - nums[j], j);
                }
            }
        }
        return solutions.stream().toList();
    }

    public ArrayList<ArrayList<Integer>> algorithmBruteForce(int[] ray) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();

        for (int i = 0; i < ray.length; i++) {
            for (int j = 0; j < ray.length; j++) {
                for (int k = 0; k < ray.length; k++) {
                    if (i != j && i != k && j != k) {
                        if (ray[i] + ray[j] + ray[k] == 0) {
                            solutions.add(new ArrayList<>(List.of(ray[i], ray[j], ray[k])));
                        }
                    }
                }
            }
        }
        return solutions;
    }
}