package base;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class BASE0014 {

    public String longestCommonPrefix(String[] strs) {
        return second(strs);
    }

    public String first(String[] strs) {

        int sn = strs.length;

        if (sn == 0) {
            return "";

        } else if (sn == 1) {
            return strs[0];

        } else {
            String s = strs[0];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 1; j < sn; j++) {
                    if (i >= strs[j].length()) {
                        return strs[j];
                    } else {
                        if (s.charAt(i) != strs[j].charAt(i)) {
                            return s.substring(0, i);
                        }
                    }
                }
            }
            return s;
        }
    }

    public String second(String[] strs) {
        if(strs.length == 0) {
            return "";
        }

        String s = strs[0];

        for(String string : strs){
            while(!string.startsWith(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(new BASE0014().longestCommonPrefix(new String[] {}));
    }
}
