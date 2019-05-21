package com.sh.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例：
 *  给定 nums = [2, 7, 11, 15], target = 9
 *
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        int[] result = find(nums, target);
        if (result == null) {
            System.out.println("find nothing");
        } else {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }
    }

    private static int[] find(int[] nums, int target) {
        if (nums != null && nums.length >= 2) {
            for (int i = 0; i < nums.length; i++) {
                int diffValue = target - nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    if (diffValue == nums[j]) {
                        int[] array = new int[]{i, j};
                        return array;
                    }
                }
            }
        }
        return null;
    }
}
