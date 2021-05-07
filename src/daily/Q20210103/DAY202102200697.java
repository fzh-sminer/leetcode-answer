package daily.Q20210103;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 */
public class DAY202102200697 {

    public int findShortestSubArray(int[] nums) {

        Map<Integer, int[]> map = new HashMap<>();
        int num;

        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (map.containsKey(num)) {
                map.get(num)[0]++;
                map.get(num)[2] = i;
            } else {
                map.put(num, new int[] {1 , i, i});
            }
        }

        int degree = 0, len = 0;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] temp = entry.getValue();

            if (temp[0] > degree) {
                degree = temp[0];
                len = temp[2] - temp[1] + 1;
            }
            if (temp[0] == degree){
                len = Math.min(len, temp[2] - temp[1] + 1);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(new DAY202102200697().findShortestSubArray(new int[] {1,2,2,3,1,4,2}));
    }
}
