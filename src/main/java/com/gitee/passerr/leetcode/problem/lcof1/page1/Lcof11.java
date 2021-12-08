package com.gitee.passerr.leetcode.problem.lcof1.page1;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * @author xiehai
 * @date 2020/07/04 14:44
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof11 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            int mid = (left + right) >>> 1;

            // 中间节点大于末尾值 说明旋转点在右边部分
            if(numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                // 中间值小于末尾值 说明旋转点在左边部分
                // 相等 继续向中间遍历旋转点
                right = numbers[mid] < numbers[right] ? mid : right - 1;
            }
        }

        return numbers[left];
    }
}
