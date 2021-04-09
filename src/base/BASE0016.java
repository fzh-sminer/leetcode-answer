package base;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class BASE0016 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);
        int t = 0, l = nums.length;

        // 最大的三个数都小于 target
        if((t = nums[l - 1] + nums[l - 2] + nums[l - 3]) <= target){
            return t;
        }
        // 最小的三个数都大于 target
        if((t = nums[0] + nums[1] + nums[2]) >= target){
            return t;
        }

        int v = 0, second, third;

        for (int first = 0; first < l - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            second = first + 1;
            third = l - 1;

            //最小的三个数都大于target
            if((v = nums[first] + nums[second] + nums[second + 1]) > target){
                t = update(v, t, target);
                break;
            }
            //最大的三个数都小于target
            if((v = nums[first] + nums[third - 1] + nums[third]) < target){
                t = update(v, t, target);
                continue;
            }

            while (second < third) {
                v = nums[first] + nums[second] + nums[third];
                if (v == target) {
                    return v;
                }
                t = update(v, t, target);
                if (v > target) {
                    third--;
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else {
                    second++;
                    while (second < third && nums[second] == nums[second -1]) {
                        second++;
                    }
                }
            }
        }
        return t;
    }

    private int update(int tmp, int ans, int target){
        if(Math.abs(tmp - target) < Math.abs(ans - target)){
            ans = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BASE0016().threeSumClosest(new int[] {1,2,5,10,11}, 12));
    }
}
