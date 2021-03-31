package daily;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 *
 * 示例 1：
 *  1  3  5  7
 * 10 11 16 20
 * 23 30 34 60
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 *  1  3  5  7
 * 10 11 16 20
 * 23 30 34 60
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class DAY202103300074 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0;

        while (r < m && target > matrix[r][n - 1]) {
            r++;
        }

        if (r >= m) {
            return false;
        }

        int left = 0, right = n - 1, c;

        while (left <= right) {
            c = (left + right) / 2;
            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                right = c - 1;
            } else {
                left = c + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7}, {10,11,16,20} ,{23,30,34,60}};
        System.out.println(new DAY202103300074().searchMatrix(matrix, 13));
    }
}
