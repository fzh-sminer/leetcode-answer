package daily.Q20210406;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */
public class DAY202106030525 {

    public int findMaxLength(int[] nums) {
        return second(nums);
    }

    public int first(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        int maxLen = 0, cur = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                cur--;
            } else {
                cur++;
            }

            if (map.containsKey(cur)) {
                maxLen = Math.max(i - map.get(cur), maxLen);
            } else {
                map.put(cur, i);
            }
        }

        return maxLen;
    }

    public int second(int[] nums) {
        int res = 0, n = nums.length, preSum = 0;


        int[] hash = new int[2 * n + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        for (int i = 0; i < n; ++i) {
            preSum += nums[i];
            if (preSum == 0) {
                res = i + 1;
            }
            else if (hash[preSum + n] != 0) {
                res = Math.max(res, i + 1 - hash[preSum + n]);
            }
            else {
                hash[preSum + n] = i + 1;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new DAY202106030525().findMaxLength(new int[] {0, 1}));
    }
}
