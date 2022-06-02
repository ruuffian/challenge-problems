package challenges.leetcode;

import java.util.Arrays;

public class TransposeMatrix867 {
    public static void main() {
        System.out.println(Arrays.deepToString(new TransposeMatrix867().transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public int[][] transpose(int[][] matrix) {
        int[][] solution = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                solution[i][j] = matrix[j][i];
            }
        }
        return solution;
    }
}
