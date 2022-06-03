package challenges.leetcode;

import java.util.Arrays;

public class RangeSumQuery2D {
    public static void main() {
        System.out.println(new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        }).sumRegion(2, 1, 4, 3));
    }

    static class NumMatrix {
        private int[][] cache;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            cache = new int[matrix.length][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    cache[i][j + 1] = cache[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int area = 0;
            for (int i = row1; i <= row2; i++) {
                area += cache[i][col2 + 1] - cache[i][col1];
            }
            return area;
        }
    }
}
