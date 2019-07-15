package com.gitee.passerr.leetcode.problem.algorithm.page1;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * @author xiehai
 * @date 2019/07/04 13:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }

        // 元素个数
        int result = 1;
        // 当前最大值
        int current = nums[0];
        for (int i = 1; i < length; i++) {
            int value = nums[i];
            // 值想相等或小于最大值 找一个更大的值来填充当前位置
            if (value <= current) {
                // 是否找到比当前最大值大的
                boolean found = false;
                // 从下一位置找比当前值大的
                for (int j = i + 1; j < length; j++) {
                    if (current < nums[j]) {
                        found = true;
                        nums[i] = nums[j];
                        nums[j] = value;
                        value = nums[i];
                        break;
                    }
                }
                if (!found) {
                    // 找不到比当前值大的 结束
                    break;
                }
            }

            // 值比当前大 说明是递增的
            current = value;
            result++;
        }

        return result;
    }
}
