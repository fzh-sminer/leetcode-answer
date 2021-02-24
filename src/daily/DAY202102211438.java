package daily;

import java.util.TreeMap;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 *
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 *
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 */
public class DAY202102211438 {

    public int longestSubarray(int[] nums, int limit) {
        return third(nums, limit);
    }

    public int first(int[] nums, int limit) {

        TreeMap<Integer, Integer> m = new TreeMap<>();
        int left = 0, right = 0, res = 0;

        while (right < nums.length) {
            m.put(nums[right], m.getOrDefault(nums[right], 0) + 1);

            while (m.lastKey() - m.firstKey() > limit) {
                m.put(nums[left], m.get(nums[left]) - 1);
                if (m.get(nums[left]) == 0) {
                    m.remove(nums[left]);
                }
                left ++;
            }

            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;

    }

    public int second(int[] nums, int limit) {
        int n = nums.length;
        int[] maxq = new int[n], minq = new int[n];
        int h1 = 0, t1 = -1, h2 = 0, t2 = -1;
        int l = 0, r = 0;
        int res = 0;

        while(r < n){
            while(h1 <= t1 && nums[maxq[t1]] < nums[r]) {
                t1--;
            }

            while(h2 <= t2 && nums[minq[t2]] > nums[r]) {
                t2--;
            }

            maxq[++t1] = r;
            minq[++t2] = r;
            r++;

            while(nums[maxq[h1]] - nums[minq[h2]] > limit){
                l++;
                if(l > maxq[h1]) {
                    h1++;
                }
                if(l > minq[h2]) {
                    h2++;
                }
            }
            res = Math.max(res, r - l);
        }

        return res;
    }

    public int third(int[] nums, int limit) {
        // l, r 是 nums 的左右指针, len 是 nums 的长度, minL 和 minR 是最小值区间的左右指针, maxL 和 maxR 是最大值区间的左右指针.
        int l = 0, r = 0, len = nums.length, minL = 0, minR = -1, maxL = len, maxR = len - 1;
        // 这个数组用来记录最小值和最大值
        int[] ascending = new int[len];
        // 开始遍历 nums
        while (r < len) {
            // 每一次遍历到的数字, 并更新子集右指针
            int n = nums[r++];

            // 如果遍历到的数字在最小值区间内, 就收缩最小值区间
            while (minR >= minL && n < ascending[minR]) {
                minR--;
            }

            // 如果遍历到的数字在最大值区间内, 就收缩最大值区间
            while (maxR >= maxL && n > ascending[maxL]) {
                maxL++;
            }

            // 拓展最小值和最大值区间
            ascending[++minR] = ascending[--maxL] = n;

            // 判断子集长度是否符合 limit 的要求, 如果不符合要求, 就收缩子集
            if (ascending[maxR] - ascending[minL] > limit) {
                // 开始收缩子集, 使子集左指针右移
                // 如果子集左指针是最小值, 那么最小值将被移除, 所以更新存储最小值的区间
                if (nums[l] == ascending[minL]) {
                    minL++;
                }

                // 如果子集左指针是最大值, 那么最大值将被移除, 所以更新存储最大值的区间
                if (nums[l++] == ascending[maxR]) {
                    maxR--;
                }
            }
        }

        // 返回结果
        return r - l;
    }

    public static void main(String[] args) {
        System.out.println(new DAY202102211438().longestSubarray(new int[] {1,5,6,7,8,10,6,5,6}, 4));
    }
}
