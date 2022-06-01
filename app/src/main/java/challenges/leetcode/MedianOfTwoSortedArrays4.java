package challenges.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays4 {
    public static void main() {
        System.out.println(new MedianOfTwoSortedArrays4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sorted = new int[nums1.length + nums2.length];
        int i = 0, j = 0, index = 0;
        while (index < sorted.length) {
            if ((j >= nums2.length) || (i < nums1.length && nums1[i] <= nums2[j])) {
                sorted[index] = nums1[i];
                i++;
            } else {
                sorted[index] = nums2[j];
                j++;
            }
            index++;
        }
        if (sorted.length % 2 != 0) {
            return sorted[sorted.length / 2];
        }
        return (sorted[(sorted.length / 2) - 1] + sorted[sorted.length / 2]) / 2.0;
    }
}
