package org.yg.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code1 {
    /**
     * 两数之和
     */
    public int[] twoSum(int[] nums, int target) {

        /**
         * 题解：
         * 思路： 先组合再判断 [2,7,11,15] 暴力破解
         * C(4,2) = 6种 [2,7] [2,11] [2,15] [7,11] [7,15] [11,15]
         * 排列A(n,m)=n×（n-1）.（n-m+1）=n!/（n-m）!(n为下标,m为上标,以下同)
         * 组合C(n,m)=P(n,m)/P(m,m) =n!/m!（n-m）!；
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    /**
     * 优化题解
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumOptimization(int[] nums, int target) {
        //map key存值 value存下标
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //如果值等于目标数-num[i] 直接输出 没有就把值存入map 便于后续比对
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return nums;
    }

    public static void main(String[] args) {
        //     * 执行用时: 67 ms
        //     * 内存消耗: 41.3 MB
        System.out.println(Arrays.toString(new Code1().twoSum(new int[]{2, 5, 5, 11}, 10)));

        //     * 执行用时: 1 ms
        //     * 内存消耗: 41.6 MB
        System.out.println(Arrays.toString(new Code1().twoSumOptimization(new int[]{2, 7, 11, 15}, 9)));
    }
}
