package daily;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 */
public class DAY202103160059 {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int num = 1, left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column >= left; column--) {
                    matrix[bottom][column] = num++;
                }
                for (int row = bottom - 1; row > top; row--) {
                    matrix[row][left] = num++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return matrix;
    }


    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            System.out.println(Arrays.deepToString(new DAY202103160059().generateMatrix(i)));
        }
    }
}
