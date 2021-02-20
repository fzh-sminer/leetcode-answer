package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class DAY202102130448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        return third(nums);
    }

    public List<Integer> first(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[nums.length];

        for (int n : nums) {
            map[n - 1]++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public List<Integer> second(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            int i = Math.abs(n) - 1;

            if (nums[i] > 0) {
                nums[i] = -nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public List<Integer> third(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int k = 1;

        for (int num : nums) {
            while (num > k) {
                res.add(k++);
            }
            if (num == k) {
                k++;
            }
        }

        while(k < nums.length + 1) {
            res.add(k++);
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new DAY202102130448().findDisappearedNumbers(new int[] {1,1}));
    }
}
