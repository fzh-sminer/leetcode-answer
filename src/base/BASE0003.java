package base;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class BASE0003 {
    public int lengthOfLongestSubstring(String s) {
        return second(s);
    }

    public int first(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        char[] chars = s.toCharArray();
        int left = 0, right = 0, res = 0;
        Set<Character> cache = new HashSet<>();

        for (; right < n; right++) {
            if (cache.contains(chars[right])) {
                while (left <= right) {
                    if (chars[left] == chars[right]) {
                        left++;
                        break;
                    } else {
                        cache.remove(chars[left]);
                        left++;
                    }
                }
            } else {
                cache.add(chars[right]);
                res = Math.max(res, cache.size());
            }
        }

        return res;
    }

    public int second(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }


        int[] lasts = new int[128]; // 记录字符上一次出现的位置
        for(int i = 0; i < 128; i++) {
            lasts[i] = -1;
        }

        int res = 0;
        int start = 0;  // 窗口开始位置
        int index;  // 当前字符lasts中的位置

        for(int i = 0; i < n; i++) {
            index = s.charAt(i);
            start = Math.max(start, lasts[index] + 1);
            res = Math.max(res, i - start + 1);
            lasts[index] = i;
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new BASE0003().lengthOfLongestSubstring("aau"));
    }
}
