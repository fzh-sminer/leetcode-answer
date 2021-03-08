package daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class DAY202103070131 {
    public List<List<String>> partition(String s) {

        int n = s.length();
        List<List<String>> res = new ArrayList<>();

        if (n == 0) {
            return res;
        }

        boolean[][] dp = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        Deque<String> path = new ArrayDeque<>();
        dfs(s, 0,  n, dp, path, res);

        return res;
    }

    private void dfs(String s, int index, int n, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (index == n) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = index; i < n; i++) {
                if (dp[index][i]) {
                    path.addLast(s.substring(index, i + 1));
                    dfs(s, i + 1, n, dp, path, res);
                    path.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new DAY202103070131().partition("aab"));
    }
}
