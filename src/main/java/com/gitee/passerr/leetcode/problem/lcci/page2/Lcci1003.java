package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 * <p>
 * 示例1:
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * <p>
 * 示例2:
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 * <p>
 * 提示:
 * arr 长度范围在[1, 1000000]之间
 * @author xiehai
 * @date 2020/08/10 09:04
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1003 {
    // #region snippet
    public int search(int[] arr, int target) {
        // 记录旋转点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                queue.offer(i);
            }
        }

        // 添加末尾索引
        queue.offer(arr.length);

        // 从索引0位置开始搜索 分区间二分搜索[start, end]
        int start = 0, end;
        while (!queue.isEmpty()) {
            end = queue.poll();
            int index = Arrays.binarySearch(arr, start, end, target);
            if (index >= 0) {
                // 相同数字取索引较小的
                while (index - 1 >= 0 && arr[index - 1] == target) {
                    index--;
                }
                return index;
            }

            start = end;
        }

        return -1;
    }
    // #endregion snippet
}
