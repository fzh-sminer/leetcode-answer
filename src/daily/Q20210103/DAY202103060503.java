package daily.Q20210103;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 */
public class DAY202103060503 {

    public int[] nextGreaterElements(int[] nums) {
        return second(nums);
    }

    public int[] first(int[] nums) {

            int n = nums.length;
        int[] res =  new int[n];
        Arrays.fill(res, -1);
        // 栈存贮的是 nums 数组的元素的下表
        Deque<Integer> stack = new LinkedList<>();

        // 把循环数组「拉直」：复制该序列的前 n-1 个元素拼接在原序列的后面
        for (int i = 0; i < 2 * n - 1; i++) {
            // 获取原数组的真实下标
            int idx = i % n;
            if (stack.isEmpty()) {
                // 如果栈为空，则把当前元素的下标放入栈内
                stack.push(idx);
            } else {
                // 如果栈不为空，则需要判断当前元素和栈顶元素的大小
                if (nums[idx] <= nums[stack.peek()]) {
                    // 如果当前元素小于等于 nums 中栈顶指向的数，说明当前元素的【下一个更大元素】与栈顶所指的元素相同，则把当前元素入栈，
                    stack.push(idx);
                } else {
                    // 如果当前元素大于 nums 中栈顶指向的数，说明当前元素是栈中所存元素中【下一个更大元素】，
                    // 则逐个弹出栈顶元素，直到栈顶指向的数字大于等于当前元素，
                    while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                        // res 根据栈顶记录的下标，记录这个下标所指向元素的【下一个更大元素】
                        res[stack.pop()] = nums[idx];
                    }
                    // 将当前元素压入栈顶，这一步逻辑同：if (nums[idx] <= nums[stack.peek()]) {
                    stack.push(idx);
                }
            }
        }

        return res;
    }

    public int[] second(int[] nums) {
        int n = nums.length;
        int[] res =  new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < 2 * n - 1; i++) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                res[stack.pop()] = nums[idx];
            }
            stack.push(idx);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new DAY202103060503().
                        nextGreaterElements(
                                new int[]{1, 2, 1, 3, 2, 1, 4, 1})));
    }
}
