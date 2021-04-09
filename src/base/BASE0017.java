package base;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png
 *`
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class BASE0017 {
    String[] map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

        helper(combinations, digits, 0, new StringBuilder());
        return combinations;
    }

    private void helper(List<String> combinations, String digits, int index, StringBuilder path) {
        if (index >= digits.length()) {
            combinations.add(path.toString());
            return;
        }
        String vs = map[digits.charAt(index) - '0'];
        for (char c : vs.toCharArray()) {
            path.append(c);
            helper(combinations, digits, index + 1, path);
            path.deleteCharAt( path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list;
        List<String> res;
        list = new BASE0017().letterCombinations("23");
        res = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        System.out.println(list.containsAll(res) && list.size() == res.size());

        list = new BASE0017().letterCombinations("6249");
        res = Arrays.asList("magw","magx","magy","magz","mahw","mahx","mahy","mahz","maiw","maix","maiy","maiz","mbgw","mbgx","mbgy","mbgz","mbhw","mbhx","mbhy","mbhz","mbiw","mbix","mbiy","mbiz","mcgw","mcgx","mcgy","mcgz","mchw","mchx","mchy","mchz","mciw","mcix","mciy","mciz","nagw","nagx","nagy","nagz","nahw","nahx","nahy","nahz","naiw","naix","naiy","naiz","nbgw","nbgx","nbgy","nbgz","nbhw","nbhx","nbhy","nbhz","nbiw","nbix","nbiy","nbiz","ncgw","ncgx","ncgy","ncgz","nchw","nchx","nchy","nchz","nciw","ncix","nciy","nciz","oagw","oagx","oagy","oagz","oahw","oahx","oahy","oahz","oaiw","oaix","oaiy","oaiz","obgw","obgx","obgy","obgz","obhw","obhx","obhy","obhz","obiw","obix","obiy","obiz","ocgw","ocgx","ocgy","ocgz","ochw","ochx","ochy","ochz","ociw","ocix","ociy","ociz");
        System.out.println(list.containsAll(res) && list.size() == res.size());
    }
}
