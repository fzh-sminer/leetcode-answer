package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class BASE0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;

        if (len < 4) {
            return list;
        }

        Arrays.sort(nums);

        for (int first = 0; first < len - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }
            if (nums[len - 4] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                break;
            }

            int targetFirst = target - nums[first];

            for (int second = first + 1; second < len - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                if (nums[second] + nums[second + 1] + nums[second + 2] > targetFirst) {
                    break;
                }
                if (nums[len - 3] + nums[len - 2] + nums[len - 1] < targetFirst) {
                    break;
                }

                int third = second + 1, fourth = len - 1;
                int targetSecond = targetFirst - nums[second];

                while (third < fourth) {
                    int targetThird = nums[third] + nums[fourth];

                    if (targetSecond == targetThird) {
                        list.add(Arrays.asList(nums[first], nums[second], nums[third++], nums[fourth--]));
                        while (third < fourth && nums[third] == nums[third - 1]) {
                            third++;
                        }
                        while (third < fourth && nums[fourth] == nums[fourth + 1]) {
                            fourth--;
                        }
                    } else if (targetSecond > targetThird){
                        third++;
                    } else {
                        fourth--;
                    }
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {
        System.out.println(new BASE0018().fourSum(new int[] {1,0,-1,0,-2,2}, 0));
    }
}
