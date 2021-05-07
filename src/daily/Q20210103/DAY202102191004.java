package daily.Q20210103;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 */
public class DAY202102191004 {

    public int longestOnes(int[] A, int K) {

        return second(A, K);
    }

    public int first(int[] A, int K) {

        int left = 0, right = 0, res = 0, zc = 0;

        while (right < A.length) {

            if (A[right] == 0) {
                zc++;
            }

            while (zc > K) {
                if (A[left++] == 0) {
                    zc--;
                }
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

    public int second(int[] A, int K) {

        int left = 0, right = 0, ls = 0, rs = 0, res = 0;

        for (; right < A.length; right++) {
            rs += 1 - A[right];

            while (ls < rs - K) {
                ls += 1 - A[left];
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] A = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;
        System.out.println(new DAY202102191004().longestOnes(A, K));
    }
}
