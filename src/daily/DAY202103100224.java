package daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class DAY202103100224 {

    public int calculate(String s) {
        return first(s);
    }

    // 返回表达式计算结果和下一个位置索引
    public int first(String s) {
        int sign = 1, operand = 0, result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(char ch: s.toCharArray()){
            switch(ch){
                case ' ':
                    break;
                case '+':
                    result += sign * operand;
                    operand = 0;
                    sign = 1;
                    break;
                case '-':
                    result += sign * operand;
                    operand = 0;
                    sign = -1;
                    break;
                case '(':
                    stack.addLast(result);
                    stack.addLast(sign);
                    sign = 1;
                    result = 0;
                    break;
                case ')':
                    result += sign * operand;
                    result = stack.removeLast() * result + stack.removeLast();
                    operand = 0;
                    // 这一步不重要，因为)后马上就有加减符号覆盖
                    sign = 1;
                    break;
                default:
                    operand = operand * 10 + (ch - '0');
            }
        }

        return result + sign * operand;
    }


    public int second(String s) {
        Deque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        int res = 0, sign = 1, i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '+') {
                sign = ops.peek();
                i++;
            } else if (c == '-') {
                sign = -ops.peek();
                i++;
            } else if (c == '(') {
                ops.push(sign);
                i++;
            } else if (c == ')') {
                ops.pop();
                i++;
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(c = s.charAt(i))) {
                    num = num * 10 + (c - '0');
                    i++;
                }
                res += sign * num;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new DAY202103100224().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
