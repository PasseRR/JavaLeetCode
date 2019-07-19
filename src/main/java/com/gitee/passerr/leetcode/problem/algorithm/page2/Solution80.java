package com.gitee.passerr.leetcode.problem.algorithm.page2;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * @author xiehai
 * @date 2019/07/19 15:18
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see com.gitee.passerr.leetcode.problem.algorithm.page1.Solution26
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }

        // 当前遍历值及数量
        int current = nums[0], count = 1;
        for (int i = 1; i < length; i++) {
            int value = nums[i];
            if (value > current) {
                // 重置最大值及计数
                current = value;
                count = 1;
            } else {
                // 只允许出现两次
                if (value == current && count == 1) {
                    count++;
                } else {
                    boolean found = false;
                    // 找一个比当前值大的值替换当前位置的值
                    for (int j = i + 1; j < length; j++) {
                        // 计数为2时必须比当前大 计数为1时大于等于均可
                        if ((count == 2 && nums[j] > current) || (count == 1 && nums[j] >= current)) {
                            nums[i] ^= nums[j];
                            nums[j] ^= nums[i];
                            nums[i] ^= nums[j];
                            found = true;
                            // 大于当前值时更新当前最大值 重置计数
                            if (nums[i] > current) {
                                current = nums[i];
                                count = 1;
                            } else {
                                // 等于当前值 计数加1
                                count++;
                            }
                            break;
                        }
                    }
                    // 没有找到 说明i之前的元素为去重后的
                    if (!found) {
                        return i;
                    }
                }
            }
        }

        return length;
    }
}
