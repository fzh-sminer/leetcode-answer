package base;

import java.util.function.ToIntFunction;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class BASE0010 {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int c = 1; c < dp[0].length; c++) {
            char ch = p.charAt(c - 1);
            if (c == 1) {
                if (ch == '*') {
                    dp[0][c] = true;
                }
            } else {
                if (ch == '*') {
                    dp[0][c] = dp[0][c - 2];
                } else {
                    dp[0][c] = false;
                }
            }
        }

        for (int r = 1; r < dp.length; r++) {
            char sc = s.charAt(r - 1);
            for (int c = 1; c < dp[r].length; c++) {
                char pc = p.charAt(c - 1);

                if (sc == pc || pc == '.') {
                    dp[r][c] = dp[r - 1][c - 1];
                } else if (pc == '*') {
                    if (c > 1) {
                        if (dp[r][c - 2]) {
                            dp[r][c] = true;
                        } else {
                            char prev = p.charAt(c - 2);
                            if (prev == sc || prev == '.') {
                                dp[r][c] = dp[r - 1][c];
                            }
                        }
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

}
