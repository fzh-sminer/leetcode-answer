package base;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 */
public class BASE0007 {

    public int reverse(int x) {
        int rev = 0, pop, max = Integer.MAX_VALUE / 10, min = Integer.MIN_VALUE / 10;

        while (x != 0) {
            pop = x % 10;
            x /= 10;

            if (rev > max || (rev == max && pop > 7)) {
                return 0;
            }
            if (rev < min || (rev == min && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println(new BASE0007().reverse(-123));
    }
}
