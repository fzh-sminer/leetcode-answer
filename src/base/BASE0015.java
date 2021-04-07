package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class BASE0015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  lists = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return lists;
        }
        Arrays.sort(nums);
        if (nums[0] >= 0 || nums[len - 1] <= 0) {
            return lists;
        }

        // 枚举 a
        for (int first = 0; first < len; first++) {

            // 去重 a
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = len -1;
            int target = -nums[first];

            // 枚举 b
            for (int second = first + 1; second < len; second++) {
                // 去重 b
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 枚举 c
                while (second < third && nums[second] + nums[target] > target) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[second] + nums[target] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new BASE0015().threeSum(new int[] {-1,0,1,2,-1,-4}));
    }
}
