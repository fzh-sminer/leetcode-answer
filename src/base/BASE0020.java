package base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class BASE0020 {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char first : s.toCharArray()) {
            switch (first) {
                case '(':
                case '[':
                case '{':
                    stack.push(first);
                    break;
                default:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char second = stack.pop();
                    switch (first) {
                        case ')':
                            if (second != '(')
                                return false;
                            break;
                        case ']':
                            if (second != '[')
                                return false;
                            break;
                        case '}':
                            if (second != '{')
                                return false;
                            break;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new BASE0020().isValid("[(){[][]({}{()([])})}]"));
    }
}
