package daily.Q20210103;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class DAY202103091047 {

    public String removeDuplicates(String S) {
        return second(S);
    }

    public String first(String S) {
        if (S.length() <= 1) {
            return S;
        }

        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            if (deque.isEmpty()) {
                deque.addLast(chars[i]);
                continue;
            }

            if (deque.getLast() == chars[i]) {
                deque.removeLast();
                continue;
            }

            deque.addLast(chars[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : deque) {
            sb.append(c);
        }

        return sb.toString();
    }

    public String second(String S) {
        if(S.length() == 1) {
            return S;
        }
        char[] chars = S.toCharArray();
        int index = -1;

        for (char c : chars) {
            if (index != -1 && c == chars[index]) {
                index--;
            } else {
                ++index;
                chars[index] = c;
            }
        }
        return new String(chars, 0, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new DAY202103091047().removeDuplicates("abbacaa"));
    }
}
