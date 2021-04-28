package daily;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 *
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 *
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 */
public class DAY202104280633 {

    public boolean judgeSquareSum(int c) {

        int t = (int) Math.ceil(Math.sqrt(c));

        if (c == t) {
            return true;
        }

        int l = 0, r = t;

        while (l <= r) {
            int sum = l * l + r * r;

            if (sum > c) {
                r--;
            } else if (sum == c) {
                return true;
            }  else {
                l++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DAY202104280633().judgeSquareSum(5));
        System.out.println(new DAY202104280633().judgeSquareSum(3));
        System.out.println(new DAY202104280633().judgeSquareSum(4));
        System.out.println(new DAY202104280633().judgeSquareSum(2));
        System.out.println(new DAY202104280633().judgeSquareSum(101));
    }
}
