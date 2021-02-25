package base;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class BASE0005 {

    public String longestPalindrome(String s) {
        return second(s);
    }


    // 中心扩散法
    public String first(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int begin = 0, maxLen = 0, currentMaxLen;
        for (int i = 0; i < s.length() - 1; i++) {
            currentMaxLen = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i , i + 1));
            if (currentMaxLen > maxLen) {
                maxLen = currentMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 因为 left、right 坐标上的字符不相等，所以两边都是开区间
        return right - left - 1;
    }


    // 动态规划
    public String second(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new BASE0005().longestPalindrome("ac"));
    }
}
